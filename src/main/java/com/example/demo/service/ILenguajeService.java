package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.LenguajeEntity;

public interface ILenguajeService {
	
	public List<LenguajeEntity> findAll();
	
	public void save (LenguajeEntity lenguaje);
	
	public Optional<LenguajeEntity> findLenguajeById(Long id);

}
