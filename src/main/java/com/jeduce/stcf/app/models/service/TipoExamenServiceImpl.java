package com.jeduce.stcf.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeduce.stcf.app.models.dao.ITipoExamenDao;
import com.jeduce.stcf.app.models.entity.TipoExamen;

@Service
public class TipoExamenServiceImpl implements ITipoExamenService {

	@Autowired
	private ITipoExamenDao tipoExamenDao;	
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoExamen> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoExamen>) tipoExamenDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<TipoExamen> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return tipoExamenDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(TipoExamen tipoExamen) {
		// TODO Auto-generated method stub
		tipoExamenDao.save(tipoExamen);
		
	}

	@Override
	@Transactional(readOnly = true)
	public TipoExamen findOne(Long id) {
		// TODO Auto-generated method stub
		return tipoExamenDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		tipoExamenDao.deleteById(id);
		
	}

}
