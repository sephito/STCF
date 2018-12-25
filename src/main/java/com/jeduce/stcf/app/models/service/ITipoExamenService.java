package com.jeduce.stcf.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jeduce.stcf.app.models.entity.TipoExamen;

public interface ITipoExamenService  {
	public List<TipoExamen> findAll();
	
	public Page<TipoExamen> findAll(Pageable pageable);

	public void save(TipoExamen tipoExamen);
	
	public TipoExamen findOne(Long id);
	
	public void delete(Long id);
}
