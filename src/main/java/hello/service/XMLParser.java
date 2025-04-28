package hello.service;

import hello.model.JSONType;
import hello.model.XMLElementType;
import hello.model.XMLParseError;
import hello.service.XMLParserService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLParser {

    @staticmethod
    public static XMLElementType parse_json_to_element(JSONType data) {
        return _parse_json_data_to_etree(data);
    }

    public static byte[] toPrettyXml(Element element, String encoding) {
        if (encoding == null) {
            encoding = "UTF-8";
        }
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            transformer.transform(new DOMSource(element), new StreamResult(outputStream));
            return outputStream.toByteArray();
        } catch (TransformerException e) {
            throw new RuntimeException("Error transforming XML to byte array", e);
        }
    }

    public static JSONType _parse_etree_to_json_type(Element node) {
        List<Element> children = new ArrayList<>();
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            if (node.getChildNodes().item(i) instanceof Element) {
                children.add((Element) node.getChildNodes().item(i));
            }
        }
        String key = node.getAttribute("key");
        if (children.isEmpty()) {
            return XMLParserService._parse_etree_node_leaf(node);
        }
        if (children.stream().noneMatch(child -> child.hasAttribute("key"))) {
            List<JSONType> jsonList = new ArrayList<>();
            for (Element child : children) {
                jsonList.add(_parse_etree_to_json_type(child));
            }
            return jsonList;
        }
        Map<String, JSONType> obj = new HashMap<>();
        for (Element child : children) {
            String ckey = child.getAttribute("key");
            if (ckey.isEmpty()) {
                throw new XMLParseError("Child element missing 'key' attribute");
            }
            JSONType value = null;
            String type = child.getAttribute("type");
            if ("string".equals(type)) {
                value = child.getTextContent();
            } else if ("number".equals(type)) {
                value = Double.valueOf(child.getTextContent());
            } else if ("boolean".equals(type)) {
                value = Boolean.valueOf(child.getTextContent());
            } else {
                value = _parse_etree_to_json_type(child);
            }
            obj.put(ckey, value);
        }
        return obj;
    }

    public static JSONType parse_xml_from_string(String xml_str) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(xml_str.getBytes(StandardCharsets.UTF_8)));
            Element root = document.getDocumentElement();
            return _parse_etree_to_json_type(root);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException("Error parsing XML string", e);
        }
    }

    public static String parseXmlFromJson(Map<String, Object> jsonData) {
        // Implementation to convert Map to XML string
        return ""; // Placeholder for actual XML conversion logic
    }
}