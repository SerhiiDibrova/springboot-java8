

package hello.service;

import hello.dto.XmlDataDTO;
import hello.entity.TempItem;
import hello.repository.TempItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.sql.SQLException;
import java.util.List;

@Service
public class InsertDataFromXmlService {

    @Autowired
    private TempItemRepository tempItemRepository;

    @Transactional
    public void insertDataFromXml(XmlDataDTO xmlDataDTO, Long orderId) throws ParserConfigurationException, SQLException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        List<TempItem> tempItems = xmlDataDTO.getTempItems(factory, orderId);
        tempItemRepository.saveAll(tempItems);
    }
}