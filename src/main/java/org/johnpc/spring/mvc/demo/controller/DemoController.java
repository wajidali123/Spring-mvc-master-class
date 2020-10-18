package org.johnpc.spring.mvc.demo.controller;

import org.johnpc.spring.mvc.demo.service.impl.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Constructor;

@Controller
public class DemoController {

    private final DemoServiceImpl demoService;

    @Autowired
    public DemoController(DemoServiceImpl demoService) {
        this.demoService = demoService;
    }

    // http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {

        return "hello";
    }

    // http://localhost:8080/todo-list/welcome
    // prefix + name + suffix
    // /WEB-INF/view/welcome.jsp
    @GetMapping("welcome")
    public String welcome(Model model, @RequestParam String name) {
        model.addAttribute("username", demoService.getHelloMessage(name));
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        return this.demoService.getWelcomeMessage();
    }

}
