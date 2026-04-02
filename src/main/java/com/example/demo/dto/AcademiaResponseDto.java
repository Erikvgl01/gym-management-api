package com.example.demo.dto;

public record AcademiaResponseDto(
        Long id,
        String nome,
        String endereco,
        String telefone,
        String cnpj
) {
    public AcademiaResponseDto(String nome, String endereco, String telefone, String cnpj) {
        this(null, nome, endereco, telefone, cnpj);
    }
}
