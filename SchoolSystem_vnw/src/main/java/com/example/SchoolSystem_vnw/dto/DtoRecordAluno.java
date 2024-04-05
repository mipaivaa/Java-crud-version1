package com.example.SchoolSystem_vnw.dto;

import com.example.SchoolSystem_vnw.enums.EnumCurso;

public record DtoRecordAluno(String nome, String email, String cpf, EnumCurso curso,String telefone) {

}
