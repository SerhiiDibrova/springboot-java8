package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class FormController {

    @GetMapping
    public ModelAndView getBasicForm(Model model) {
        if (model == null) {
            throw new IllegalArgumentException("Model cannot be null");
        }
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("model", model);
        return modelAndView;
    }
}