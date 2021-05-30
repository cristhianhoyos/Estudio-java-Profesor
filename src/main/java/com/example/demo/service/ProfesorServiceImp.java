package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IProfesoresDAO;
import com.example.demo.entity.ProfesoresEntity;

@Service
public class ProfesorServiceImp implements IProfesorService {

	@Autowired
	private IProfesoresDAO profesorDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ProfesoresEntity> findAll() {
		return (List<ProfesoresEntity>) profesorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ProfesoresEntity findProfesor(ProfesoresEntity profesor) {
		return (ProfesoresEntity) profesorDao.findByEmail(profesor.getEmail());
	}

	@Override
	@Transactional(readOnly = true)
	public ProfesoresEntity checkProfesorLogin(ProfesoresEntity profesor) {
		return (ProfesoresEntity) profesorDao.findByEmailAndPassword(profesor.getEmail(), profesor.getPassword());
	}

	@Override
	@Transactional
	public void deleteProfesor(ProfesoresEntity profesor) {
		profesorDao.deleteById(profesor.getId());
		
	}

	@Override
	@Transactional
	public ProfesoresEntity uptadeProfesor(ProfesoresEntity profesor) {
		return (ProfesoresEntity)profesorDao.save(profesor);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ProfesoresEntity> findProfesorById(Long profesor_id) {
		return (Optional<ProfesoresEntity>)profesorDao.findById(profesor_id);
	}

	@Override
	@Transactional
	public void deleteProfesor(Long id) {
		profesorDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ProfesoresEntity findById(Long id) {
		return profesorDao.findById(id).orElse(null);
	}

	/*@Override
	@Transactional(readOnly = true)
	public ProfesoresEntity findByIdSQL(Long id) {
		return profesorDao.findByIdSQL(id);
	}*/

	@Override
	@Transactional
	public void save(ProfesoresEntity profesor) {
		profesorDao.save(profesor);
	}

	@Override
	@Transactional
	public void deleteAllProfesor() {
		profesorDao.deleteAll();
	}
}
