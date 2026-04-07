package com.example.demo.dto;

import com.example.demo.model.Plano;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MatriculaRequestDto(
        @NotNull(message = "O id do aluno é obrigatório")
        Long alunoid,
        @NotNull( message = "O plano do aluno é obrigatório")
        Plano plano

) {
}
