

package hello.declaration;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PrepareXmlDocumentSystemProcedure {
    public int prepareXmlDocument(XmlDataDTO xmlDataDTO) {
        if (xmlDataDTO == null) {
            throw new NullPointerException("XmlDataDTO is null");
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            ByteArrayInputStream input = new ByteArrayInputStream(xmlDataDTO.getData().getBytes(StandardCharsets.UTF_8));
            Document document = builder.parse(input);
            return document.hashCode();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("Failed to configure DocumentBuilderFactory", e);
        } catch (SAXException e) {
            throw new RuntimeException("Failed to parse XML data", e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read XML data", e);
        }
    }
}