package com.jeduce.stcf.app.models.dao;


import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.jeduce.stcf.app.models.entity.Examen;
import com.jeduce.stcf.app.models.entity.Tcf;
import com.jeduce.stcf.app.models.entity.TcfyDet;
import com.jeduce.stcf.app.models.entity.Unidad;
import com.jeduce.stcf.app.models.entity.UsuPer;
import com.jeduce.stcf.app.models.entity.Usuario;

public interface IUsuarioDao extends PagingAndSortingRepository<Usuario, Long> {

	
	public Usuario findByVusuarioNom(String username);		
	
	

	@Query(value ="select new com.jeduce.stcf.app.models.entity.Unidad(f.vnucleoDeslar,f.vgguuDeslar,f.vunidadDescor,f.cmilitarUuactual)	from Tcf f 	GROUP BY  f.vnucleoDeslar,f.vgguuDeslar,f.vunidadDescor,f.cmilitarUuactual ORDER BY f.vnucleoDeslar,f.vgguuDeslar,f.vunidadDescor,f.cmilitarUuactual ASC 	")
	public List<Unidad> ByUnidad();
	
	@Query(value ="select new com.jeduce.stcf.app.models.entity.Unidad(f.vnucleoDeslar,f.vgguuDeslar,f.vunidadDescor,f.cmilitarUuactual)	from Tcf f where f.cperiodoCod=?1	GROUP BY  f.vnucleoDeslar,f.vgguuDeslar,f.vunidadDescor,f.cmilitarUuactual ORDER BY f.vnucleoDeslar,f.vgguuDeslar,f.vunidadDescor,f.cmilitarUuactual ASC 	")
	public List<Unidad> ByUnidad(String codigo);	
	
	@Query("SELECT f FROM Tcf f join fetch f.usuario u  WHERE f.cmilitarUuactual = ?1 ORDER BY f.cgradoCod,u.vpersonaApetpat,u.vpersonaApetmat,u.vpersonaNomre,f.nedadNum ASC")
	public List<Tcf> ByTcf(String codigo);

	
	@Query(value="select new com.jeduce.stcf.app.models.entity.UsuPer(u.id,u.CDOCIDENTIDAD_COD,u.CPERSONA_NRODOC,u.VUSUARIO_NOM,p.vpersona_apetpat,p.vpersona_apetmat,p.vpersona_nombre,p.cmilitar_cip,p.varmas_descor,p.cgrado_desccort) from doc_usuario u  left join PER_PRINCIPAL.PER_PERSONA_SCTF@PER_PRINCIPAL p  on u.CDOCIDENTIDAD_COD=p.cdocidentidad_cod  and u.CPERSONA_NRODOC = p.cpersona_nrodoc where u.cestado_val='1' order by p.cmilitar_gradoactual,p.vpersona_apetpat,p.vpersona_apetmat,p.vpersona_nombre ASC; ",nativeQuery=true)
	public List<UsuPer> ByUsuarioPersona();
	
	


	
	}
