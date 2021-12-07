package com.springboot.tarea.diciembre.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.tarea.diciembre.models.entity.Usuario;


public interface UsuarioDao extends JpaRepository<Usuario, Long>{

	public Usuario findByUsername(String username);
	
}
