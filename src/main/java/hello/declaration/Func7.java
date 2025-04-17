

package hello.declaration;

import org.springframework.stereotype.Component;

@Component
public class Func7 {
    public String getName(Integer id) {
        if (id == null) {
            return "Unknown";
        } else if (id < 0) {
            return "Invalid";
        } else {
            return "Name_" + id;
        }
    }
}