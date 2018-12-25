package com.jeduce.stcf.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeduce.stcf.app.models.dao.IPruebaDao;
import com.jeduce.stcf.app.models.entity.Prueba;


@Service
public class PruebaServiceImpl implements IPruebaService {

	@Autowired
	private IPruebaDao pruebaDao;	
	
	@Override
	@Transactional(readOnly = true)	
	public List<Prueba> findAll() {
		// TODO Auto-generated method stub
		return (List<Prueba>) pruebaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)	
	public Page<Prueba> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return pruebaDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Prueba prueba) {
		// TODO Auto-generated method stub
		pruebaDao.save(prueba);
	}

	@Override
	@Transactional(readOnly = true)	
	public Prueba findOne(Long id) {
		// TODO Auto-generated method stub
		return pruebaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		pruebaDao.deleteById(id);
	}

}
