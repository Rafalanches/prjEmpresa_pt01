package com.rafael.PrjEmpresa.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.PrjEmpresa.entities.Funcionarios;
import com.rafael.PrjEmpresa.repositories.FuncionarioRepository;



@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionarioRepository;
	
	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository =funcionarioRepository;
	}
	
		public Funcionarios getFuncionariosById(Long Funcodigo) {
			return funcionarioRepository.findById(Funcodigo).orElse(null);
		}
		
		public  List<Funcionarios> getAllFuncionarios(){
			return funcionarioRepository.findAll();
		}
			
		public Funcionarios saveFuncionarios(Funcionarios livro) {
			return funcionarioRepository.save(livro);		
		}
		
		public void deleteFuncionarios(Long Funcodigo){
			funcionarioRepository.deleteById(Funcodigo);	
		}	


	public Funcionarios updateFuncionarios(Long Funcodigo, Funcionarios novoFuncionarios) {
		Optional<Funcionarios> funcionarioOptional = funcionarioRepository.findById(Funcodigo);
			if (funcionarioOptional.isPresent()) {
				Funcionarios funcionarioExistente = funcionarioOptional.get();
				funcionarioExistente.setFunnome(novoFuncionarios.getFunnome());
				funcionarioExistente.setFunnascimento(novoFuncionarios.getFunnascimento());      
				funcionarioExistente.setFunsalario(novoFuncionarios.getFunsalario());  
			return funcionarioRepository.save(funcionarioExistente); 
			} else {
				return null; 
			}
		    
	}
}
