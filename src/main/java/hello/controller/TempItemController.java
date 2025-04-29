package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hello.service.TempItemService;
import hello.dto.TempItemDTO;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@RestController
@RequestMapping("/temp-items")
public class TempItemController {

    @Autowired
    private TempItemService tempItemService;

    @PostMapping(consumes = "application/xml")
    public ResponseEntity<Void> createTempItem(@RequestBody String xml) {
        try {
            TempItemDTO tempItemDTO = convertXmlToDto(xml);
            tempItemService.insertTempItems(tempItemDTO);
            return ResponseEntity.ok().build();
        } catch (JAXBException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    private TempItemDTO convertXmlToDto(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(TempItemDTO.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (TempItemDTO) unmarshaller.unmarshal(new StringReader(xml));
    }
}