package kz.iitu.spring.SpringBoot.controllers;

import kz.iitu.spring.SpringBoot.beans.FirstBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class JustController {


    private FirstBean firstBean;

    @GetMapping(value = "/test")
    public String test(Model model){
        model.addAttribute("name",firstBean.getName());

        return "test";
    }
    @GetMapping(value = "/settestname/{userName}")
    public String setName(@PathVariable(name = "userName") String userName){
        firstBean.setName(userName);
        return "redirect:/";
    }
}
