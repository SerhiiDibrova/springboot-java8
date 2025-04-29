package hello.controller;

import hello.service.TempItemService;
import hello.dto.TempItemDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@RestController
@RequestMapping("/temp-items")
public class TempItemController {

    private final TempItemService tempItemService;

    public TempItemController(TempItemService tempItemService) {
        this.tempItemService = tempItemService;
    }

    @PostMapping
    public ResponseEntity<String> createTempItems(@RequestBody String xmlRequest) {
        try {
            TempItemRequest request = parseXml(xmlRequest);
            TempItemDTO tempItemDTO = request.getTempItemDTO();
            String orderId = request.getOrderId();
            tempItemService.insertTempItems(tempItemDTO, orderId);
            return ResponseEntity.status(HttpStatus.CREATED).body("Temp items created successfully");
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating temp items: " + e.getMessage());
        }
    }

    private TempItemRequest parseXml(String xml) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(TempItemRequest.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        TempItemRequest request = (TempItemRequest) unmarshaller.unmarshal(new StringReader(xml));
        validateRequest(request);
        return request;
    }

    private void validateRequest(TempItemRequest request) throws ValidationException {
        if (request.getTempItemDTO() == null || request.getOrderId() == null) {
            throw new ValidationException("TempItemDTO and orderId must not be null");
        }
    }

    @XmlRootElement(name = "TempItemRequest")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class TempItemRequest {
        @XmlElement(name = "TempItemDTO")
        private TempItemDTO tempItemDTO;
        @XmlElement(name = "OrderId")
        private String orderId;

        public TempItemDTO getTempItemDTO() {
            return tempItemDTO;
        }

        public void setTempItemDTO(TempItemDTO tempItemDTO) {
            this.tempItemDTO = tempItemDTO;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }
    }

    public static class ValidationException extends Exception {
        public ValidationException(String message) {
            super(message);
        }
    }
}