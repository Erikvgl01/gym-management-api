package com.example.demo.controller;

import com.example.demo.model.Academia;
import com.example.demo.service.AcademiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academias")
public class AcademiaController {
    @Autowired
    private AcademiaService academiaService;

    @PostMapping
    public ResponseEntity<Academia> criarAcademia(@RequestBody Academia academia) {
        Academia novaAcademia = academiaService.criarAcademia(academia);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAcademia);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Academia> buscarAcademia(@PathVariable Long id) {
        Academia academia = academiaService.buscarAcademia(id);
        return ResponseEntity.ok(academia);
    }

    @GetMapping
    public ResponseEntity<List<Academia>> listarAcademias() {
        return ResponseEntity.ok(academiaService.listarAcademias());
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAcademia(@PathVariable Long id) {
        academiaService.deletarAcademia(id);
        return ResponseEntity.noContent().build();
    }
}


