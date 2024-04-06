package com.example.SchoolSystem_vnw.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SchoolSystem_vnw.dto.DtoListar;
import com.example.SchoolSystem_vnw.dto.DtoListarCurso;
import com.example.SchoolSystem_vnw.models.ModelAluno;
import com.example.SchoolSystem_vnw.models.ModelColaborador;



@Service
public class ListarService {
	

@Autowired
DtoListar objeto1;
DtoListarCurso objeto2;
    
    public List<DtoListarCurso> convertAlunosToDtoListarCurso(List<ModelAluno> alunos) {
        return alunos.stream()
                     .map(aluno -> new DtoListarCurso(aluno.getNome(), aluno.getEmail(), aluno.getCurso()))
                     .collect(Collectors.toList());
    }
    
    public List<DtoListar> convertColaboradoresToDtoListar(List<ModelColaborador> colaboradores) {
        return colaboradores.stream()
                            .map(colaborador -> DtoListar(objeto2.nome, objeto2.email, objeto2.curso))
                            .collect(Collectors.toList());
    }
}
