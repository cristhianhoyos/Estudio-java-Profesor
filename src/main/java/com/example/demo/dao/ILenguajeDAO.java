package com.example.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.LenguajeEntity;

public interface ILenguajeDAO extends CrudRepository<LenguajeEntity,Long> {


}
