package com.example.SchoolSystem_vnw.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SchoolSystem_vnw.dto.DtoAtualizarAluno;
import com.example.SchoolSystem_vnw.dto.DtoRecordAluno;
import com.example.SchoolSystem_vnw.dto.DtoRecordColaborador;
import com.example.SchoolSystem_vnw.models.ModelAluno;
import com.example.SchoolSystem_vnw.models.ModelColaborador;
import com.example.SchoolSystem_vnw.repositories.RepositoryAluno;
import com.example.SchoolSystem_vnw.repositories.RepositoryColaborador;

@RestController
@RequestMapping
public class ControllerAluno {
	
	@Autowired 
	RepositoryAluno alunoRepository1;
	
	@PostMapping("/novoaluno")
	public ResponseEntity<ModelAluno>saveAluno(@RequestBody DtoRecordAluno dtoRecordAluno ){ //o método espera receber um objeto do tipo DtoRecordColaborador da requisição HTT e sses dados seão salvos
		
	    var modelaluno =new ModelAluno(); // PERGUNTAR!!
		
		BeanUtils.copyProperties(dtoRecordAluno, modelaluno); // converter Dto para model
		
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository1.save(modelaluno));
	}
	
    @GetMapping("/alunos")
    public ResponseEntity<List<ModelAluno>> getAllAlunos(){
    	return ResponseEntity.status(HttpStatus.OK).body(alunoRepository1.findAll());
    }
    
    @GetMapping("/alunos/{id}")
    		public ResponseEntity<Object> getOneAluno(@PathVariable(value="id") long id){
    			Optional<ModelAluno> aluno0 = alunoRepository1.findById(id);
    			if(aluno0.isEmpty()) {
    				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado."); // nem sempre é necessario isso, porque o cliente já é validado pelo sistema
    			}
    			return ResponseEntity.status(HttpStatus.OK).body(aluno0.get());
    		}
    @PutMapping("/alunos/{id}")
	public ResponseEntity<Object> updateAluno(@PathVariable(value="id") long id,
	    @RequestBody DtoAtualizarAluno dtoatualizaraluno) {
		Optional<ModelAluno> aluno0 = alunoRepository1.findById(id);
		if(aluno0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado."); // nem sempre é necessario isso, porque o cliente já é validado pelo sistema
		}
		var modelAluno = aluno0.get();
		BeanUtils.copyProperties(dtoatualizaraluno, modelAluno);
		return ResponseEntity.status(HttpStatus.OK).body(alunoRepository1.save(modelAluno));
	}
    
    @DeleteMapping("/alunos/{id}")
	public ResponseEntity<Object> deleteAluno(@PathVariable(value="id") long id) {
		Optional <ModelAluno> aluno0 = alunoRepository1.findById(id);
		if(aluno0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado."); // nem sempre é necessario isso, porque o cliente já é validado pelo sistema
		}
		alunoRepository1.delete(aluno0.get());
		return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso");
	}
}


