package com.example.demo.controller;

import com.example.demo.model.Academia;
import com.example.demo.service.AcademiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academias")
public class AcademiaController {
    @Autowired
    private AcademiaService academiaService;

    @PostMapping
    public Academia criarAcademia(@RequestBody Academia academia) {return academiaService.criarAcademia(academia);}

    @GetMapping("/{id}")
    public Academia buscarAcademia(@PathVariable Long id) {return academiaService.buscarAcademia(id);}

    @GetMapping
    public List<Academia> listarAcademias() {return academiaService.listarAcademias();}

    @DeleteMapping
    public void deletarAcademia(@PathVariable Long id) {academiaService.deletarAcademia(id);}

}
