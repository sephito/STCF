package com.jeduce.stcf.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jeduce.stcf.app.models.entity.Periodo;

public interface IPeriodoService {
	public List<Periodo> findAll();
	
	public Page<Periodo> findAll(Pageable pageable);

	public void save(Periodo periodo);
	
	public Periodo findOne(String id);
	
	public void delete(String id);
}
