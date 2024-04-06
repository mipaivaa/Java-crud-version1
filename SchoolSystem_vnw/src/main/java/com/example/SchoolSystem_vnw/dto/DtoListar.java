package com.example.SchoolSystem_vnw.dto;

import com.example.SchoolSystem_vnw.enums.EnumCurso;

public record DtoListar(
	    String nome,
	    String email,
	    EnumCurso curso
	) {}