

package hello.declaration;

import java.lang.Integer;
import java.lang.String;

public class DboFunc0 {
    public String getName(Integer input) {
        if (input == null) {
            throw new NullPointerException("Input cannot be null");
        }
        String name = "dbo.func_0_" + input.toString();
        return name;
    }
}