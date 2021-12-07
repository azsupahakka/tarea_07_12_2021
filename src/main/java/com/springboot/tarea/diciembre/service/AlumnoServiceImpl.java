package com.springboot.tarea.diciembre.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.tarea.diciembre.exception.DataBaseException;
import com.springboot.tarea.diciembre.models.dao.AlumnoDao;
import com.springboot.tarea.diciembre.models.entity.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	Map<String, Object> response = new HashMap<>();
	
	@Autowired
	private AlumnoDao alumnoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll() {
		return (List<Alumno>) alumnoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> findById(Long id) {
		
		Alumno alumno = null;
		try {
			alumno = alumnoDao.findById(id).orElseThrow(() -> new DataBaseException("404 NOT FOUND",
					"Este alumno no existe en la bbdd", HttpStatus.NOT_FOUND));
		} catch (DataAccessException e) {
			throw new DataBaseException("INTERNAL_SERVER_ERROR", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> save(Alumno alumno) {
		Alumno alumnoGuardado = null;
		try {
			alumnoDao.save(alumno);
		} catch (DataAccessException e) {
			throw new DataBaseException("INTERNAL_SERVER_ERROR", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Alumno ha sido creado");
		response.put("alumno", alumnoGuardado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<?> update(Alumno alumno, Long id) {
		Alumno alumnoUpdated = null;
		try {
			Alumno alumnoActual = alumnoDao.findById(id).orElseThrow(() -> new DataBaseException("404 NOT FOUND",
					"Este alumno no existe en la bbdd", HttpStatus.NOT_FOUND));
			alumnoActual.setNombre(alumno.getNombre());
			alumnoActual.setApellido(alumno.getApellido());
			alumnoActual.setDni(alumno.getDni());
			alumnoActual.setEmail(alumno.getEmail());
			alumnoActual.setTelefono(alumno.getTelefono());
			alumnoActual.setDireccion(alumno.getDireccion());
			alumnoActual.setCodigoPostal(alumno.getCodigoPostal());

			alumnoUpdated = alumnoDao.save(alumnoActual);
		} catch (DataAccessException e) {
			throw new DataBaseException("INTERNAL_SERVER_ERROR", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Alumno ha sido actualizado");
		response.put("alumno", alumnoUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<?> delete(Long id) {
		try {
			alumnoDao.deleteById(id);
		} catch (DataAccessException e) {
			throw new DataBaseException("INTERNAL_SERVER_ERROR", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Alumno ha sido borrado");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}


}
