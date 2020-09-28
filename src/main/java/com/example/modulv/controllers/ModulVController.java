package com.example.modulv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModulVController {

    @RequestMapping(value = {"/"})
    public String getAuta() {return "index";}
}
