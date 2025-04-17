

package hello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import hello.model.PersistenceEvent;
import hello.model.Trigger7Service;
import hello.model.OnInsert;

@Component
public class Trigger7EventListener {

    @Autowired
    private Trigger7Service trigger7Service;

    @EventListener
    public void onApplicationEvent(PersistenceEvent event) {
        if (event != null && event.getTable() != null && event instanceof OnInsert && event.getTable().equals("table_7")) {
            if (trigger7Service != null) {
                trigger7Service.executeTrigger(event.getRecord());
            }
        }
    }
}