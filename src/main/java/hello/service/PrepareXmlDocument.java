

package hello.service;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class PrepareXmlDocument {
    public Document prepareXmlDocument(String xmlString) throws ParserConfigurationException, IOException, SAXException {
        if (xmlString == null || xmlString.isEmpty()) {
            throw new IllegalArgumentException("Input xmlString cannot be null or empty");
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xmlString));
            return builder.parse(is);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException("Error parsing XML string", e);
        }
    }
}