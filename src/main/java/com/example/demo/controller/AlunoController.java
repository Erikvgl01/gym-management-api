package com.example.demo.controller;

import com.example.demo.model.Aluno;
import com.example.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoService.criarAluno(aluno);
    }

    @GetMapping("/{id}")
    public Aluno buscarAluno(@PathVariable Long id) {
        return alunoService.buscarAluno(id);
    }

    @GetMapping
    public List<Aluno> listarAlunos() {return alunoService.listarAlunos();}

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
    }


}