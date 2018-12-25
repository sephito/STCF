package com.jeduce.stcf.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jeduce.stcf.app.models.entity.Tcf;
import com.jeduce.stcf.app.models.entity.TcfyDet;
import com.jeduce.stcf.app.models.entity.Unidad;
import com.jeduce.stcf.app.models.entity.Usuario;

public interface IUsuarioService {
	public List<Usuario> findAll();
	
	public Page<Usuario> findAll(Pageable pageable);

	public void save(Usuario usuario);
	
	public Usuario findOne(Long id);
	
	public void delete(Long id);
	
	
	
	public List<TcfyDet> ByTcfyDetFM();
	public List<TcfyDet> ByTcfyDetFMA();
	public List<TcfyDet> ByTcfyDetMM();
	public List<TcfyDet> ByTcfyDetMM(String codPeriodo,String codUnidad,Long tipoExamen);
	public List<TcfyDet> ByTcfyDetMMA();
	public List<TcfyDet> ByTcfyDetFE();
	public List<Unidad> ByUnidad();
	public List<Unidad> ByUnidad(String codigo);
	public List<Tcf> ByTcf(String codigo);
}
