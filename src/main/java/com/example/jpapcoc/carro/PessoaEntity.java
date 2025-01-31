package com.example.jpapcoc.carro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;

    @Transient
    @OneToOne
    @JoinColumn(name = "carro_id")
    @ToString.Exclude
    private CarroEntity carro;
}
