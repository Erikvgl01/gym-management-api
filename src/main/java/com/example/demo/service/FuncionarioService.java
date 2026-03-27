package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

        public FuncionarioService(FuncionarioRepository funcionarioRepository) {
            this.funcionarioRepository = funcionarioRepository;
        }


    public Funcionario criarFuncionario(Funcionario funcionario) {
        validarFuncionario(funcionario);
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario buscarFuncionario(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado."));
    }

    public void deletarAluno(Long id){
        funcionarioRepository.deleteById(id);
    }

    private void validarFuncionario(Funcionario funcionario) {
        if (funcionario.getNome() == null || funcionario.getNome().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome do funcionário é obrigatório.");
        }
        if (funcionario.getTelefone() == null || funcionario.getTelefone().length() < 8) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Telefone inválido.");
        }
        if (funcionario.getSalario() == null || funcionario.getSalario().compareTo(java.math.BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Salário deve ser positivo.");
        }
    }
}