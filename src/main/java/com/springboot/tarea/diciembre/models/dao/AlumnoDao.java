package com.springboot.tarea.diciembre.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.tarea.diciembre.models.entity.Alumno;

public interface AlumnoDao extends CrudRepository<Alumno, Long> {

}
