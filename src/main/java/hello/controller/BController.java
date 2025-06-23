package hello.controller;

import hello.model.A;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BController {

    @GetMapping("/methodB")
    @ResponseBody
    public int method_b() {
        try {
            A instanceA = new A();
            int result = instanceA.method_a();
            System.out.println("Method B called with " + result);
            return result;
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return 0;
        }
    }
}