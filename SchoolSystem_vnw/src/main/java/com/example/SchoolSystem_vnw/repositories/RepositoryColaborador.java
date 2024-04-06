package com.example.SchoolSystem_vnw.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SchoolSystem_vnw.dto.DtoRecordColaborador;
import com.example.SchoolSystem_vnw.models.ModelColaborador;


import jakarta.validation.Valid;

@Repository
public interface RepositoryColaborador extends JpaRepository <ModelColaborador, Long>{
	Optional<ModelColaborador> findByCpf(String cpf);
	

}
