

package hello.service;

import hello.model.TempItemDTO;
import hello.model.TempItemEntity;
import hello.repository.TempItemRepository;
import org.springframework.stereotype.Service;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Service
public class TempItemService {

    private final TempItemRepository tempItemRepository;

    public TempItemService(TempItemRepository tempItemRepository) {
        this.tempItemRepository = tempItemRepository;
    }

    public void insertTempItemFromXml(Long orderId, String xmlDocument) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(TempItemDTO.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xmlDocument);
        TempItemDTO tempItemDTO = (TempItemDTO) unmarshaller.unmarshal(reader);
        TempItemEntity tempItemEntity = new TempItemEntity(orderId, tempItemDTO.getName(), tempItemDTO.getPrice());
        try {
            tempItemRepository.insert(tempItemEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error inserting temp item into database", e);
        }
    }

    public void createTempItemTable() {
        try {
            tempItemRepository.createTempItemTable();
        } catch (Exception e) {
            throw new RuntimeException("Error creating temp item table", e);
        }
    }
}