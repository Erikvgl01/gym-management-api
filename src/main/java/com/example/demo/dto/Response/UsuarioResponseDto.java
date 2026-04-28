package com.example.demo.dto.Response;

import com.example.demo.model.Usuario;

public record UsuarioResponseDto(
        Long id,
        String username,
        String role,
        Long funcionarioId
) {
    public UsuarioResponseDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getRole(),
                usuario.getFuncionario() != null ? usuario.getFuncionario().getId() : null
        );
    }
}

