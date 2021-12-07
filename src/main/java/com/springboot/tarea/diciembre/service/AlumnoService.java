package com.springboot.tarea.diciembre.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springboot.tarea.diciembre.models.entity.Alumno;


public interface AlumnoService {

	public List<Alumno> findAll();

	public ResponseEntity<?> findById(Long id);

	public ResponseEntity<?> save(Alumno alumno);

	public ResponseEntity<?> delete(Long id);

	public ResponseEntity<?> update(Alumno alumno, Long id);
}
