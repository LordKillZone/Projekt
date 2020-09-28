package com.example.modulv.controllers;


import com.example.modulv.commands.KlientCommand;
import com.example.modulv.converters.KlientCommandToKlient;
import com.example.modulv.model.Klient;
import com.example.modulv.repositories.KlientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class KlientController {

    private KlientRepository klientRepository;
    private KlientCommandToKlient klientCommandToKlient;

    public KlientController(KlientRepository klientRepository, KlientCommandToKlient klientCommandToKlient) {
        this.klientRepository = klientRepository;
        this.klientCommandToKlient = klientCommandToKlient;
    }

    @RequestMapping(value = {"/klient", "/klient/list"})
    public String getKlienci(Model model) {
        model.addAttribute("klienci", klientRepository.findAll());
        return "Klient/list";
    }

    @RequestMapping("/klient/{id}/pokaz")
    public String getKlientDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("klient", klientRepository.findById(id).get());
        return "klient/show";
    }

    @RequestMapping("/klient/{id}/usun")
    public String deleteKlient(@PathVariable("id") Long id) {
        klientRepository.deleteById(id);
        return "redirect:/klient";
    }

    @GetMapping
    @RequestMapping("/klient/new")
    public String newKlient(Model model){
        model.addAttribute("klient", new KlientCommand());
        return "klient/addedit";
    }

    @PostMapping("klient")
    public String saveOrUpdate(@ModelAttribute KlientCommand command){

        Optional<Klient> klientOptional = klientRepository.getKlientByImie(command.getImie());

        if (!klientOptional.isPresent()) {
            Klient detachedKlient = klientCommandToKlient.convert(command);
            Klient savedKlient = klientRepository.save(detachedKlient);
            return "redirect:/klient/" + savedKlient.getId() + "/pokaz";
        } else {
            System.out.println("Taki klient juz istnieje w bazie danych");
            return "redirect:/klient/" + klientOptional.get().getId() + "/pokaz";
        }
    }
}
