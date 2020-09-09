package com.example.projektstudia.projektstudia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MuslibryController {

    @RequestMapping(value = {"/"})
    public String getArtists() {
        return "index";
    }

}
