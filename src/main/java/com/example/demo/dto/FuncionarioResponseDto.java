package com.example.demo.dto;

public record FuncionarioResponseDto(
        Long id,
        String nome,
        String cargo,
        String telefone,
        String cpf,
        String salario
) {
    public FuncionarioResponseDto(String nome, String cargo, String telefone, String cpf, String salario) {
        this(null, nome, cargo, telefone, cpf, salario);
    }
}
