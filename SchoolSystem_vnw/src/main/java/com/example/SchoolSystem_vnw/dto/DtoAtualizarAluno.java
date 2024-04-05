package com.example.SchoolSystem_vnw.dto;


import com.example.SchoolSystem_vnw.enums.EnumCurso;

public record DtoAtualizarAluno(String nome, String email,String telefone,EnumCurso curso) {

}
