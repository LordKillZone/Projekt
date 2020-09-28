package com.example.modulv.controllers;


import com.example.modulv.commands.DystrybutorCommand;
import com.example.modulv.converters.DystrybutorCommandToDystrybutor;
import com.example.modulv.model.Dystrybutor;
import com.example.modulv.repositories.DystrybutorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class DystrybutorController {

    private DystrybutorRepository dystrybutorRepository;
    private DystrybutorCommandToDystrybutor dystrybutorCommandToDystrybutor;

    public DystrybutorController(DystrybutorRepository dystrybutorRepository, DystrybutorCommandToDystrybutor dystrybutorCommandToDystrybutor) {
        this.dystrybutorRepository = dystrybutorRepository;
        this.dystrybutorCommandToDystrybutor = dystrybutorCommandToDystrybutor;
    }

    @RequestMapping(value = {"/dystrybutorzy", "/dystrybutor/list"})
    public String getDystrybutorzy(Model model) {
        model.addAttribute("dystrybutorzy", dystrybutorRepository.findAll());
        return "dystrybutor/list";
    }

    @RequestMapping("/dystrybutor/{id}/pokaz")
    public String getDystrybutorDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("dystrybutor", dystrybutorRepository.findById(id).get());
        return "dystrybutor/show";
    }

    @RequestMapping("/dystrybutor/{id}/usun")
    public String deleteDystrybutor(@PathVariable("id") Long id) {
        dystrybutorRepository.deleteById(id);
        return "redirect:/dystrybutor";
    }

    @GetMapping
    @RequestMapping("/dystrybutor/new")
    public String newDystrybutor(Model model){
        model.addAttribute("dystrybutor", new DystrybutorCommand());
        return "dystrybutor/addedit";
    }

    @PostMapping("dystrybutor")
    public String saveOrUpdate(@ModelAttribute DystrybutorCommand command){

        Optional<Dystrybutor> dystrybutorOptional = dystrybutorRepository.getDystrybutorByNazwasalonu(command.getNazwasalonu());

        if (!dystrybutorOptional.isPresent()) {
            Dystrybutor detachedDystrybutor = dystrybutorCommandToDystrybutor.convert(command);
            Dystrybutor savedDystrybutor = dystrybutorRepository.save(detachedDystrybutor);
            return "redirect:/dystrybutor/" + savedDystrybutor.getId() + "/pokaz";
        } else {
            System.out.println("Juz istnieje taki dystrybutor w bazie danych");
            return "redirect:/dystrybutor/" + dystrybutorOptional.get().getId() + "/pokaz";
        }
    }
}
