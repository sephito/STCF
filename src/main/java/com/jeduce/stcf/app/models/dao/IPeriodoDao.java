package com.jeduce.stcf.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jeduce.stcf.app.models.entity.Periodo;

public interface IPeriodoDao extends PagingAndSortingRepository<Periodo, String> {

}
