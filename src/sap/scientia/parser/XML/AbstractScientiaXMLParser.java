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
package sap.scientia.parser.XML;

//java - io
import java.io.InputStream;
import java.io.IOException;

//java - util
import java.util.List;

//javax
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//org
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//sap
import sap.scientia.factory.enums.ScientiaObjectType;

public abstract class AbstractScientiaXMLParser
{
    protected ScientiaObjectType type = ScientiaObjectType.OBJECTDOESNOTEXIST;

    protected static NodeList getNodeListForType(String type, InputStream scientiaEndPointXMLStream) throws IOException, ParserConfigurationException, SAXException
    {
        Document d = parseXmlDocument(scientiaEndPointXMLStream);
        d.normalize();
        return d.getElementsByTagName(type);
    }

    protected static Document parseXmlDocument(InputStream scientiaEndPointXMLStream) throws IOException, ParserConfigurationException, SAXException
    {
        System.err.println("Attempting to connect to scientia end point");
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(scientiaEndPointXMLStream);
    }

    public abstract List parse(InputStream scientiaEndPointXMLStream) throws IOException, ParserConfigurationException, SAXException;
}
