package com.example.demo.controller;

import com.example.demo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/funcionarios")
@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping



}
