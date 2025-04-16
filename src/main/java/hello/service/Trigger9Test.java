

package hello.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Trigger9Test {

    @Autowired
    private Trigger9 trigger9;

    @Test
    public void testTrigger9() {
        Table9 table9 = new Table9();
        trigger9.trigger9(table9);
    }
}