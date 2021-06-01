package com.example.demo.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LenguajeEntity;
import com.example.demo.entity.ProfesoresEntity;
import com.example.demo.model.MProfesorLenguaje;
import com.example.demo.service.LenguajeServiceImp;
import com.example.demo.service.ProfesorServiceImp;

@RestController
@RequestMapping("/PL")
public class ProfesorLenguajeRestController {
	
	@Autowired
	private LenguajeServiceImp service;
	
	@Autowired
	private ProfesorServiceImp profesor;
	
	@PostMapping("/lenguajes")
	public ResponseEntity<?> ListLP(@RequestBody ProfesoresEntity profesores){
		ProfesoresEntity profesoresDB = profesor.findById(profesores.getId());
		if(profesoresDB != null) {
			Collection<LenguajeEntity> listaLenguaje = profesoresDB.getLenguajes();
			if(listaLenguaje!=null) {
				return new ResponseEntity<>(listaLenguaje,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveLenguaje(@RequestBody MProfesorLenguaje profesorLenguaje){
		ProfesoresEntity profesorDB = profesor.findById(profesorLenguaje.getProfesor().getId());
		if(profesorDB != null)
		{
			Optional<LenguajeEntity> lenguajeDB = service.findLenguajeById(profesorLenguaje.getLenguaje().getId());
			if(lenguajeDB != null) {
				profesorDB.addLenguaje(lenguajeDB);
			}
			else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}

}
