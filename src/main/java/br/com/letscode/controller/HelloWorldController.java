package br.com.letscode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String helloPage(ModelMap modelMap) {
        modelMap.addAttribute("nome", "Turma Sinqia");
        return "hello";
    }

}
