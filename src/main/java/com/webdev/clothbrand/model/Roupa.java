package com.webdev.clothbrand.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roupa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tamanho;
    private Double preco;

    @Enumerated(EnumType.ORDINAL)
    private TipoRoupa tipo;

    // Setters com casting opcional — use somente se precisar receber objetos genéricos
    public void setNome(Object nome) {
        this.nome = (String) nome;
    }

    public void setTamanho(Object tamanho) {
        this.tamanho = (String) tamanho;
    }

    public void setPreco(Object preco) {
        this.preco = (Double) preco;
    }

    public void setTipo(TipoRoupa tipo) {
        this.tipo = tipo;
    }
}