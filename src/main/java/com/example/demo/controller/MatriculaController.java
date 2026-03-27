package com.example.demo.controller;

import com.example.demo.model.Matricula;
import com.example.demo.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping ("/matriculas")
@RestController

public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @PostMapping
    public Matricula criarMatricula(@RequestBody Matricula matricula) {return matriculaService.criarMatricula(matricula);}

    @GetMapping
    public List<Matricula> listarMatriculas() { return matriculaService.listarMatriculas();}

    @GetMapping ("/{id}")
    public Matricula buscarMatricula(@PathVariable Long id) { return matriculaService.buscarMatricula(id);}

    @DeleteMapping ("/{id}")
    public void deletarMatricula(Long id) { matriculaService.deletarMatricula(id);}

}
