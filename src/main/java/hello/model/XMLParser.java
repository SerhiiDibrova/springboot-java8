package hello.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.json.JSONObject;
import org.lxml.etree;
import org.lxml.etree._Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.SAXException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class XMLParser {
    private static final Logger logger = LoggerFactory.getLogger(XMLParser.class);

    public JSONType _parse_etree_node_leaf(Element element) {
        try {
            String type = element.getAttribute("type");
            String value = element.getAttribute("value");
            XMLElementType xmlElementType = new XMLElementType(type);
            // Process value as needed
            return new JSONType(); // Replace with actual JSONType creation logic
        } catch (Exception e) {
            logger.error("Error parsing leaf node", e);
            throw new RuntimeException("Parsing error", e);
        }
    }

    public XMLElementType parse_json_to_element(JSONType data) {
        return _parse_json_data_to_etree(data);
    }

    public byte[] to_pretty_xml(_Element element, String encoding) {
        try {
            return etree.tostring(element, true, encoding);
        } catch (Exception e) {
            logger.error("Error converting to pretty XML", e);
            throw new RuntimeException("Conversion error", e);
        }
    }

    public JSONType _parse_etree_to_json_type(Element node) {
        try {
            JSONType jsonType = new JSONType();
            // Logic to convert XML element to JSONType
            NodeList children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Element child = (Element) children.item(i);
                jsonType.add(_parse_etree_to_json_type(child));
            }
            return jsonType; // Replace with actual JSONType creation logic
        } catch (Exception e) {
            logger.error("Error parsing XML to JSON", e);
            throw new RuntimeException("Parsing error", e);
        }
    }

    public JSONType _parse_etree_to_json_type(InputStream inputStream) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);
            return _parse_etree_to_json_type(document.getDocumentElement());
        } catch (Exception e) {
            logger.error("Error parsing XML from InputStream", e);
            throw new RuntimeException("Parsing error", e);
        }
    }

    public JSONType parse_xml_from_file(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            return _parse_etree_to_json_type(inputStream);
        } catch (IOException e) {
            logger.error("Error reading file", e);
            throw new RuntimeException("File read error", e);
        }
    }

    public JSONType parse_xml_from_string(String xml_str) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(xml_str.getBytes()));
            return _parse_etree_to_json_type(document.getDocumentElement());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error("Error parsing XML from string", e);
            throw new RuntimeException("Parsing error", e);
        }
    }

    public Document json_to_xml(JSONObject json) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            // Logic to convert JSONObject to Document
            return document;
        } catch (Exception e) {
            logger.error("Error converting JSON to XML", e);
            throw new RuntimeException("Conversion error", e);
        }
    }

    private XMLElementType _parse_json_data_to_etree(JSONType data) {
        // Implementation for converting JSONType to XMLElementType
        return new XMLElementType(); // Replace with actual conversion logic
    }
}