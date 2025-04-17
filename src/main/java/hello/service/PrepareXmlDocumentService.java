

package hello.service;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import hello.dto.XmlDataDTO;
import hello.system.procedure.PrepareXmlDocumentSystemProcedure;

public class PrepareXmlDocumentService {

    public int prepareXmlDocument(XmlDataDTO xmlDataDTO) {
        if (xmlDataDTO == null) {
            throw new NullPointerException("XmlDataDTO object is null");
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(xmlDataDTO.getXmlData().getBytes()));
            PrepareXmlDocumentSystemProcedure procedure = new PrepareXmlDocumentSystemProcedure();
            return procedure.execute(document);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("Error configuring parser", e);
        } catch (SAXException e) {
            throw new RuntimeException("Error parsing XML", e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading XML", e);
        } catch (Exception e) {
            throw new RuntimeException("Error executing procedure", e);
        }
    }
}