package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.ProfesoresEntity;

public interface IProfesoresDAO extends CrudRepository<ProfesoresEntity,Long> {

	public ProfesoresEntity findByEmail(String email);
	
	public ProfesoresEntity findByEmailAndPassword(String email, String password);
	
	public Optional<ProfesoresEntity> findById(Long id);
	/*
	@Query("select p from Profesores p where p.id=?1")
	public ProfesoresEntity findByIdSQL(Long id);*/
}
