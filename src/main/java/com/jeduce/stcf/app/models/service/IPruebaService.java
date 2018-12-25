package com.jeduce.stcf.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jeduce.stcf.app.models.entity.Prueba;

public interface IPruebaService {
	public List<Prueba> findAll();
	
	public Page<Prueba> findAll(Pageable pageable);

	public void save(Prueba prueba);
	
	public Prueba findOne(Long id);
	
	public void delete(Long id);
}
