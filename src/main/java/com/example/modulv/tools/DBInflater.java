package com.example.modulv.tools;

import com.example.modulv.model.Auto;
import com.example.modulv.model.Dystrybutor;
import com.example.modulv.model.Klient;
import com.example.modulv.model.Producent;
import com.example.modulv.repositories.AutoRepository;
import com.example.modulv.repositories.DystrybutorRepository;
import com.example.modulv.repositories.KlientRepository;
import com.example.modulv.repositories.ProducentRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {

    public DBInflater(AutoRepository autoRepository, DystrybutorRepository dystrybutorRepository, KlientRepository klientRepository, ProducentRepository producentRepository){
        this.autoRepository = autoRepository;
        this.dystrybutorRepository = dystrybutorRepository;
        this.klientRepository = klientRepository;
        this.producentRepository = producentRepository;

    }

    private AutoRepository autoRepository;
    private DystrybutorRepository dystrybutorRepository;
    private KlientRepository klientRepository;
    private ProducentRepository producentRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {initData();}

    private void initData() {

        Auto polo = new Auto("Polo", "2001", "Diesel");
        Dystrybutor salonVW = new Dystrybutor("VW Katowice", "Katowice");
        Klient pierwszy = new Klient("Jan", "Kowalski");
        Producent VW = new Producent("VolksWagen", "Niemcy", "25", salonVW);
        polo.getProducenci().add(VW);
        VW.getAuta().add(polo);
        autoRepository.save(polo);
        dystrybutorRepository.save(salonVW);
        klientRepository.save(pierwszy);
        producentRepository.save(VW);

        Auto pasat = new Auto("Pasat", "2006", "Benzyna");
        Dystrybutor salonVW2 = new Dystrybutor("VW Wrocław", "Wrocław");
        Klient drugi = new Klient("Janusz", "Brzeczyszczykiewicz");
        Producent VW2 = new Producent("VolksWagen", "Niemcy", "14", salonVW2);
        pasat.getProducenci().add(VW2);
        VW2.getAuta().add(pasat);
        autoRepository.save(pasat);
        dystrybutorRepository.save(salonVW2);
        klientRepository.save(drugi);
        producentRepository.save(VW2);

        Auto A3 = new Auto("A3", "2010", "Benzyna/LPG");
        Dystrybutor salonAudi = new Dystrybutor("Audi Warszawa", "Warszawa");
        Klient trzeci = new Klient("Piotr", "Janicki");
        Producent Audi = new Producent("Audi", "Niemcy", "05", salonAudi);
        A3.getProducenci().add(Audi);
        Audi.getAuta().add(A3);
        autoRepository.save(A3);
        dystrybutorRepository.save(salonAudi);
        klientRepository.save(trzeci);
        producentRepository.save(Audi);

    }

}
