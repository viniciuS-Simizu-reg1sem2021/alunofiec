package com.fiec.alunofiec.services;

import com.fiec.alunofiec.business.models.entities.Aluno;
import com.fiec.alunofiec.business.repositories.IAlunoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService implements IAlunoService{

    @Autowired
    IAlunoRepositorio alunoRepositorio;

    @Override
    public Page<Aluno> getAlunos(int page, int pageSize) {

        Page<Aluno> alunos =  alunoRepositorio.findAll(PageRequest.of(page, pageSize));
        return alunos;
    }

    @Override
    public void saveAluno(Aluno aluno) {

        alunoRepositorio.save(aluno);

    }

    @Override
    public void atualizaAluno(Aluno aluno, String id) {

        Aluno alunoAnterior = alunoRepositorio.findById(id).orElse(null);
        alunoAnterior.setRm(aluno.getRm());
        alunoAnterior.setCurso(aluno.getCurso());
        alunoRepositorio.save(alunoAnterior);

    }

    @Override
    public Aluno pegaAluno(String id) {
        Aluno aluno = alunoRepositorio.findById(id).orElse(null);
        return aluno;
    }

    @Override
    public void deletaAluno(String id) {
        alunoRepositorio.deleteById(id);
    }
}
