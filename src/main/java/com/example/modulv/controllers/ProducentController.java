package com.example.modulv.controllers;


import com.example.modulv.commands.ProducentCommand;
import com.example.modulv.converters.ProducentCommandToProducent;
import com.example.modulv.model.Producent;
import com.example.modulv.repositories.AutoRepository;
import com.example.modulv.repositories.DystrybutorRepository;
import com.example.modulv.repositories.KlientRepository;
import com.example.modulv.repositories.ProducentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProducentController {

    private ProducentRepository producentRepository;
    private ProducentCommandToProducent producentCommandToProducent;
    private DystrybutorRepository dystrybutorRepository;
    private AutoRepository autoRepository;

    public ProducentController(ProducentRepository producentRepository, ProducentCommandToProducent producentCommandToProducent, DystrybutorRepository dystrybutorRepository,KlientRepository klientRepository, AutoRepository autorepository) {
        this.producentRepository = producentRepository;
        this.producentCommandToProducent = producentCommandToProducent;
        this.dystrybutorRepository = dystrybutorRepository;
        this.autoRepository = autorepository;
    }

    @GetMapping
    @RequestMapping(value = {"/producenci" , "producent/list"})
    public String getProducenci(Model model) {
        model.addAttribute("producenci", producentRepository.findAll());
        return "Producent/list";
    }

    @GetMapping
    @RequestMapping("/producent/{id}/pokaz")
    public String getProducentDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("producent", producentRepository.findById(id).get());
        return "Producent/show";
    }

    @GetMapping
    @RequestMapping("/producent/{id}/usun")
    public String deleteProducent(@PathVariable("id") Long id) {
        producentRepository.deleteById(id);
        return "redirect:/producenci";
    }

    @GetMapping
    @RequestMapping("/producent/new")
    public String newProducent(Model model){
        model.addAttribute("producent", new ProducentCommand());
        model.addAttribute("dystrybutor", dystrybutorRepository.findAll());
        model.addAttribute("auta", autoRepository.findAll());
        return "Producent/addedit";
    }

    @PostMapping("producent")
    public String saveOrUpdate(@ModelAttribute ProducentCommand command){
        Producent detachedProducent = producentCommandToProducent.convert(command);
        Producent savedProducent = producentRepository.save(detachedProducent);

        return "redirect:/producent/" + savedProducent.getId() + "/pokaz";
    }
}

