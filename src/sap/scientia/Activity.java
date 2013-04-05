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
package sap.scientia;

//org
import org.w3c.dom.Node;

public class Activity extends AbstractScientiaObject
{
    private String activityType_Hostkey;
    private String activityType_ID;
    private String activityType_Name;
    private String activityType_Usertext5;
    private String actSize;
    private String description;
    private String department_Hostkey;
    private String department_ID;
    private String department_Name;
    private String duration;
    private String hostKey;
    private String id;
    private String lastChanged;
    private String module_Description;
    private String module_Hostkey;
    private String module_ID;
    private String module_Name;
    private String name;
    private String locationCapacity;
    private String locationDescription;
    private String locationName;
    private String locationHostkey;
    private String plannedSize;
    private String realSize;
    private String scheduled;
    private String scheduledDay;
    private String scheduledEndTime;
    private String scheduledStartTime;
    private String section_id;
    private String size;
    private String sizeLink;
    private String startDate;
    private String suggestedDays;
    private String type;
    private String usertext1;
    private String usertext2;
    private String usertext3;
    private String usertext4;
    private String usertext5;
    private String webtag;
    private String weekPattern;
    private String weekLabels;

    public Activity(Node a)
    {
        this.activityType_Hostkey = getStringFromNode(a,"ActivityType_Hostkey");
        this.activityType_ID = getStringFromNode(a,"ActivityType_ID");
        this.activityType_Name = getStringFromNode(a,"ActivityType_Name");
        this.activityType_Usertext5 = getStringFromNode(a,"ActivityType_Usertext5");
        this.actSize = getStringFromNode(a,"ActSize");
        this.description = getStringFromNode(a,"Description");
        this.department_ID = getStringFromNode(a,"Department_ID");
        this.department_Name = getStringFromNode(a,"Department_Name");
        this.department_Hostkey = getStringFromNode(a,"Department_Hostkey");
        this.duration = getStringFromNode(a,"Duration");
        this.hostKey = getStringFromNode(a,"HostKey");
        this.id = getStringFromNode(a,"Id");
        this.lastChanged = getStringFromNode(a,"lastChanged");
        this.locationCapacity = getStringFromNode(a,"LocationCapacity");
        this.locationDescription = getStringFromNode(a,"LocationDescription");
        this.locationName = getStringFromNode(a,"LocationName");
        this.locationHostkey = getStringFromNode(a,"LocationHostKey");
        this.module_Description = getStringFromNode(a,"Module_Description");
        this.module_Hostkey = getStringFromNode(a,"Module_Hostkey");
        this.module_ID = getStringFromNode(a,"Module_ID");
        this.module_Name = getStringFromNode(a,"Module_Name");
        this.name = getStringFromNode(a,"Name");
        this.plannedSize = getStringFromNode(a,"PlannedSize");
        this.realSize = getStringFromNode(a,"RealSize");
        this.scheduled = getStringFromNode(a,"Scheduled");
        this.scheduledDay = getStringFromNode(a,"ScheduledDay");
        this.scheduledEndTime = getStringFromNode(a,"ScheduledEndTime");
        this.scheduledStartTime = getStringFromNode(a,"ScheduledStartTime");
        this.section_id = getStringFromNode(a,"section_id");
        this.size = getStringFromNode(a,"Size");
        this.sizeLink = getStringFromNode(a,"SizeLink");
        this.startDate = getStringFromNode(a,"StartDate");
        this.suggestedDays = getStringFromNode(a,"SuggestedDays");
        this.type = getStringFromNode(a,"Type");
        this.usertext1 = getStringFromNode(a,"Usertext1");
        this.usertext2 = getStringFromNode(a,"Usertext2");
        this.usertext3 = getStringFromNode(a,"Usertext3");
        this.usertext4 = getStringFromNode(a,"Usertext4");
        this.usertext5 = getStringFromNode(a,"Usertext5");
        this.webtag = getStringFromNode(a,"webtag");
        this.weekLabels = getStringFromNode(a,"WeekLabels");
        this.weekPattern = getStringFromNode(a,"WeekPattern");
    }

    public String getActSize()
    {
        return actSize;
    }

    public void setActSize(String actSize)
    {
        this.actSize = actSize;
    }

    public String getActivityType_Hostkey()
    {
        return activityType_Hostkey;
    }

    public void setActivityType_Hostkey(String activityType_Hostkey)
    {
        this.activityType_Hostkey = activityType_Hostkey;
    }

    public String getActivityType_ID()
    {
        return activityType_ID;
    }

    public void setActivityType_ID(String activityType_ID)
    {
        this.activityType_ID = activityType_ID;
    }

    public String getActivityType_Name()
    {
        return activityType_Name;
    }

    public void setActivityType_Name(String activityType_Name)
    {
        this.activityType_Name = activityType_Name;
    }

    public String getActivityType_Usertext5()
    {
        return activityType_Usertext5;
    }

    public void setActivityType_Usertext5(String activityType_Usertext5)
    {
        this.activityType_Usertext5 = activityType_Usertext5;
    }

    public String getDepartment_Hostkey(
            ) {
        return department_Hostkey;
    }

    public void setDepartment_Hostkey(String department_Hostkey)
    {
        this.department_Hostkey = department_Hostkey;
    }

    public String getDepartment_ID()
    {
        return department_ID;
    }

    public void setDepartment_ID(String department_ID)
    {
        this.department_ID = department_ID;
    }

    public String getDepartment_Name()
    {
        return department_Name;
    }

    public void setDepartment_Name(String department_Name)
    {
        this.department_Name = department_Name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDuration()
    {
        return duration;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    public String getHostKey()
    {
        return hostKey;
    }

    public void setHostKey(String hostKey)
    {
        this.hostKey = hostKey;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getLastChanged()
    {
        return lastChanged;
    }

    public void setLastChanged(String lastChanged)
    {
        this.lastChanged = lastChanged;
    }

    public String getLocationCapacity()
    {
        return locationCapacity;
    }

    public void setLocationCapacity(String locationCapacity)
    {
        this.locationCapacity = locationCapacity;
    }

    public String getLocationDescription()
    {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription)
    {
        this.locationDescription = locationDescription;
    }

    public String getLocationName()
    {
        return locationName;
    }

    public void setLocationName(String locationName)
    {
        this.locationName = locationName;
    }

    public String getLocationHostkey()
    {
        return locationHostkey;
    }

    public void setLocationHostkey(String locationHostkey)
    {
        this.locationHostkey = locationHostkey;
    }
    
    public String getModule_Description()
    {
        return module_Description;
    }

    public void setModule_Description(String module_Description)
    {
        this.module_Description = module_Description;
    }

    public String getModule_Hostkey()
    {
        return module_Hostkey;
    }

    public void setModule_Hostkey(String module_Hostkey)
    {
        this.module_Hostkey = module_Hostkey;
    }

    public String getModule_ID()
    {
        return module_ID;
    }

    public void setModule_ID(String module_ID)
    {
        this.module_ID = module_ID;
    }

    public String getModule_Name()
    {
        return module_Name;
    }

    public void setModule_Name(String module_Name)
    {
        this.module_Name = module_Name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPlannedSize()
    {
        return plannedSize;
    }

    public void setPlannedSize(String plannedSize)
    {
        this.plannedSize = plannedSize;
    }

    public String getRealSize()
    {
        return realSize;
    }

    public void setRealSize(String realSize)
    {
        this.realSize = realSize;
    }

    public String getScheduled()
    {
        return scheduled;
    }

    public void setScheduled(String scheduled)
    {
        this.scheduled = scheduled;
    }

    public String getScheduledDay()
    {
        return scheduledDay;
    }

    public void setScheduledDay(String scheduledDay)
    {
        this.scheduledDay = scheduledDay;
    }

    public String getScheduledEndTime()
    {
        return scheduledEndTime;
    }

    public void setScheduledEndTime(String scheduledEndTime)
    {
        this.scheduledEndTime = scheduledEndTime;
    }

    public String getScheduledStartTime()
    {
        return scheduledStartTime;
    }

    public void setScheduledStartTime(String scheduledStartTime)
    {
        this.scheduledStartTime = scheduledStartTime;
    }

    public String getSection_id()
    {
        return section_id;
    }

    public void setSection_id(String section_id)
    {
        this.section_id = section_id;
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public String getSizeLink()
    {
        return sizeLink;
    }

    public void setSizeLink(String sizeLink)
    {
        this.sizeLink = sizeLink;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getSuggestedDays()
    {
        return suggestedDays;
    }

    public void setSuggestedDays(String suggestedDays)
    {
        this.suggestedDays = suggestedDays;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getUsertext1()
    {
        return usertext1;
    }

    public void setUsertext1(String usertext1)
    {
        this.usertext1 = usertext1;
    }

    public String getUsertext2()
    {
        return usertext2;
    }

    public void setUsertext2(String usertext2)
    {
        this.usertext2 = usertext2;
    }

    public String getUsertext3()
    {
        return usertext3;
    }

    public void setUsertext3(String usertext3)
    {
        this.usertext3 = usertext3;
    }

    public String getUsertext4()
    {
        return usertext4;
    }

    public void setUsertext4(String usertext4)
    {
        this.usertext4 = usertext4;
    }

    public String getUsertext5()
    {
        return usertext5;
    }

    public void setUsertext5(String usertext5)
    {
        this.usertext5 = usertext5;
    }

    public String getWebtag()
    {
        return webtag;
    }

    public void setWebtag(String webtag)
    {
        this.webtag = webtag;
    }

    public String getWeekLabels()
    {
        return weekLabels;
    }

    public void setWeekLabels(String weekLabels)
    {
        this.weekLabels = weekLabels;
    }

    public String getWeekPattern()
    {
        return weekPattern;
    }

    public void setWeekPattern(String weekPattern)
    {
        this.weekPattern = weekPattern;
    }

}
