package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CursoEntity;

public interface ICursoService {
	
	public List<CursoEntity> findAll();
	
	public void Save (CursoEntity curso);
	
	public List<CursoEntity> getProfesorCurso(Long id);

}
