package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record FuncionarioRequestDto(
        @NotBlank(message = "O nome do funcionário é obrigatório")
        String nome,
        @NotBlank(message = "O cargo do funcionário é obrigatório")
        String cargo,
        @NotBlank(message = "O telefone do funcionário é obrigatório")
        String telefone,
        @NotBlank(message = "O cpf do funcionário é obrigatório")
        String cpf,
        @NotBlank(message = "O salário do funcionário é obrigatório")
        BigDecimal salario


) {
}
