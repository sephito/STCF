package com.jeduce.stcf.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeduce.stcf.app.models.dao.ITiempoDescuentoDao;
import com.jeduce.stcf.app.models.entity.TiempoDescuento;
@Service
public class TiempoDescuentoServiceImpl implements ITiempoDescuentoService {

	@Autowired
	private ITiempoDescuentoDao tiempoDescuentoDao;	
	
	@Override
	@Transactional(readOnly = true)	
	public List<TiempoDescuento> findAll() {
		// TODO Auto-generated method stub
		return (List<TiempoDescuento>) tiempoDescuentoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)	
	public Page<TiempoDescuento> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return tiempoDescuentoDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(TiempoDescuento tiempoDescuento) {
		// TODO Auto-generated method stub
		tiempoDescuentoDao.save(tiempoDescuento);
	}

	@Override
	@Transactional(readOnly = true)	
	public TiempoDescuento findOne(String id) {
		// TODO Auto-generated method stub
		return tiempoDescuentoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		tiempoDescuentoDao.deleteById(id);
	}

}
