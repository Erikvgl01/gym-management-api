package com.example.demo.controller;

import com.example.demo.model.Funcionario;
import com.example.demo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/funcionarios")
@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario) {return funcionarioService.criarFuncionario(funcionario);}

    @GetMapping
    public List<Funcionario> listarFuncionarios() {return funcionarioService.listarFuncionarios();}

    @GetMapping("/{id}")
    public Funcionario buscarFuncionario(@PathVariable Long id) {return funcionarioService.buscarFuncionario(id);}

    @DeleteMapping("/{id}")
    public void deletarFuncionario(@PathVariable Long id) {funcionarioService.deletarAluno(id);}


}
