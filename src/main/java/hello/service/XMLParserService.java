package hello.service;

import org.w3c.dom.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hello.model.XMLElementType;
import org.springframework.web.multipart.MultipartFile;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import org.xml.sax.SAXException;

public class XMLParserService {
    private static final Logger logger = LoggerFactory.getLogger(XMLParserService.class);

    public static Object _parse_etree_node_leaf(Element element) {
        XMLElementType etype = new XMLElementType(element.getAttribute("type"));
        String raw = element.getAttribute("value");
        try {
            return etype.parseElementValue(raw);
        } catch (Exception e) {
            logger.error(String.format("Leaf parse failed: %s type=%s", element, etype), e);
            throw e;
        }
    }

    /**
     * Parses an XML file from a MultipartFile and converts it to a JSONType object.
     *
     * @param file the MultipartFile containing the XML data
     * @return JSONType object representing the parsed XML
     * @throws XMLParseError if an error occurs during XML parsing
     */
    public static JSONType parseXmlFromFile(MultipartFile file) throws XMLParseError {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Element rootElement = builder.parse(file.getInputStream()).getDocumentElement();
            return XMLParser._parse_etree_to_json_type(rootElement);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new XMLParseError("Error parsing XML file", e);
        }
    }
}