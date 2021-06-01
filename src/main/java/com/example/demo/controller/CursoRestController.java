package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CursoEntity;
import com.example.demo.entity.ProfesoresEntity;
import com.example.demo.service.ICursoService;

@RestController
@RequestMapping("/cursos")
public class CursoRestController {

	@Autowired
	private ICursoService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> listaGetCursos(){
		List<CursoEntity> listarCurso = service.findAll();
		if (listarCurso!=null) {
			if(listarCurso.size()>0) {
				return new ResponseEntity<>(listarCurso,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); 
		}
	}
	
	@PostMapping("/createCurso")
	public ResponseEntity<?> createCurso(@RequestBody CursoEntity curso){
		service.Save(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PostMapping("/cursoProfesor")
	public ResponseEntity<?> findCursoProfesor(@RequestBody ProfesoresEntity profesor){
		List<CursoEntity> listaCursos = null;
		listaCursos = service.getProfesorCurso(profesor.getId());
		if(listaCursos != null) {
			if(listaCursos.size()>0) {
				return new ResponseEntity<> (listaCursos,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
}
