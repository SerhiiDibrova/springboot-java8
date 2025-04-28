package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView getBasicForm(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("request", request);
        return modelAndView;
    }
}