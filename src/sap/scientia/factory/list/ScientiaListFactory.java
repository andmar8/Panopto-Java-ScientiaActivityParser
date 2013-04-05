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
package sap.scientia.factory.list;

//java - util
import java.util.ArrayList;
import java.util.List;

//org
import org.w3c.dom.NodeList;

//sap
import sap.scientia.factory.enums.ScientiaObjectType;
import sap.scientia.factory.object.ScientiaObjectFactory;

public class ScientiaListFactory
{
    public static List getScientiaList(ScientiaObjectType type, NodeList nl)
    {
        List l = new ArrayList();
        for(int i=0;i<nl.getLength();i++)
        {
            System.err.println("Found "+type.getDisplayName());
            l.add(ScientiaObjectFactory.getScientiaObject(type,(nl.item(i))));
        }
        return l;
    }
}
