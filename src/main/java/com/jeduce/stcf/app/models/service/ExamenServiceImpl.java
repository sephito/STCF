package com.jeduce.stcf.app.models.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeduce.stcf.app.models.dao.IExamenDao;
import com.jeduce.stcf.app.models.dao.IPruebaDao;
import com.jeduce.stcf.app.models.dao.ITipoExamenDao;
import com.jeduce.stcf.app.models.entity.Examen;
import com.jeduce.stcf.app.models.entity.Prueba;
import com.jeduce.stcf.app.models.entity.TipoExamen;
@Service
public class ExamenServiceImpl implements IExamenService {

	@Autowired
	private IExamenDao examenDao;	
	
	@Autowired
	private IPruebaDao pruebaDao;	
	
	@Autowired
	private ITipoExamenDao tipoExamenDao;	
	
	@Override
	@Transactional(readOnly = true)	
	public List<com.jeduce.stcf.app.models.entity.Examen> findAll() {
		// TODO Auto-generated method stub
		return (List<Examen>) examenDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)	
	public Page<com.jeduce.stcf.app.models.entity.Examen> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return examenDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(com.jeduce.stcf.app.models.entity.Examen examen) {
		// TODO Auto-generated method stub
		examenDao.save(examen);
	}

	@Override
	@Transactional(readOnly = true)	
	public com.jeduce.stcf.app.models.entity.Examen findOne(Long id) {
		// TODO Auto-generated method stub
		return examenDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		examenDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Prueba> findAllPrueba() {
		// TODO Auto-generated method stub
		return (List<Prueba>) pruebaDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoExamen> findAllTipoExamen() {
		// TODO Auto-generated method stub
		return (List<TipoExamen>) tipoExamenDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)	
	public Page<com.jeduce.stcf.app.models.entity.Examen> fetchByIdWithExamenWhithTipoExamenWithPrueba(Pageable pageable) {
		// TODO Auto-generated method stub
		return examenDao.fetchByIdWithExamenWhithTipoExamenWithPrueba(pageable);
	}


	
	

}
