package com.example.demo.controller;

import com.example.demo.model.Funcionario;
import com.example.demo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/funcionarios")
@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<Funcionario> criarFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario novoFuncionario = funcionarioService.criarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
        }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {return ResponseEntity.ok(funcionarioService.listarFuncionarios());}

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarFuncionario(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.buscarFuncionario(id);
        return ResponseEntity.ok(funcionario);
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }


}
