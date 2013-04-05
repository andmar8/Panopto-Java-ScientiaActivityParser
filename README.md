Panopto-Java-ScientiaActivityParser
===================================

Using this tool we automatically create the csv required by Block Booker from activities in our timetabling system, given a little bit of tweaking this could be adapted to any other timetabling system... similarly to the booking engine, if you were to replace the scientia client sections with an interconnect to your timetabling system then the rest of the code will do the heavy lifting of talking to the Panopto server from there.

The code requires the [Panopto-Java-Util](https://github.com/andmar8/Panopto-Java-Util) Library

How to use the jar
------------------

<pre>
java -jar ScientiaActivityParser.jar (input modules .csv file) (scientia activity endpoint) (scientia moduleMembership endpoint) (output .csv file) ([Optional: module prefix to append to output])
</pre>

For example...

<pre>
java -jar ScientiaActivityParser.jar modules.csv http://timetableserver.example.com:8080/Scientia/TimetableXMLReportEngine/Default.aspx?LocationsActivitiesAndSchedulesEndpoint&module= http://timetableserver.example.com:8080/Scientia/TimetableXMLReportEngine/Default.aspx?modulesForAStaffIdEndpoint&moduleid= sessionsToSchedule.csv
</pre>

Format of the CSV
-----------------

To use the block booker you need to specify a CSV file in the following format...

<table>
<tr>
	<th>name</th>
	<th>folderExternalId</th>
	<th>start</th>
	<th>end</th>
	<th>location</th>
	<th>externalId</th>
</tr>
<tr>
	<td>COM1001/L01</td>
	<td>Q1213-COM1001</td>
	<td>02/10/2012 13:00</td>
	<td>02/10/2012 14:00</td>
	<td>BLDG.1.10</td>
	<td>#SPLUS123456</td>
</tr>
<table>

Or, as it would be in the csv....

<pre>
"name","folderExternalId","start","end","location","externalId"
"COM1001/L01","Q1213-COM1001","02/10/2012 13:00","02/10/2012 14:00","BLDG.1.10","#SPLUS123456"
</pre>

* The name can be anything you like, just make sure to escape double quotes and commas
* The start and end MUST be in DD/MM/YYYY HH:mm
* You need to be using external Id's for the folder and location or the block booker will not be able to work out which folder to assign the recording to or which remote recorders to use
* See the [Booking Engine](https://github.com/andmar8/Panopto-PHP-Booking-Engine) for more about external Id's
