package com.example.demo.service;

import com.example.demo.model.Matricula;
import com.example.demo.repository.MatriculaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public Matricula criarMatricula(Matricula matricula) {
        validarMatricula(matricula);
        return matriculaRepository.save(matricula);
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