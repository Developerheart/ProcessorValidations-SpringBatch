package com.developer.leonardo.processorvalidatorspringbatch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @NotNull
    @Size(min = 3, max = 255)
    @Pattern(regexp = "[a-zA-Z\\s]+", message = "Nome informado deve conter apenas letras")
    private String nome;

    @NotNull
    @Range(min = 18, max = 200)
    private Integer idade;

    @NotNull
    @Size(min = 15, max = 100)
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email informado é invalido")
    private String email;

}
