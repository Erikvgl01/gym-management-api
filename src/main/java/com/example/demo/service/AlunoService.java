package com.example.demo.service;

import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno criarAluno(Aluno aluno) {
        validarAluno(aluno);
        return alunoRepository.save(aluno);
    }

    public Aluno buscarAluno (Long id){
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado."));
    }

    public List<Aluno> listarAlunos() {return alunoRepository.findAll();}

    public void deletarAluno(Long id){
        if(!alunoRepository.existsById(id)){
            throw new RuntimeException("Aluno não encontrado");
        }
        alunoRepository.deleteById(id);
    }


    private void validarAluno(Aluno aluno) {
        if (aluno.getNome() == null || aluno.getNome().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome do aluno é obrigatório.");
        }
        if (aluno.getTelefone() == null || aluno.getTelefone().length() < 8) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Telefone inválido.");
        }
        if (aluno.getMensalidade() == null || aluno.getMensalidade().compareTo(java.math.BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mensalidade deve ser positiva.");
        }
        if (aluno.getPlano() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Plano é obrigatório.");
        }
    }
}