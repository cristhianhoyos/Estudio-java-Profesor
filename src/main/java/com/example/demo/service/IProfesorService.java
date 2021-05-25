package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.ProfesoresEntity;

public interface IProfesorService {
	
public List<ProfesoresEntity> findAll();
	
	public void save(ProfesoresEntity profesor);
	
	public ProfesoresEntity findProfesor(ProfesoresEntity profesor);
	
	public ProfesoresEntity checkProfesorLogin(ProfesoresEntity profesor);
	
	public void deleteProfesor(ProfesoresEntity profesor);
	
	public ProfesoresEntity uptadeProfesor(ProfesoresEntity profesor);
	
	public Optional<ProfesoresEntity> findProfesorById(Long profesor_id);
	
	public void deleteProfesor(Long id);
	
	public void deleteAllProfesor();
	
	public ProfesoresEntity findById(Long id);
	
	public ProfesoresEntity findByIdSQL(Long id);

}
