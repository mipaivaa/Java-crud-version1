package com.example.SchoolSystem_vnw.controllers;

import java.util.List;
import java.util.Optional;
//import org.apache.el.stream.Optional;
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

import com.example.SchoolSystem_vnw.dto.DtoRecordColaborador;
import com.example.SchoolSystem_vnw.models.Endereco;
import com.example.SchoolSystem_vnw.models.ModelColaborador;
import com.example.SchoolSystem_vnw.dto.DtoRecordColaborador;
import com.example.SchoolSystem_vnw.repositories.RepositoryColaborador;


import com.example.SchoolSystem_vnw.service.ServiceColaborador;
import jakarta.validation.Valid;

@RestController
@RequestMapping
public class ControllerColaborador {

	@Autowired 
	RepositoryColaborador colaboradorRepository1;
	
	@PostMapping("/novoscolaboradores")
	public ResponseEntity<ModelColaborador>saveColaborador(@RequestBody DtoRecordColaborador dtoRecordColaborador ){ //o método espera receber um objeto do tipo DtoRecordColaborador da requisição HTT e sses dados seão salvos
		
	    var modelcolaborador =new ModelColaborador(dtoRecordColaborador.nome(),dtoRecordColaborador.email(),dtoRecordColaborador.cpf(),dtoRecordColaborador.cargo(), new Endereco(dtoRecordColaborador.endereco()));
		
		BeanUtils.copyProperties(dtoRecordColaborador, modelcolaborador); // converter Dto para model
		
		return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorRepository1.save(modelcolaborador));
	}
	
    @GetMapping("/colaboradores")
    public ResponseEntity<List<ModelColaborador>> getAllColaboradores(){
    	return ResponseEntity.status(HttpStatus.OK).body(colaboradorRepository1.findAll());
    }
    
    @GetMapping("/colaboradores/{id}")
    		public ResponseEntity<Object> getOneColaborador(@PathVariable(value="id") long id){
    			Optional<ModelColaborador> colaborador0 = colaboradorRepository1.findById(id);
    			if(colaborador0.isEmpty()) {
    				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrado.");
    			}
    			return ResponseEntity.status(HttpStatus.OK).body(colaborador0.get());
    		}
    @PutMapping("/colaboradores/{id}")
	public ResponseEntity<Object> updateColaborador(@PathVariable(value="id") long id,
													  @RequestBody DtoRecordColaborador dtoRecordColaborador ) {
		Optional<ModelColaborador> colaborador0 = colaboradorRepository1.findById(id);
		if(colaborador0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador nao encontrado.");
		}
		var modelColaborador = colaborador0.get();
		BeanUtils.copyProperties(dtoRecordColaborador, modelColaborador);
		return ResponseEntity.status(HttpStatus.OK).body(colaboradorRepository1.save(modelColaborador));
	}
    
    @DeleteMapping("/colaboradores/{id}")
	public ResponseEntity<Object> deleteColaborador(@PathVariable(value="id") long id) {
		Optional <ModelColaborador> colaborador0 = colaboradorRepository1.findById(id);
		if(colaborador0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrado.");
		}
		colaboradorRepository1.delete(colaborador0.get());
		return ResponseEntity.status(HttpStatus.OK).body("Colaborador deletado com sucesso");
	}
}
