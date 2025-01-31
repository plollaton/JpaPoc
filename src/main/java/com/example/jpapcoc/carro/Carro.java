package com.example.jpapcoc.carro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {
    private Long id;
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private String pessoaNome;
}
