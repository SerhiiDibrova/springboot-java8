package hello.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLParser {

    public Object _parse_etree_node_leaf(Element element) {
        String type = element.getAttribute("type");
        XMLElementType xelementType = new XMLElementType(type);
        String elementValue = element.getAttribute("value");
        return xelementType.parseElementValue(elementValue);
    }

    public Object parseXmlFromJson(Object jsonData) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.valueToTree(jsonData);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = xmlMapper.writeValueAsString(jsonNode);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xml));
            Document doc = builder.parse(is);
            return doc.getDocumentElement();
        } catch (Exception e) {
            return null;
        }
    }

    public JSONType parse_xml_from_file(File file) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            Element root = doc.getDocumentElement();
            return parseElement(root);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            return null;
        }
    }

    private JSONType parseElement(Element element) {
        JSONType jsonType = new JSONType();
        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element child = (Element) node;
                String name = child.getTagName();
                String value = child.getAttribute("value");
                if (value != null && !value.isEmpty()) {
                    jsonType.put(name, value);
                } else {
                    JSONType childJson = parseElement(child);
                    jsonType.put(name, childJson);
                }
            }
        }
        return jsonType;
    }
}

class XMLElementType {
    private String type;

    public XMLElementType(String type) {
        this.type = type;
    }

    public Object parseElementValue(String elementValue) {
        switch (type) {
            case "string":
                return elementValue;
            case "integer":
                return Integer.parseInt(elementValue);
            case "float":
                return Float.parseFloat(elementValue);
            case "boolean":
                return Boolean.parseBoolean(elementValue);
            case "map":
                Map<String, Object> map = new HashMap<>();
                // Assuming the elementValue is a string representation of a map
                // This would need to be implemented based on the actual format of the map string format
                return map;
            default:
                return null;
        }
    }
}

class JSONType {
    private Map<String, Object> data = new HashMap<>();

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public Map<String, Object> getData() {
        return data;
    }
}