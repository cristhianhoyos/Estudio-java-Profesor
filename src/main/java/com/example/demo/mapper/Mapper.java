package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.ProfesoresEntity;
import com.example.demo.model.MProfesor;

@Component("mapper")
public class Mapper {
	
	public static List<MProfesor> convertirLista(List<ProfesoresEntity> profesores){
		List<MProfesor> mProfesores = new ArrayList<>();
		for(ProfesoresEntity profesor: profesores) {
			mProfesores.add(new MProfesor(profesor));
		}
		return mProfesores;
	}

}
