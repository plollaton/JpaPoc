package com.example.jpapcoc.consentimento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consentimento {
    private Long id;
    private String consentId;
    private Double valor;
    private Rejeicao rejeicao;
}
