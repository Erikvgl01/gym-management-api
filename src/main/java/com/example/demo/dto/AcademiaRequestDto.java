package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record AcademiaRequestDto(
        @NotBlank (message = "O nome da academia é obrigatório")
        String nome,
        @NotBlank (message = "O endereço da academia é obrigatório")
        String endereco,
        @NotBlank (message = "O telefone da academia é obrigatório")
        String telefone,
        @NotBlank (message = "O cnpj da academia é obrigatório")
        String cnpj
) {
}
