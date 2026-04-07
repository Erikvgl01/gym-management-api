package com.example.demo.dto;

import com.example.demo.model.Funcionario;

import java.math.BigDecimal;

public record FuncionarioResponseDto(
        Long id,
        String nome,
        String cargo,
        String telefone,
        String cpf,
        BigDecimal salario
) {
    public FuncionarioResponseDto(Funcionario funcionario) {
        this(funcionario.getId(), funcionario.getNome(), funcionario.getCargo(), funcionario.getTelefone(), funcionario.getCpf(), funcionario.getSalario());
    }
}
