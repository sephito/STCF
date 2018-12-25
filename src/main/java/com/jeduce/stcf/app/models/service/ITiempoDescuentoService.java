package com.jeduce.stcf.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jeduce.stcf.app.models.entity.TiempoDescuento;

public interface ITiempoDescuentoService {
	public List<TiempoDescuento> findAll();
	
	public Page<TiempoDescuento> findAll(Pageable pageable);

	public void save(TiempoDescuento tiempoDescuento);
	
	public TiempoDescuento findOne(String id);
	
	public void delete(String id);
}

