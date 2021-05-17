package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.CursoEntity;

public interface ICursoDAO extends CrudRepository<CursoEntity,Long> {
	
	public List<CursoEntity> findByProfesorId(Long id);
}
