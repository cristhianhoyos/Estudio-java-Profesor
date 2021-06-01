package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ILenguajeDAO;
import com.example.demo.entity.LenguajeEntity;

@Service
public class LenguajeServiceImp implements ILenguajeService {

	@Autowired
	private ILenguajeDAO dao;
	
	@Override
	@Transactional(readOnly=true)
	public List<LenguajeEntity> findAll() {
		// TODO Auto-generated method stub
		return (List<LenguajeEntity>) dao.findAll();
	}

	@Override
	public void save(LenguajeEntity lenguaje) {
		dao.save(lenguaje);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<LenguajeEntity> findLenguajeById(Long id) {
		// TODO Auto-generated method stub
		return  (Optional<LenguajeEntity>)dao.findById(id);
	}

}
