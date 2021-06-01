package com.example.demo.model;

import com.example.demo.entity.LenguajeEntity;
import com.example.demo.entity.ProfesoresEntity;

public class MProfesorLenguaje {

	private ProfesoresEntity profesor;
	
	private LenguajeEntity lenguaje;

	public ProfesoresEntity getProfesor() {
		return profesor;
	}

	public void setProfesor(ProfesoresEntity profesor) {
		this.profesor = profesor;
	}

	public LenguajeEntity getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(LenguajeEntity lenguaje) {
		this.lenguaje = lenguaje;
	}
	
	
}
