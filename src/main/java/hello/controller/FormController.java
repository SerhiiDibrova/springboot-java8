package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
public class FormController {

    @GetMapping("/")
    public ModelAndView getBasicForm(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("formTemplate");
        modelAndView.addObject("attribute1", "value1");
        modelAndView.addObject("attribute2", "value2");
        modelAndView.addObject("attribute3", "value3");
        return modelAndView;
    }
}