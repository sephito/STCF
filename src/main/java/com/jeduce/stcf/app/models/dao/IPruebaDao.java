package com.jeduce.stcf.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jeduce.stcf.app.models.entity.Prueba;

public interface IPruebaDao extends PagingAndSortingRepository<Prueba, Long> {

}
