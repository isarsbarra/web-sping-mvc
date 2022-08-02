package br.com.letscode.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Produto {

    private Integer id;
    private String nome;
    private String categoria;
    private BigDecimal valor;
}
