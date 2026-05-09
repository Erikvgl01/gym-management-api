package com.example.demo.controller;

import com.example.demo.dto.Request.AuthRequestDto;
import com.example.demo.dto.Response.AuthResponseDto;
import com.example.demo.dto.Response.UsuarioResponseDto;
import com.example.demo.model.Usuario;
import com.example.demo.security.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody @Valid AuthRequestDto request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        Usuario usuario = (Usuario) authentication.getPrincipal();
        String token = jwtService.generateToken(usuario);
        return ResponseEntity.ok(new AuthResponseDto(token, "Bearer"));
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioResponseDto> me(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        return ResponseEntity.ok(new UsuarioResponseDto(usuario));
    }
}

