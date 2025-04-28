package hello.service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;
import java.io.StringReader;
import org.springframework.web.multipart.MultipartFile;

public class XMLParser {

    public byte[] toPrettyXml(Element element, String encoding) {
        if (encoding == null) {
            encoding = "utf-8";
        }
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, encoding);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            transformer.transform(new DOMSource(element), new StreamResult(outputStream));
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error during XML transformation", e);
        }
    }

    /**
     * Parses an uploaded XML file and converts it to a JSONType object.
     * 
     * @param file MultipartFile representing the uploaded XML file.
     * @return Object representing the JSONType object.
     * @throws XMLParseError if the XML is invalid or cannot be parsed.
     */
    public Object parse_xml_from_file(MultipartFile file) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file.getInputStream());
            Element rootElement = document.getDocumentElement();
            return XMLParserService._parse_etree_to_json_type(rootElement);
        } catch (Exception e) {
            throw new XMLParseError("Invalid XML file", e);
        }
    }

    /**
     * Parses a string containing XML data and converts it to a JSONType object.
     * 
     * @param xml_str A String representing the XML data to be parsed.
     * @return Object representing the JSONType object.
     * @throws XMLParseError if the XML string is malformed.
     */
    public Object parse_xml_from_string(String xml_str) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xml_str));
            Document document = builder.parse(is);
            Element rootElement = document.getDocumentElement();
            return XMLParserService._parse_etree_to_json_type(rootElement);
        } catch (Exception e) {
            throw new XMLParseError("Malformed XML string", e);
        }
    }
}