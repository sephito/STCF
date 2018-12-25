package com.jeduce.stcf.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jeduce.stcf.app.models.entity.TipoExamen;

public interface ITipoExamenDao extends PagingAndSortingRepository<TipoExamen, Long> {

}
