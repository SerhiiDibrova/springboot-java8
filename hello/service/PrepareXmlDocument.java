

package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

@Service
public class PrepareXmlDocument {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrepareXmlDocument.class);

    public Document prepareXmlDocument(String xmlData) {
        if (xmlData == null || xmlData.isEmpty()) {
            LOGGER.error("Input xmlData is null or empty");
            throw new IllegalArgumentException("Input xmlData is null or empty");
        }

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xmlData));
            return builder.parse(is);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            LOGGER.error("Error parsing XML data", e);
            throw new RuntimeException("Error parsing XML data", e);
        }
    }
}