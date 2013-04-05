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
package sap;

//java - io
import java.io.IOException;

//java - net
import java.net.MalformedURLException;
import java.net.URL;

//java - util
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//javax
import javax.xml.parsers.ParserConfigurationException;

//org
import org.xml.sax.SAXException;

//sap - scientia
import sap.panopto.Session;
import sap.panopto.parser.object.SessionActivityParser;
import sap.panopto.writer.SessionWriter;
import sap.scientia.Activity;
import sap.scientia.parser.CSV.ModuleCSVParser;
import sap.scientia.parser.XML.ActivityXMLParser;

public class Main
{
    public static void main(String[] args)
    {
        //args parsing here...
        if(args.length<3 || args.length>4 || args[0].equalsIgnoreCase("--help") || args[0].equalsIgnoreCase("-h") || args[0].equalsIgnoreCase("-help") || args[0].equalsIgnoreCase("--h") || args[0].equalsIgnoreCase("/?"))
        {
            System.out.println("\nUsage: java -jar ScientiaActivityParser.jar <input modules .csv file>" +
                                                                    "\n\t\t\t\t\t<scientia activity endpoint>" +
                                                                    "\n\t\t\t\t\t<output .csv file>"+
                                                                    "\n\t\t\t\t\t[Optional: module prefix to append to output]");
            System.out.println("\nExample: java -jar ScientiaActivityParser.jar"+
            "\n\t\tmodules.csv"+
            "\n\t\t\"http://timetableservices.ncl.ac.uk:8080/Scientia/XMLReportEngine/Default.aspx?dataset=lectlaslink&module=\""+
            "\n\t\tschedulesToBook.csv");
            return;
        }
        System.out.println();
        new Main().parseToFile(args[0], args[1], args[2], args.length==4?args[3]:"");
    }

    public void parseToFile(String inputFile, String scientiaActivityEndPoint, /*String scientiaModuleMembershipEndPoint,*/ String outputFile, String prefix)
    {
        try
        {
            List<String> ml = parseModules(inputFile);
            writeSessions(parseSessions(parseActivities(ml.iterator(),scientiaActivityEndPoint)/*,parseModuleMemberships(ml.iterator(), scientiaModuleMembershipEndPoint)*/,prefix),outputFile);
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    private Iterator<Activity> parseActivities(Iterator<String> mi, String scientiaEndPoint)
    {
        List<Activity> l = new ArrayList<Activity>();
        //Parse in the activities
        while(mi.hasNext())
        {
            try
            {
                l.addAll(new ActivityXMLParser().parse(new URL(scientiaEndPoint+mi.next()).openStream()));
            }
            catch(MalformedURLException murle)
            {
                System.err.println("Could not open scientia end point "+murle.getMessage());
            }
            catch(ParserConfigurationException pce)
            {
                System.err.println("Parsing configuration error "+pce.getMessage());
            }
            catch(SAXException se)
            {
                System.err.println("Error whilst parsing "+se.getMessage());
            }
            catch(IOException ioe)
            {
                System.err.println("Error whilst reading XML "+ioe.getMessage());
            }
        }
        System.err.println("Activities found "+l.size());
        return l.iterator();
    }

    private List<String> parseModules(String inputFile) throws Exception
    {
        //Parse in the module codes
        try
        {
            return new ModuleCSVParser(inputFile).parseCSV();
        }
        catch(IOException ioe)
        {
            throw new Exception("\nError whilst reading in modules "+ioe.getMessage());
        }
    }

    private Iterator<Session> parseSessions(Iterator<Activity> ai, String prefix)
    {
        //Translate activities to schedules
        List<Session> l = new ArrayList<Session>();
        while(ai.hasNext())
        {
            l.addAll(SessionActivityParser.parse(ai.next(),prefix));
        }
        System.err.println("Sessions found "+l.size());
        return l.iterator();
    }

    private void writeSessions(Iterator<Session> si, String outputFile) throws Exception
    {
        //Write out the sessions
        try
        {
            new SessionWriter(outputFile).writeCSV(si);
        }
        catch(IOException ioe)
        {
            throw new Exception("Error whilst writing sessions "+ioe.getMessage()+" to "+outputFile);
        }
    }
}
