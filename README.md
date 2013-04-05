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
java -jar ScientiaActivityParser.jar modules.csv http://timetableserver.example.com:8080/Scientia/TimetableXMLReportEngine/Default.aspx?LocationsActivitiesAndSchedulesEndpoint&module= http://timetableserver.example.com:8080/Scientia/TimetableXMLReportEngine/Default.aspx?modulesForAStaffIdEndpoint&moduleid= sessionsToSchedule.csv Q1213-
</pre>

NOTE: See the bottom section of [What are external Id's](https://github.com/andmar8/Panopto-PHP-Booking-Engine#what-are-external-ids) to understand why we sometimes need the ability to prefix our module identifiers in the output

Format of the CSV
-----------------

To use the Activity Parsers you need to specify a CSV file in the following format...

<table>
<tr>
	<th>Module id in the timetable system to get activities, in lecture capture enabled locations, for</th>
</tr>
<tr>
	<td>COM1001</td>
</tr>
<tr>
	<td>COM1002</td>
</tr>
<tr>
	<td>COM1003</td>
</tr>
<table>

Or, as it would be in the csv....

<pre>
COM1001
COM1002
COM1003
</pre>

* Notice in this csv it does not include a header, just write your module, start a new line, write a module, start a new line and so on...
* See [Format of the CSV](https://github.com/andmar8/Panopto-Java-BlockBooker#format-of-the-csv) in the Block Booker to see what format the resultant CSV is in