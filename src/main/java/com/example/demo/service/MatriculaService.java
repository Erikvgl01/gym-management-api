package com.example.demo.service;

import com.example.demo.model.Aluno;
import com.example.demo.model.Matricula;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MatriculaService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Matricula criarMatricula(Matricula matricula) {

        if (matricula.getAluno() == null || matricula.getAluno().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aluno é obrigatório.");
        }

        Aluno aluno = alunoRepository.findById(matricula.getAluno().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));

        matricula.setAluno(aluno);

        validarMatricula(matricula);

        return matriculaRepository.save(matricula);
    }


    private final MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }


    public List<Matricula> listarMatriculas() {
        return matriculaRepository.findAll();
    }

    public Matricula buscarMatricula(Long id) {
        return matriculaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado."));
    }

    public void deletarMatricula(Long id) {
        matriculaRepository.deleteById(id);
    }

    private void validarMatricula(Matricula matricula) {
        if (matricula.getAluno() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aluno é obrigatório.");
        }
        if (matricula.getPlano() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Plano é obrigatório.");
        }
        if (matricula.getDataInicio() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data de início é obrigatória.");
        }
        if (matricula.getDataFim() != null && matricula.getDataFim().isBefore(matricula.getDataInicio())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data de fim não pode ser antes da data de início.");
        }
        if (matricula.getAtiva() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status de matrícula (ativa) é obrigatório.");
        }
    }
}