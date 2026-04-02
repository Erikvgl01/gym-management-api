package com.example.demo.dto;

import com.example.demo.model.Plano;
import jakarta.validation.constraints.NotBlank;

public record MatriculaRequestDto(
        @NotBlank( message = "O id do aluno é obrigatório")
        Long id,
        @NotBlank( message = "O plano do aluno é obrigatório")
        Plano plano

) {
}
