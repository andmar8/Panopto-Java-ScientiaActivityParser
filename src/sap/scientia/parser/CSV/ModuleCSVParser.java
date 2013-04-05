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
package sap.scientia.parser.CSV;

//java - io
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//java - util
import java.util.ArrayList;
import java.util.List;

public class ModuleCSVParser
{
    private BufferedReader bufRdr;

    private ModuleCSVParser(){};
    public ModuleCSVParser(String pathAndFile) throws FileNotFoundException
    {
        System.out.print("Attempting to open file "+pathAndFile);
        this.bufRdr = new BufferedReader(new FileReader(new File(pathAndFile)));
        System.out.println(", open");
    }

    public List<String> parseCSV() throws IOException
    {
        System.out.println("Attempting to parse csv");
        List<String> modules = new ArrayList<String>();
 	
	String line = null;
        while((line = bufRdr.readLine()) != null)
	{
            if(!line.isEmpty())
            {
                line = line.replace("\"","");
                System.out.println("Module found: "+line);
                modules.add(line);
            }
	}
        return modules;
    }
}
