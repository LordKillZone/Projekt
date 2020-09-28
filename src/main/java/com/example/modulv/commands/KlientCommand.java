package com.example.modulv.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KlientCommand {
    private Long id;
    private String imie;
    private String nazwisko;
}
