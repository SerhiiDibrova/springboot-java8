

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.dto.XmlDocumentDTO;
import hello.service.XmlDocumentService;

@RestController
public class XmlDocumentController {

    private XmlDocumentService xmlDocumentService;

    @Autowired
    public XmlDocumentController(XmlDocumentService xmlDocumentService) {
        this.xmlDocumentService = xmlDocumentService;
    }

    public ResponseEntity<XmlDocumentDTO> prepareXmlDocument(@RequestParam String xmlData) {
        if (xmlData == null || xmlData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            XmlDocumentDTO xmlDocumentDTO = xmlDocumentService.prepareXmlDocument(xmlData);
            return new ResponseEntity<>(xmlDocumentDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}