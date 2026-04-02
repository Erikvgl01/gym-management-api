package com.example.demo.dto;

import com.example.demo.model.Plano;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
public record AlunoRequestDto(
        @NotBlank(message = "O nome do aluno é obrigatório")
        String nome,
        @NotBlank(message = "O telefone do aluno é obrigatório")
        String telefone,
        @NotBlank(message = "O cpf do aluno é obrigatório")
        String cpf,
        @NotNull(message = "O plano do aluno é obrigatório")
        Plano plano,
        @NotNull(message = "A mensalidade é obrigatória")
        BigDecimal mensalidade
)

{}
