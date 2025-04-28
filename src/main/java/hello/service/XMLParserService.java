package hello.service;

import hello.model.XMLElementType;
import hello.declaration.XMLParseError;
import hello.declaration.JSONType;
import org.lxml.etree._Element;
import org.w3c.dom.Element;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLParserService {
    private static final Logger logger = LoggerFactory.getLogger(XMLParserService.class);

    public static Object parseValue(XMLElementType etype, String value) {
        return etype.parse_element_value(value);
    }

    private static Object _parse_etree_node_leaf(Element node) throws XMLParseError {
        try {
            String typeAttr = node.getAttribute("type");
            XMLElementType etype = XMLElementType.valueOf(typeAttr);
            String raw = node.getAttribute("value");
            return parseValue(etype, raw);
        } catch (Exception e) {
            logger.error("Error parsing node leaf: {}", e.getMessage());
            throw new XMLParseError("Error parsing node leaf", e);
        }
    }

    public static _Element parse_json_to_element(JSONType data) {
        return XMLParser._parse_json_data_to_etree(data);
    }

    public static byte[] to_pretty_xml(_Element element, String encoding) {
        try {
            return etree.tostring(element, encoding);
        } catch (Exception e) {
            logger.error("Error converting to pretty XML: {}", e.getMessage());
            return new byte[0];
        }
    }

    private static Object _parse_etree_to_json_type(Element node) throws XMLParseError {
        List<Element> children = List.of(node.getChildNodes());
        String key = node.getAttribute("key");
        if (children.isEmpty()) {
            return _parse_etree_node_leaf(node);
        } else {
            Map<String, Object> resultMap = new HashMap<>();
            for (Element child : children) {
                String childKey = child.getAttribute("key");
                if (childKey.isEmpty()) {
                    throw new XMLParseError("Child element must have a key attribute");
                }
                resultMap.put(childKey, _parse_etree_to_json_type(child));
            }
            return resultMap;
        }
    }

    public static Map<String, Object> parse_xml_from_file(MultipartFile file) throws XMLParseError {
        try (InputStream inputStream = file.getInputStream()) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Element root = builder.parse(inputStream).getDocumentElement();
            return (Map<String, Object>) _parse_etree_to_json_type(root);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new XMLParseError("Error parsing XML from file", e);
        }
    }

    public static JSONType parse_xml_from_string(String xml_str) throws XMLParseError {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Element root = builder.parse(new ByteArrayInputStream(xml_str.getBytes(StandardCharsets.UTF_8))).getDocumentElement();
            return (JSONType) _parse_etree_to_json_type(root);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new XMLParseError("Error parsing XML from string", e);
        }
    }
}