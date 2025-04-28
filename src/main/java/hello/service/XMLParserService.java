package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import hello.model.XMLElementType;
import hello.model.JSONType;
import hello.exception.XMLParseError;
import hello.service.ErrorResponseService;
import org.springframework.web.multipart.MultipartFile;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;

public class XMLParserService {
    private static final Logger logger = LoggerFactory.getLogger(XMLParserService.class);

    public static Object _parse_etree_node_leaf(Element node) {
        XMLElementType etype = new XMLElementType(node.getAttribute("type"));
        String raw = node.getAttribute("value");
        try {
            return etype.parse_element_value(raw);
        } catch (Exception e) {
            logger.error("Leaf parse failed: %r type=%s", node, etype);
            throw e;
        }
    }

    public static JSONType _parse_etree_to_json_type(Element node) {
        List<Element> children = List.of(node.getChildNodes());
        String key = node.getAttribute("key");
        if (children.isEmpty()) {
            Object value = _parse_etree_node_leaf(node);
            return key != null ? Map.of(key, value) : value;
        }
        if (children.stream().noneMatch(child -> child.hasAttribute("key"))) {
            return children.stream()
                .map(XMLParserService::_parse_etree_to_json_type)
                .toList();
        }
        Map<String, JSONType> obj = new HashMap<>();
        for (Element child : children) {
            String ckey = child.getAttribute("key");
            if (ckey == null) {
                throw new XMLParseError("Child element missing 'key' attribute");
            }
            Object value;
            if ("object".equals(child.getAttribute("type")) || "list".equals(child.getAttribute("type"))) {
                value = _parse_etree_to_json_type(child);
            } else {
                value = _parse_etree_node_leaf(child);
            }
            obj.put(ckey, value);
        }
        return obj;
    }

    public static JSONType parseXmlFromFile(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Element root = builder.parse(inputStream).getDocumentElement();
            return _parse_etree_to_json_type(root);
        } catch (Exception e) {
            ErrorResponseService.handleError(e);
            return null;
        }
    }

    public static JSONType parse_xml_from_string(String xml_str) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(xml_str.getBytes(StandardCharsets.UTF_8));
            Element root = builder.parse(inputStream).getDocumentElement();
            return _parse_etree_to_json_type(root);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException("XML parsing failed", e);
        }
    }

    public static String parseXmlFromJson(Map<String, Object> json) {
        // Implementation for converting JSON to XML
        return "";
    }

    public static byte[] toPrettyXml(Element element, String encoding) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, encoding != null ? encoding : "UTF-8");
            transformer.transform(new DOMSource(element), new StreamResult(outputStream));
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("XML serialization failed", e);
        }
    }
}