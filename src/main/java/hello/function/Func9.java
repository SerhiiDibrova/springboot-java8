

package hello.function;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Func9 {

    public String func9(Integer input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        String inputStr = input.toString();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            return "func9_" + number;
        } else {
            return "";
        }
    }

    public String getName(Integer input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        // Assuming a database or data source is available
        // For demonstration purposes, a simple HashMap is used
        java.util.HashMap<Integer, String> nameMap = new java.util.HashMap<>();
        nameMap.put(1, "John");
        nameMap.put(2, "Jane");
        return nameMap.get(input);
    }
}