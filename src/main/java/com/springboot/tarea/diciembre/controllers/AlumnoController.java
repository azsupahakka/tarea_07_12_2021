package com.springboot.tarea.diciembre.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.tarea.diciembre.models.entity.Alumno;
import com.springboot.tarea.diciembre.service.AlumnoService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	//Listar todos los alumnos
	@GetMapping("/alumnos")
	public List<Alumno> mostrarTodos() {
		return alumnoService.findAll();
	}

	//Listar alumonos por ID
	@GetMapping("/alumnos/{id}")
	public ResponseEntity<?> mostrarId(@PathVariable Long id) {
		return alumnoService.findById(id);
	}

	//Guardar alumno
	@PostMapping("/alumnos")
	public ResponseEntity<?> guardar(@RequestBody Alumno alumno) {
		return alumnoService.save(alumno);
	}

	//Actualizar datos de un alumno
	@PutMapping("/alumnos/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Alumno alumno, @PathVariable Long id) {
		return alumnoService.update(alumno, id);
	}

	//Borrar alumno
	@DeleteMapping("/alumnos/{id}")
	public ResponseEntity<?> borrar(@PathVariable Long id) {
		return alumnoService.delete(id);
	}


}
