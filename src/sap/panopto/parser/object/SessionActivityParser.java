    /*
     * This file is part of Panopto-Java-ScientiaActivityParser.
     * 
     * Panopto-Java-ScientiaActivityParser is free software: you can redistribute it and/or modify
     * it under the terms of the GNU General Public License as published by
     * the Free Software Foundation, either version 3 of the License, or
     * (at your option) any later version.
     * 
     * Panopto-Java-ScientiaActivityParser is distributed in the hope that it will be useful,
     * but WITHOUT ANY WARRANTY; without even the implied warranty of
     * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     * GNU General Public License for more details.
     * 
     * You should have received a copy of the GNU General Public License
     * along with Panopto-Java-ScientiaActivityParser.  If not, see <http://www.gnu.org/licenses/>.
     * 
     * Copyright: Andrew Martin, Newcastle University
     * 
     */
package sap.panopto.parser.object;

//java - text
import java.text.ParseException;
import java.text.SimpleDateFormat;

//java - util
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

//sap
import sap.panopto.Session;
import sap.scientia.Activity;

public class SessionActivityParser
{
    private static Calendar getCalendarFromScientiaDateTime(String dateTime) throws ParseException
    {
        Calendar c = Calendar.getInstance();
        c.setTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(getPanoptoDateTimeForScientiaDateTime(dateTime)));
        return c;
    }

    private static String getPanoptoDateTimeForScientiaDateTime(String scientiaDateTime)
    {
        return scientiaDateTime.substring(0,19);
    }

    private static String getPanoptoDateTimeFromCalendar(Calendar c)
    {
        try{return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());}catch(Exception e){return "";}
    }

    private static List<Integer> getRepeatingWeeks(String weekPattern)
    {
        List<Integer> repeatingWeeks = new ArrayList<Integer>();
        int week = 0;
        while((week=weekPattern.indexOf("1", week))!=-1)
        {
            repeatingWeeks.add(++week);
        }
        return repeatingWeeks;
     }

    public static List<Session> parse(Activity a,/* Iterator<ModuleMembership> mmi,*/ String prefix)
    {
        List<Session> sl = new ArrayList<Session>();
        List<Integer> rwl = getRepeatingWeeks(a.getWeekPattern());
        Iterator<Integer> rwi = null;
        Calendar startDate = null; Calendar tempCal = null; Calendar startTime = null; Calendar endTime = null;
        int rwOffset = 0; int numberOfRepeatingWeeks = rwl.size();

        //The first repeating week
        try
        {
            System.out.println("Parsing to session: "+a.getModule_Hostkey()+" - "+a.getName());
            startDate = getCalendarFromScientiaDateTime(a.getStartDate());
            startTime = getCalendarFromScientiaDateTime(a.getScheduledStartTime());
            endTime = getCalendarFromScientiaDateTime(a.getScheduledEndTime());

            /* IF(There is more than one week active then parse out a
             * schedule for every active week)
             * ELSE(There are no repeating weeks then just add it as a
             * standard one week activity)
             */
            if(numberOfRepeatingWeeks>1)
            {
                rwOffset = rwl.get(0);
                rwi = rwl.iterator();
                //Iterate to get schedules for all repeating weeks
                while(rwi.hasNext())
                {
                    tempCal = ((Calendar)startDate.clone());
                    tempCal.add(Calendar.WEEK_OF_YEAR, rwi.next()-rwOffset);
                    sl.add(setSessionStartAndEndDateTimes(new Session(a, prefix), tempCal, startTime, endTime));
                }
            }
            else
            {
                sl.add(setSessionStartAndEndDateTimes(new Session(a, prefix), startDate, startTime, endTime));
            }
        }
        catch(ParseException pe)
        {
            System.err.println("Error whilst parsing Activity to Schedule "+pe.getMessage());
        }
        return sl;
    }

    private static String setDateTimesTimeUsingDateTime(String destinationDateTime, String sourceDateTime)
    {
        return destinationDateTime.substring(0,11)+sourceDateTime.substring(11, 19);
    }

    private static Session setSessionStartAndEndDateTimes(Session s, Calendar startDateTime, Calendar startTime, Calendar endTime)
    {
        String tempDateTime = getPanoptoDateTimeFromCalendar(startDateTime);
        s.setStartDateTime(setDateTimesTimeUsingDateTime(tempDateTime,getPanoptoDateTimeFromCalendar(startTime)));
        s.setEndDateTime(setDateTimesTimeUsingDateTime(tempDateTime,getPanoptoDateTimeFromCalendar(endTime)));
        return s;
    }
}
