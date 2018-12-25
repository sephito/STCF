package com.jeduce.stcf.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeduce.stcf.app.models.dao.IPeriodoDao;
import com.jeduce.stcf.app.models.entity.Periodo;

@Service
public class PeriodoServiceImpl implements IPeriodoService {

	@Autowired
	private IPeriodoDao periodoDao;	
	
	@Override
	@Transactional(readOnly = true)	
	public List<Periodo> findAll() {
		// TODO Auto-generated method stub
		return (List<Periodo>) periodoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)	
	public Page<Periodo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return periodoDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Periodo periodo) {
		// TODO Auto-generated method stub
		periodoDao.save(periodo);
	}

	@Override
	@Transactional(readOnly = true)	
	public Periodo findOne(String id) {
		// TODO Auto-generated method stub
		return periodoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		periodoDao.deleteById(id);
	}

}
