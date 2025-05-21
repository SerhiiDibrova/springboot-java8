package hello.controller;

import hello.service.Cat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CatController {
    private static final Logger logger = LoggerFactory.getLogger(CatController.class);

    public void testCatSpeak() {
        try {
            Cat cat = new Cat();
            String sound = cat.Speak();
            if (sound == null || sound.isEmpty()) {
                logger.error("Cat did not make a sound.");
            } else {
                logger.info("Cat says: " + sound);
            }
        } catch (Exception e) {
            logger.error("An error occurred while testing Cat speak: ", e);
        }
    }
}