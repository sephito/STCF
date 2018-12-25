package com.jeduce.stcf.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jeduce.stcf.app.models.entity.Examen;
import com.jeduce.stcf.app.models.entity.Prueba;
import com.jeduce.stcf.app.models.entity.TipoExamen;

public interface IExamenService {
	public List<Examen> findAll();
	
	public Page<Examen> findAll(Pageable pageable);

	public void save(Examen examen);
	
	public Examen findOne(Long id);
	
	public void delete(Long id);
	
	public List<Prueba> findAllPrueba();
	
	public List<TipoExamen> findAllTipoExamen();
	
	
	public Page<Examen> fetchByIdWithExamenWhithTipoExamenWithPrueba(Pageable pageable);
	
}
