package com.rafael.PrjEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.PrjEmpresa.entities.Funcionarios;

public interface FuncionarioRepository extends JpaRepository<Funcionarios, Long> {

}
