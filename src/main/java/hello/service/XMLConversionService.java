package hello.service;

import hello.service.XMLParserService;
import org.springframework.web.multipart.MultipartFile;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class XMLConversionService {

    private final XMLParserService xmlParserService;

    public XMLConversionService(XMLParserService xmlParserService) {
        this.xmlParserService = xmlParserService;
    }

    public JSONType convertXmlToJson(MultipartFile file) throws Exception {
        String xmlContent = new String(file.getBytes());
        return xmlParserService.parseXmlToJson(xmlContent);
    }

    public String convertJsonToXml(Map<String, Object> jsonMap) throws Exception {
        return xmlParserService.convertJsonToXml(jsonMap);
    }
}