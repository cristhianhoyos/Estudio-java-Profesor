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

import com.example.demo.entity.LenguajeEntity;
import com.example.demo.service.LenguajeServiceImp;

@RestController
@RequestMapping("/lenguajes")
public class LenguajeRestController {
	
	@Autowired
	private LenguajeServiceImp service;
	
	@GetMapping("/all")
	public ResponseEntity<?> findAll(){
		List<LenguajeEntity> listaLenguajes = service.findAll();
		if(listaLenguajes != null) {
			if(listaLenguajes.size() > 0) {
				return new ResponseEntity<>(listaLenguajes,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}
		else {
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/createLenguaje")
	public ResponseEntity<?> agregarLenguaje(@RequestBody LenguajeEntity lenguaje){
		service.save(lenguaje);
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}

}
