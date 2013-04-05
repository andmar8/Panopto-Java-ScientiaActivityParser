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
package sap.panopto.writer;

//java - io
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//java - util
import java.util.Iterator;

import sap.panopto.Session;

public class SessionWriter
{
    private BufferedWriter bufWrtr;

    private SessionWriter(){};
    public SessionWriter(String pathAndFile) throws IOException
    {
        System.out.print("Attempting to open file "+pathAndFile);
        this.bufWrtr = new BufferedWriter(new FileWriter(new File(pathAndFile)));
        System.out.println(", open");
    }

    public void writeCSV(Iterator<Session> i) throws IOException
    {
        System.out.print("Attempting to write csv");
        Session s;
        bufWrtr.write("\"name\",\"folderExternalId\",\"start\",\"end\",\"location\",\"externalId\"\n");
        while(i.hasNext())
        {
            s = i.next();
            bufWrtr.write("\""+s.getName()+"\",\""+s.getFolderExternalId()+"\",\""+s.getStartDateTime()+"\",\""+s.getEndDateTime()+"\",\""+s.getLocation()+"\",\""+s.getExternalId()+"\"");
            bufWrtr.newLine();
        }
        bufWrtr.flush();
        bufWrtr.close();
        System.out.println(", done");
    }
}
