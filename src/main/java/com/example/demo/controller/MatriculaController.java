package com.example.demo.controller;

import com.example.demo.model.Matricula;
import com.example.demo.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping ("/matriculas")
@RestController

public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<Matricula> criarMatricula(@RequestBody Matricula matricula) {
        Matricula novaMatricula = matriculaService.criarMatricula(matricula);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMatricula);
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> listarMatriculas() {
        return ResponseEntity.ok(matriculaService.listarMatriculas());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Matricula> buscarMatricula(@PathVariable Long id) {
        Matricula matricula = matriculaService.buscarMatricula(id);
        return ResponseEntity.ok(matricula);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deletarMatricula(@PathVariable Long id) {
        matriculaService.deletarMatricula(id);
        return ResponseEntity.noContent().build();
    }

}
