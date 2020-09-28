package com.example.modulv.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProducentCommand {
    private Long id;
    private String marka;
    private String lokalizacja;
    private String nrstanowiska;
    private Long dystrybutorId;
    private Long autoId;
}
