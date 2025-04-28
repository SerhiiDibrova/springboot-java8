package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class FormController {

    @GetMapping("/")
    public String getBasicForm(HttpServletRequest request, Model model) {
        model.addAttribute("request", request);
        return "index";
    }
}