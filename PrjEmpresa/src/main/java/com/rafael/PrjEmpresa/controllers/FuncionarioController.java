package com.rafael.PrjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.PrjEmpresa.entities.Funcionarios;
import com.rafael.PrjEmpresa.servicies.FuncionarioService;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@GetMapping("/home")
    public String paginaInicial() {
        return "index";
    }
	private final FuncionarioService funcionarioService;
	
	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;		
	}
	@GetMapping("/{depcodigo}")	
    public ResponseEntity<Funcionarios> getJogo(@PathVariable Long Funcodigo) {
		Funcionarios funcionarios = funcionarioService.getFuncionariosById(Funcodigo);
        if (funcionarios != null) {
            return ResponseEntity.ok(funcionarios);
        } else {
            return ResponseEntity.notFound().build();
        }
    }	
	@PostMapping
	public Funcionarios createFuncionarios(@RequestBody Funcionarios funcionarios) {
		return funcionarioService.saveFuncionarios(funcionarios);
	}
	
	@DeleteMapping("/{depcodigo}")
	public void deleteFuncionarios(@PathVariable Long Funcodigo) {
		funcionarioService.deleteFuncionarios(Funcodigo);
	}
	
		@GetMapping
		public ResponseEntity<List<Funcionarios>> getAllFuncionarios(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Funcionarios> funcionarios = funcionarioService.getAllFuncionarios();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(funcionarios);
		}
		
		@PutMapping("/{id}")
		public Funcionarios updateFuncionarios(@PathVariable Long Funcodigo, @RequestBody Funcionarios funcionarios) {
		    return funcionarioService.updateFuncionarios(Funcodigo, funcionarios);
		}
	
}

