package com.jeduce.stcf.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jeduce.stcf.app.models.entity.TiempoDescuento;

public interface ITiempoDescuentoDao extends PagingAndSortingRepository<TiempoDescuento, String> {

}
