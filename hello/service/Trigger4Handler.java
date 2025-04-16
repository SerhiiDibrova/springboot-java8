

package hello.service;

import hello.model.Table4;
import hello.service.Proc4Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Trigger4Handler {

    private static final Logger LOGGER = LoggerFactory.getLogger(Trigger4Handler.class);

    private final Proc4Service proc4Service;

    @Autowired
    public Trigger4Handler(Proc4Service proc4Service) {
        this.proc4Service = proc4Service;
    }

    public void handleTrigger(Table4 table4) {
        if (table4 != null) {
            try {
                Long id = table4.getId();
                if (id != null) {
                    proc4Service.executeProc4(id);
                    LOGGER.info("Trigger 4 handled successfully for id: {}", id);
                } else {
                    LOGGER.error("Id is null for table4 object: {}", table4);
                }
            } catch (Exception e) {
                LOGGER.error("Error handling trigger 4 for table4 object: {}", table4, e);
            }
        } else {
            LOGGER.error("Table4 object is null");
        }
    }
}