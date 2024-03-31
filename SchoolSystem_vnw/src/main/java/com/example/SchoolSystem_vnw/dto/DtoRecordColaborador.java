package com.example.SchoolSystem_vnw.dto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.SchoolSystem_vnw.enums.EnumCargo;


import jakarta.validation.constraints.NotBlank;

public record DtoRecordColaborador(String nome, String cpf, String email, EnumCargo cargo) {


}
