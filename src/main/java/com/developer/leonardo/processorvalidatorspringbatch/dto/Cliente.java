package com.developer.leonardo.processorvalidatorspringbatch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @NotNull
    private String nome;

    @NotNull
    private Integer idade;

    @NotNull
    private String email;

}
