package com.jeduce.stcf.app.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jeduce.stcf.app.models.entity.Examen;


public interface IExamenDao extends PagingAndSortingRepository<Examen, Long> { 

	//@Query("select f from Factura f join fetch f.cliente c join fetch f.items l join fetch l.producto where f.id=?1")
	@Query("select DISTINCT f from Examen f inner join f.prueba p inner join f.tipoExamen t")
	public Page<Examen> fetchByIdWithExamenWhithTipoExamenWithPrueba(Pageable pageable);
	
}
