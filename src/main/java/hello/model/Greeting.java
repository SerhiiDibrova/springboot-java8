package hello.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Greeting {
    private final long id;
    private final String content;
    private static final Logger logger = LoggerFactory.getLogger(Greeting.class);

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String methodA() {
        logger.info("Method A called");
        return "A";
    }
}