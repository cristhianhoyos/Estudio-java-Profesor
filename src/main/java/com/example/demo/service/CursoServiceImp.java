package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ICursoDAO;
import com.example.demo.entity.CursoEntity;

@Service
public class CursoServiceImp implements ICursoService {
	
	@Autowired
	private ICursoDAO dao;

	@Override
	@Transactional(readOnly=true)
	public List<CursoEntity> findAll() {
		// TODO Auto-generated method stub
		return (List<CursoEntity>)dao.findAll();
	}

	@Override
	public void Save(CursoEntity curso) {
		dao.save(curso);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<CursoEntity> getProfesorCurso(Long id) {
		// TODO Auto-generated method stub
		return (List<CursoEntity>)dao.findByProfesorId(id);
	}

}
