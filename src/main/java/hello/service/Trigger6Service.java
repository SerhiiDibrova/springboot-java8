

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.repository.Table6Repository;
import hello.service.Proc6Service;

@Service
public class Trigger6Service {

    @Autowired
    private Proc6Service proc6Service;

    @Autowired
    private Table6Repository table6Repository;

    public Object executeProc6(Integer id) {
        try {
            proc6Service.executeProc6(id);
            return table6Repository.findNewlyInsertedRecord(id);
        } catch (Exception e) {
            // Handle exception
            return null;
        }
    }
}