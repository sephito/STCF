package com.jeduce.stcf.app.models.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.jeduce.stcf.app.models.dao.IUsuarioDao;
import com.jeduce.stcf.app.models.entity.Tcf;
import com.jeduce.stcf.app.models.entity.TcfyDet;
import com.jeduce.stcf.app.models.entity.Unidad;
import com.jeduce.stcf.app.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	

	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDao.findAll();
	}


	
	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(Long id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		usuarioDao.deleteById(id);
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioDao.save(usuario);
	}


	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return usuarioDao.findAll(pageable);
	}







	@Override
	public List<Unidad> ByUnidad() {
		// TODO Auto-generated method stub
		return(List<Unidad>)  usuarioDao.ByUnidad();
	}



	@Override
	public List<Tcf> ByTcf(String codigo) {
		// TODO Auto-generated method stub
		return (List<Tcf>) usuarioDao.ByTcf(codigo);
	}







	@PersistenceContext
	private EntityManager em;	
	
	@SuppressWarnings("unchecked")
		@Override
		public List<TcfyDet> ByTcfyDetFM() {
		    //List<TcfyDet> employees = em.createNamedQuery("getallMilitares", TcfyDet.class).getResultList();
		    Query q = em.createNativeQuery("select  t.id,t.CGRADO_DESCCORT,t.VARMAS_DESCCORT,u.VPERSONA_APETPAT||u.VPERSONA_APETMAT||u.VPERSONA_NOMBRE NOMBRE,t.CPERSONA_SEXO, t.NEDAD_NUM,NVL(t.NPESO_NUM,0.00) NPESO_NUM,NVL(t.NTALLA_NUM,0.00) NTALLA_NUM,u.CASIMILADO_VAL,t.CNUCLEO_COD,t.CGGUU_COD,t.CMILITAR_UUACTUAL, case when (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) is null then -1 else (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end NOTI,case when (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) is null then -1 else (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end PUNI, case when (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3)is null then -1 else (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end REPI ,case when (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end NOTII,case when (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end PUNII, case when (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end REPII ,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end NOTIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end PUNIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end REPIII,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end NOTIV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end PUNIV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end REPIV,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end NOTV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end PUNV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end REPV,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end NOTVI,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end PUNVI, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end REPVI,case when (select NVL(COPT_VAL,' ')  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then ' ' else (select NVL(COPT_VAL,' ')  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end EJEVI_OPT,0 REPVI_MIN,0 REPVI_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end NOTVIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end PUNVIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end REPVIII,0 REPVIII_MIN,0 REPVIII_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end NOTIX,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end PUNIX, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end REPIX,0 REPVIX_MIN,0 REPVIX_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end NOTX,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end PUNX, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end REPX,0 REPX_MIN,0 REPX_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end NOTXI,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end PUNXI, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end REPXI,0 REPXI_MIN,0 REPXI_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end NOTXII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end PUNXII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end REPXII,0 REPXII_MIN,0 REPXII_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end NOTXIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end PUNXIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end REPXIII,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end NOTXIV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end PUNXIV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end REPXIV,0 REPXIV_MIN,0 REPXIV_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end NOTXV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end PUNXV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end REPXV,0 REPXV_MIN,0 REPXV_SEC,NVL(t.COBS_VAL,' ') COBS_VAL,NVL(t.VOBSERV_NOM,' ') VOBSERV_NOM,NVL(t.NPROMEDIO_NUM,0.00) NPROMEDIO_NUM,NVL(t.CRESULTADO_TIPO,' ') CRESULTADO_TIPO,NVL(t.NTOTAL_NUM,0.00) NTOTAL_NUM from doc_testcapacidadfisica t inner join doc_usuario u on u.id=t.USUARIO_ID WHERE t.tipo_examen_id=1 ORDER BY t.cgrado_Cod,u.VPERSONA_APETPAT,u.VPERSONA_APETMAT,u.VPERSONA_NOMBRE,t.NEDAD_NUM ASC");
		    List<Object[]> authors = q.getResultList();		    
		    
		    List<TcfyDet> lista = new ArrayList<TcfyDet>();
		    
			for (Object[] a : authors) {
				TcfyDet item = new TcfyDet(
						Long.valueOf(a[0].toString()).longValue(), 
						a[1].toString(), 
						a[2].toString(), 
						a[3].toString(), 
						a[4].toString(), 
						Long.valueOf(a[5].toString()).longValue(),
						Double.parseDouble(a[6].toString()), 
						Double.parseDouble(a[7].toString()), 
						a[8].toString(), 
						a[9].toString(), 
						a[10].toString(), 
						a[11].toString(), 
						Double.parseDouble(a[12].toString()), 
						Double.parseDouble(a[13].toString()),
						Double.parseDouble(a[14].toString()),
						Double.parseDouble(a[15].toString()),
						Double.parseDouble(a[16].toString()),
						Double.parseDouble(a[17].toString()),
						Double.parseDouble(a[18].toString()),
						Double.parseDouble(a[19].toString()), 
						Double.parseDouble(a[20].toString()),
						Double.parseDouble(a[21].toString()),
						Double.parseDouble(a[22].toString()),
						Double.parseDouble(a[23].toString()),
						Double.parseDouble(a[24].toString()),
						Double.parseDouble(a[25].toString()),
						Double.parseDouble(a[26].toString()),
						Double.parseDouble(a[27].toString()),
						Double.parseDouble(a[28].toString()),
						Double.parseDouble(a[29].toString()),
						a[30].toString(),
						Double.parseDouble(a[31].toString()), 
						Double.parseDouble(a[32].toString()),
						Double.parseDouble(a[33].toString()),
						Double.parseDouble(a[34].toString()),
						Double.parseDouble(a[35].toString()),
						Double.parseDouble(a[36].toString()), 
						Double.parseDouble(a[37].toString()),
						Double.parseDouble(a[38].toString()),
						Double.parseDouble(a[39].toString()),
						Double.parseDouble(a[40].toString()),
						Double.parseDouble(a[41].toString()), 
						Double.parseDouble(a[42].toString()),
						Double.parseDouble(a[43].toString()),
						Double.parseDouble(a[44].toString()), 
						Double.parseDouble(a[45].toString()),
						Double.parseDouble(a[46].toString()),
						Double.parseDouble(a[47].toString()),
						Double.parseDouble(a[48].toString()),
						Double.parseDouble(a[49].toString()),
						Double.parseDouble(a[50].toString()),
						Double.parseDouble(a[51].toString()),
						Double.parseDouble(a[52].toString()),
						Double.parseDouble(a[53].toString()),
						Double.parseDouble(a[54].toString()), 
						Double.parseDouble(a[55].toString()),
						Double.parseDouble(a[56].toString()),
						Double.parseDouble(a[57].toString()),
						Double.parseDouble(a[58].toString()),
						Double.parseDouble(a[59].toString()),
						Double.parseDouble(a[60].toString()), 
						Double.parseDouble(a[61].toString()),
						Double.parseDouble(a[62].toString()),
						Double.parseDouble(a[63].toString()),
						Double.parseDouble(a[64].toString()),
						Double.parseDouble(a[65].toString()),
						Double.parseDouble(a[66].toString()),
						Double.parseDouble(a[67].toString()),
						Double.parseDouble(a[68].toString()),
						Double.parseDouble(a[69].toString()),
						Double.parseDouble(a[70].toString()),
						a[71].toString(), 
						a[72].toString(), 
						Double.parseDouble(a[73].toString()), 
						a[74].toString(), 
						Double.parseDouble(a[75].toString()));
			  lista.add(item);
			    
			}
		    
		    return lista;
		}		
		
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TcfyDet> ByTcfyDetFMA() {
	    //List<TcfyDet> employees = em.createNamedQuery("getallMilitares", TcfyDet.class).getResultList();
	    Query q = em.createNativeQuery("select  t.id,t.CGRADO_DESCCORT,t.VARMAS_DESCCORT,u.VPERSONA_APETPAT||u.VPERSONA_APETMAT||u.VPERSONA_NOMBRE NOMBRE,t.CPERSONA_SEXO, t.NEDAD_NUM,NVL(t.NPESO_NUM,0.00) NPESO_NUM,NVL(t.NTALLA_NUM,0.00) NTALLA_NUM,u.CASIMILADO_VAL,t.CNUCLEO_COD,t.CGGUU_COD,t.CMILITAR_UUACTUAL, case when (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) is null then -1 else (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end NOTI,case when (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) is null then -1 else (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end PUNI, case when (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3)is null then -1 else (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end REPI ,case when (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end NOTII,case when (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end PUNII, case when (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end REPII ,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end NOTIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end PUNIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end REPIII,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end NOTIV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end PUNIV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end REPIV,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end NOTV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end PUNV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end REPV,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end NOTVI,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end PUNVI, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end REPVI,case when (select NVL(COPT_VAL,' ')  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then ' ' else (select NVL(COPT_VAL,' ')  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end EJEVI_OPT,0 REPVI_MIN,0 REPVI_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end NOTVIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end PUNVIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end REPVIII,0 REPVIII_MIN,0 REPVIII_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end NOTIX,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end PUNIX, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end REPIX,0 REPVIX_MIN,0 REPVIX_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end NOTX,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end PUNX, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end REPX,0 REPX_MIN,0 REPX_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end NOTXI,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end PUNXI, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end REPXI,0 REPXI_MIN,0 REPXI_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end NOTXII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end PUNXII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end REPXII,0 REPXII_MIN,0 REPXII_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end NOTXIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end PUNXIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end REPXIII,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end NOTXIV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end PUNXIV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end REPXIV,0 REPXIV_MIN,0 REPXIV_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end NOTXV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end PUNXV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end REPXV,0 REPXV_MIN,0 REPXV_SEC,NVL(t.COBS_VAL,' ') COBS_VAL,NVL(t.VOBSERV_NOM,' ') VOBSERV_NOM,NVL(t.NPROMEDIO_NUM,0.00) NPROMEDIO_NUM,NVL(t.CRESULTADO_TIPO,' ') CRESULTADO_TIPO,NVL(t.NTOTAL_NUM,0.00) NTOTAL_NUM from doc_testcapacidadfisica t inner join doc_usuario u on u.id=t.USUARIO_ID WHERE t.tipo_examen_id=2 ORDER BY t.cgrado_Cod,u.VPERSONA_APETPAT,u.VPERSONA_APETMAT,u.VPERSONA_NOMBRE,t.NEDAD_NUM ASC");
	    List<Object[]> authors = q.getResultList();		    
	    
	    List<TcfyDet> lista = new ArrayList<TcfyDet>();
	    
		for (Object[] a : authors) {
			TcfyDet item = new TcfyDet(
					Long.valueOf(a[0].toString()).longValue(), 
					a[1].toString(), 
					a[2].toString(), 
					a[3].toString(), 
					a[4].toString(), 
					Long.valueOf(a[5].toString()).longValue(),
					Double.parseDouble(a[6].toString()), 
					Double.parseDouble(a[7].toString()), 
					a[8].toString(), 
					a[9].toString(), 
					a[10].toString(), 
					a[11].toString(), 
					Double.parseDouble(a[12].toString()), 
					Double.parseDouble(a[13].toString()),
					Double.parseDouble(a[14].toString()),
					Double.parseDouble(a[15].toString()),
					Double.parseDouble(a[16].toString()),
					Double.parseDouble(a[17].toString()),
					Double.parseDouble(a[18].toString()),
					Double.parseDouble(a[19].toString()), 
					Double.parseDouble(a[20].toString()),
					Double.parseDouble(a[21].toString()),
					Double.parseDouble(a[22].toString()),
					Double.parseDouble(a[23].toString()),
					Double.parseDouble(a[24].toString()),
					Double.parseDouble(a[25].toString()),
					Double.parseDouble(a[26].toString()),
					Double.parseDouble(a[27].toString()),
					Double.parseDouble(a[28].toString()),
					Double.parseDouble(a[29].toString()),
					a[30].toString(),
					Double.parseDouble(a[31].toString()), 
					Double.parseDouble(a[32].toString()),
					Double.parseDouble(a[33].toString()),
					Double.parseDouble(a[34].toString()),
					Double.parseDouble(a[35].toString()),
					Double.parseDouble(a[36].toString()), 
					Double.parseDouble(a[37].toString()),
					Double.parseDouble(a[38].toString()),
					Double.parseDouble(a[39].toString()),
					Double.parseDouble(a[40].toString()),
					Double.parseDouble(a[41].toString()), 
					Double.parseDouble(a[42].toString()),
					Double.parseDouble(a[43].toString()),
					Double.parseDouble(a[44].toString()), 
					Double.parseDouble(a[45].toString()),
					Double.parseDouble(a[46].toString()),
					Double.parseDouble(a[47].toString()),
					Double.parseDouble(a[48].toString()),
					Double.parseDouble(a[49].toString()),
					Double.parseDouble(a[50].toString()),
					Double.parseDouble(a[51].toString()),
					Double.parseDouble(a[52].toString()),
					Double.parseDouble(a[53].toString()),
					Double.parseDouble(a[54].toString()), 
					Double.parseDouble(a[55].toString()),
					Double.parseDouble(a[56].toString()),
					Double.parseDouble(a[57].toString()),
					Double.parseDouble(a[58].toString()),
					Double.parseDouble(a[59].toString()),
					Double.parseDouble(a[60].toString()), 
					Double.parseDouble(a[61].toString()),
					Double.parseDouble(a[62].toString()),
					Double.parseDouble(a[63].toString()),
					Double.parseDouble(a[64].toString()),
					Double.parseDouble(a[65].toString()),
					Double.parseDouble(a[66].toString()),
					Double.parseDouble(a[67].toString()),
					Double.parseDouble(a[68].toString()),
					Double.parseDouble(a[69].toString()),
					Double.parseDouble(a[70].toString()),
					a[71].toString(), 
					a[72].toString(), 
					Double.parseDouble(a[73].toString()), 
					a[74].toString(), 
					Double.parseDouble(a[75].toString()));
		  lista.add(item);
		    
		}
	    
	    return lista;
	}		

	
	@SuppressWarnings("unchecked")
	@Override
	public List<TcfyDet> ByTcfyDetMM() {
	    //List<TcfyDet> employees = em.createNamedQuery("getallMilitares", TcfyDet.class).getResultList();
	    Query q = em.createNativeQuery("select  t.id,t.CGRADO_DESCCORT,t.VARMAS_DESCCORT,u.VPERSONA_APETPAT||u.VPERSONA_APETMAT||u.VPERSONA_NOMBRE NOMBRE,t.CPERSONA_SEXO, t.NEDAD_NUM,NVL(t.NPESO_NUM,0.00) NPESO_NUM,NVL(t.NTALLA_NUM,0.00) NTALLA_NUM,u.CASIMILADO_VAL,t.CNUCLEO_COD,t.CGGUU_COD,t.CMILITAR_UUACTUAL, case when (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) is null then -1 else (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end NOTI,case when (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) is null then -1 else (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end PUNI, case when (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3)is null then -1 else (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end REPI ,case when (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end NOTII,case when (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end PUNII, case when (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end REPII ,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end NOTIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end PUNIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end REPIII,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end NOTIV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end PUNIV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end REPIV,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end NOTV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end PUNV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end REPV,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end NOTVI,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end PUNVI, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end REPVI,case when (select NVL(COPT_VAL,' ')  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then ' ' else (select NVL(COPT_VAL,' ')  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end EJEVI_OPT,0 REPVI_MIN,0 REPVI_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end NOTVIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end PUNVIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end REPVIII,0 REPVIII_MIN,0 REPVIII_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end NOTIX,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end PUNIX, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end REPIX,0 REPVIX_MIN,0 REPVIX_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end NOTX,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end PUNX, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end REPX,0 REPX_MIN,0 REPX_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end NOTXI,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end PUNXI, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end REPXI,0 REPXI_MIN,0 REPXI_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end NOTXII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end PUNXII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end REPXII,0 REPXII_MIN,0 REPXII_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end NOTXIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end PUNXIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end REPXIII,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end NOTXIV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end PUNXIV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end REPXIV,0 REPXIV_MIN,0 REPXIV_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end NOTXV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end PUNXV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end REPXV,0 REPXV_MIN,0 REPXV_SEC,NVL(t.COBS_VAL,' ') COBS_VAL,NVL(t.VOBSERV_NOM,' ') VOBSERV_NOM,NVL(t.NPROMEDIO_NUM,0.00) NPROMEDIO_NUM,NVL(t.CRESULTADO_TIPO,' ') CRESULTADO_TIPO,NVL(t.NTOTAL_NUM,0.00) NTOTAL_NUM from doc_testcapacidadfisica t inner join doc_usuario u on u.id=t.USUARIO_ID WHERE t.tipo_examen_id=3 ORDER BY t.cgrado_Cod,u.VPERSONA_APETPAT,u.VPERSONA_APETMAT,u.VPERSONA_NOMBRE,t.NEDAD_NUM ASC");
	    List<Object[]> authors = q.getResultList();		    
	    
	    List<TcfyDet> lista = new ArrayList<TcfyDet>();
	    
		for (Object[] a : authors) {
			TcfyDet item = new TcfyDet(
					Long.valueOf(a[0].toString()).longValue(), 
					a[1].toString(), 
					a[2].toString(), 
					a[3].toString(), 
					a[4].toString(), 
					Long.valueOf(a[5].toString()).longValue(),
					Double.parseDouble(a[6].toString()), 
					Double.parseDouble(a[7].toString()), 
					a[8].toString(), 
					a[9].toString(), 
					a[10].toString(), 
					a[11].toString(), 
					Double.parseDouble(a[12].toString()), 
					Double.parseDouble(a[13].toString()),
					Double.parseDouble(a[14].toString()),
					Double.parseDouble(a[15].toString()),
					Double.parseDouble(a[16].toString()),
					Double.parseDouble(a[17].toString()),
					Double.parseDouble(a[18].toString()),
					Double.parseDouble(a[19].toString()), 
					Double.parseDouble(a[20].toString()),
					Double.parseDouble(a[21].toString()),
					Double.parseDouble(a[22].toString()),
					Double.parseDouble(a[23].toString()),
					Double.parseDouble(a[24].toString()),
					Double.parseDouble(a[25].toString()),
					Double.parseDouble(a[26].toString()),
					Double.parseDouble(a[27].toString()),
					Double.parseDouble(a[28].toString()),
					Double.parseDouble(a[29].toString()),
					a[30].toString(),
					Double.parseDouble(a[31].toString()), 
					Double.parseDouble(a[32].toString()),
					Double.parseDouble(a[33].toString()),
					Double.parseDouble(a[34].toString()),
					Double.parseDouble(a[35].toString()),
					Double.parseDouble(a[36].toString()), 
					Double.parseDouble(a[37].toString()),
					Double.parseDouble(a[38].toString()),
					Double.parseDouble(a[39].toString()),
					Double.parseDouble(a[40].toString()),
					Double.parseDouble(a[41].toString()), 
					Double.parseDouble(a[42].toString()),
					Double.parseDouble(a[43].toString()),
					Double.parseDouble(a[44].toString()), 
					Double.parseDouble(a[45].toString()),
					Double.parseDouble(a[46].toString()),
					Double.parseDouble(a[47].toString()),
					Double.parseDouble(a[48].toString()),
					Double.parseDouble(a[49].toString()),
					Double.parseDouble(a[50].toString()),
					Double.parseDouble(a[51].toString()),
					Double.parseDouble(a[52].toString()),
					Double.parseDouble(a[53].toString()),
					Double.parseDouble(a[54].toString()), 
					Double.parseDouble(a[55].toString()),
					Double.parseDouble(a[56].toString()),
					Double.parseDouble(a[57].toString()),
					Double.parseDouble(a[58].toString()),
					Double.parseDouble(a[59].toString()),
					Double.parseDouble(a[60].toString()), 
					Double.parseDouble(a[61].toString()),
					Double.parseDouble(a[62].toString()),
					Double.parseDouble(a[63].toString()),
					Double.parseDouble(a[64].toString()),
					Double.parseDouble(a[65].toString()),
					Double.parseDouble(a[66].toString()),
					Double.parseDouble(a[67].toString()),
					Double.parseDouble(a[68].toString()),
					Double.parseDouble(a[69].toString()),
					Double.parseDouble(a[70].toString()),
					a[71].toString(), 
					a[72].toString(), 
					Double.parseDouble(a[73].toString()), 
					a[74].toString(), 
					Double.parseDouble(a[75].toString()));
		  lista.add(item);
		    
		}
	    
	    return lista;
	}		
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TcfyDet> ByTcfyDetMMA() {
	    //List<TcfyDet> employees = em.createNamedQuery("getallMilitares", TcfyDet.class).getResultList();
	    Query q = em.createNativeQuery("select  t.id,t.CGRADO_DESCCORT,t.VARMAS_DESCCORT,u.VPERSONA_APETPAT||u.VPERSONA_APETMAT||u.VPERSONA_NOMBRE NOMBRE,t.CPERSONA_SEXO, t.NEDAD_NUM,NVL(t.NPESO_NUM,0.00) NPESO_NUM,NVL(t.NTALLA_NUM,0.00) NTALLA_NUM,u.CASIMILADO_VAL,t.CNUCLEO_COD,t.CGGUU_COD,t.CMILITAR_UUACTUAL, case when (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) is null then -1 else (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end NOTI,case when (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) is null then -1 else (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end PUNI, case when (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3)is null then -1 else (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end REPI ,case when (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end NOTII,case when (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end PUNII, case when (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end REPII ,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end NOTIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end PUNIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end REPIII,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end NOTIV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end PUNIV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end REPIV,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end NOTV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end PUNV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end REPV,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end NOTVI,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end PUNVI, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end REPVI,case when (select NVL(COPT_VAL,' ')  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then ' ' else (select NVL(COPT_VAL,' ')  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end EJEVI_OPT,0 REPVI_MIN,0 REPVI_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end NOTVIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end PUNVIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end REPVIII,0 REPVIII_MIN,0 REPVIII_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end NOTIX,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end PUNIX, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end REPIX,0 REPVIX_MIN,0 REPVIX_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end NOTX,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end PUNX, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end REPX,0 REPX_MIN,0 REPX_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end NOTXI,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end PUNXI, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end REPXI,0 REPXI_MIN,0 REPXI_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end NOTXII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end PUNXII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end REPXII,0 REPXII_MIN,0 REPXII_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end NOTXIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end PUNXIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end REPXIII,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end NOTXIV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end PUNXIV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end REPXIV,0 REPXIV_MIN,0 REPXIV_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end NOTXV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end PUNXV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end REPXV,0 REPXV_MIN,0 REPXV_SEC,NVL(t.COBS_VAL,' ') COBS_VAL,NVL(t.VOBSERV_NOM,' ') VOBSERV_NOM,NVL(t.NPROMEDIO_NUM,0.00) NPROMEDIO_NUM,NVL(t.CRESULTADO_TIPO,' ') CRESULTADO_TIPO,NVL(t.NTOTAL_NUM,0.00) NTOTAL_NUM from doc_testcapacidadfisica t inner join doc_usuario u on u.id=t.USUARIO_ID WHERE t.tipo_examen_id=4 ORDER BY t.cgrado_Cod,u.VPERSONA_APETPAT,u.VPERSONA_APETMAT,u.VPERSONA_NOMBRE,t.NEDAD_NUM ASC");
	    List<Object[]> authors = q.getResultList();		    
	    
	    List<TcfyDet> lista = new ArrayList<TcfyDet>();
	    
		for (Object[] a : authors) {
			TcfyDet item = new TcfyDet(
					Long.valueOf(a[0].toString()).longValue(), 
					a[1].toString(), 
					a[2].toString(), 
					a[3].toString(), 
					a[4].toString(), 
					Long.valueOf(a[5].toString()).longValue(),
					Double.parseDouble(a[6].toString()), 
					Double.parseDouble(a[7].toString()), 
					a[8].toString(), 
					a[9].toString(), 
					a[10].toString(), 
					a[11].toString(), 
					Double.parseDouble(a[12].toString()), 
					Double.parseDouble(a[13].toString()),
					Double.parseDouble(a[14].toString()),
					Double.parseDouble(a[15].toString()),
					Double.parseDouble(a[16].toString()),
					Double.parseDouble(a[17].toString()),
					Double.parseDouble(a[18].toString()),
					Double.parseDouble(a[19].toString()), 
					Double.parseDouble(a[20].toString()),
					Double.parseDouble(a[21].toString()),
					Double.parseDouble(a[22].toString()),
					Double.parseDouble(a[23].toString()),
					Double.parseDouble(a[24].toString()),
					Double.parseDouble(a[25].toString()),
					Double.parseDouble(a[26].toString()),
					Double.parseDouble(a[27].toString()),
					Double.parseDouble(a[28].toString()),
					Double.parseDouble(a[29].toString()),
					a[30].toString(),
					Double.parseDouble(a[31].toString()), 
					Double.parseDouble(a[32].toString()),
					Double.parseDouble(a[33].toString()),
					Double.parseDouble(a[34].toString()),
					Double.parseDouble(a[35].toString()),
					Double.parseDouble(a[36].toString()), 
					Double.parseDouble(a[37].toString()),
					Double.parseDouble(a[38].toString()),
					Double.parseDouble(a[39].toString()),
					Double.parseDouble(a[40].toString()),
					Double.parseDouble(a[41].toString()), 
					Double.parseDouble(a[42].toString()),
					Double.parseDouble(a[43].toString()),
					Double.parseDouble(a[44].toString()), 
					Double.parseDouble(a[45].toString()),
					Double.parseDouble(a[46].toString()),
					Double.parseDouble(a[47].toString()),
					Double.parseDouble(a[48].toString()),
					Double.parseDouble(a[49].toString()),
					Double.parseDouble(a[50].toString()),
					Double.parseDouble(a[51].toString()),
					Double.parseDouble(a[52].toString()),
					Double.parseDouble(a[53].toString()),
					Double.parseDouble(a[54].toString()), 
					Double.parseDouble(a[55].toString()),
					Double.parseDouble(a[56].toString()),
					Double.parseDouble(a[57].toString()),
					Double.parseDouble(a[58].toString()),
					Double.parseDouble(a[59].toString()),
					Double.parseDouble(a[60].toString()), 
					Double.parseDouble(a[61].toString()),
					Double.parseDouble(a[62].toString()),
					Double.parseDouble(a[63].toString()),
					Double.parseDouble(a[64].toString()),
					Double.parseDouble(a[65].toString()),
					Double.parseDouble(a[66].toString()),
					Double.parseDouble(a[67].toString()),
					Double.parseDouble(a[68].toString()),
					Double.parseDouble(a[69].toString()),
					Double.parseDouble(a[70].toString()),
					a[71].toString(), 
					a[72].toString(), 
					Double.parseDouble(a[73].toString()), 
					a[74].toString(), 
					Double.parseDouble(a[75].toString()));
		  lista.add(item);
		    
		}
	    
	    return lista;
	}		
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TcfyDet> ByTcfyDetFE() {
	    //List<TcfyDet> employees = em.createNamedQuery("getallMilitares", TcfyDet.class).getResultList();
	    Query q = em.createNativeQuery("select  t.id,t.CGRADO_DESCCORT,t.VARMAS_DESCCORT,u.VPERSONA_APETPAT||u.VPERSONA_APETMAT||u.VPERSONA_NOMBRE NOMBRE,t.CPERSONA_SEXO, t.NEDAD_NUM,NVL(t.NPESO_NUM,0.00) NPESO_NUM,NVL(t.NTALLA_NUM,0.00) NTALLA_NUM,u.CASIMILADO_VAL,t.CNUCLEO_COD,t.CGGUU_COD,t.CMILITAR_UUACTUAL, case when (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) is null then -1 else (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end NOTI,case when (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) is null then -1 else (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end PUNI, case when (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3)is null then -1 else (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end REPI ,case when (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end NOTII,case when (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end PUNII, case when (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end REPII ,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end NOTIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end PUNIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end REPIII,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end NOTIV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end PUNIV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end REPIV,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end NOTV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end PUNV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end REPV,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end NOTVI,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end PUNVI, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end REPVI,case when (select NVL(COPT_VAL,' ')  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then ' ' else (select NVL(COPT_VAL,' ')  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end EJEVI_OPT,0 REPVI_MIN,0 REPVI_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end NOTVIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end PUNVIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end REPVIII,0 REPVIII_MIN,0 REPVIII_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end NOTIX,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end PUNIX, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end REPIX,0 REPVIX_MIN,0 REPVIX_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end NOTX,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end PUNX, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end REPX,0 REPX_MIN,0 REPX_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end NOTXI,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end PUNXI, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end REPXI,0 REPXI_MIN,0 REPXI_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end NOTXII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end PUNXII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end REPXII,0 REPXII_MIN,0 REPXII_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end NOTXIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end PUNXIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end REPXIII,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end NOTXIV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end PUNXIV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end REPXIV,0 REPXIV_MIN,0 REPXIV_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end NOTXV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end PUNXV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end REPXV,0 REPXV_MIN,0 REPXV_SEC,NVL(t.COBS_VAL,' ') COBS_VAL,NVL(t.VOBSERV_NOM,' ') VOBSERV_NOM,NVL(t.NPROMEDIO_NUM,0.00) NPROMEDIO_NUM,NVL(t.CRESULTADO_TIPO,' ') CRESULTADO_TIPO,NVL(t.NTOTAL_NUM,0.00) NTOTAL_NUM from doc_testcapacidadfisica t inner join doc_usuario u on u.id=t.USUARIO_ID WHERE t.tipo_examen_id=5 ORDER BY t.cgrado_Cod,u.VPERSONA_APETPAT,u.VPERSONA_APETMAT,u.VPERSONA_NOMBRE,t.NEDAD_NUM ASC");
	    List<Object[]> authors = q.getResultList();		    
	    
	    List<TcfyDet> lista = new ArrayList<TcfyDet>();	    
		for (Object[] a : authors) {
			TcfyDet item = new TcfyDet(
					Long.valueOf(a[0].toString()).longValue(), 
					a[1].toString(), 
					a[2].toString(), 
					a[3].toString(), 
					a[4].toString(), 
					Long.valueOf(a[5].toString()).longValue(),
					Double.parseDouble(a[6].toString()), 
					Double.parseDouble(a[7].toString()), 
					a[8].toString(), 
					a[9].toString(), 
					a[10].toString(), 
					a[11].toString(), 
					Double.parseDouble(a[12].toString()), 
					Double.parseDouble(a[13].toString()),
					Double.parseDouble(a[14].toString()),
					Double.parseDouble(a[15].toString()),
					Double.parseDouble(a[16].toString()),
					Double.parseDouble(a[17].toString()),
					Double.parseDouble(a[18].toString()),
					Double.parseDouble(a[19].toString()), 
					Double.parseDouble(a[20].toString()),
					Double.parseDouble(a[21].toString()),
					Double.parseDouble(a[22].toString()),
					Double.parseDouble(a[23].toString()),
					Double.parseDouble(a[24].toString()),
					Double.parseDouble(a[25].toString()),
					Double.parseDouble(a[26].toString()),
					Double.parseDouble(a[27].toString()),
					Double.parseDouble(a[28].toString()),
					Double.parseDouble(a[29].toString()),
					a[30].toString(),
					Double.parseDouble(a[31].toString()), 
					Double.parseDouble(a[32].toString()),
					Double.parseDouble(a[33].toString()),
					Double.parseDouble(a[34].toString()),
					Double.parseDouble(a[35].toString()),
					Double.parseDouble(a[36].toString()), 
					Double.parseDouble(a[37].toString()),
					Double.parseDouble(a[38].toString()),
					Double.parseDouble(a[39].toString()),
					Double.parseDouble(a[40].toString()),
					Double.parseDouble(a[41].toString()), 
					Double.parseDouble(a[42].toString()),
					Double.parseDouble(a[43].toString()),
					Double.parseDouble(a[44].toString()), 
					Double.parseDouble(a[45].toString()),
					Double.parseDouble(a[46].toString()),
					Double.parseDouble(a[47].toString()),
					Double.parseDouble(a[48].toString()),
					Double.parseDouble(a[49].toString()),
					Double.parseDouble(a[50].toString()),
					Double.parseDouble(a[51].toString()),
					Double.parseDouble(a[52].toString()),
					Double.parseDouble(a[53].toString()),
					Double.parseDouble(a[54].toString()), 
					Double.parseDouble(a[55].toString()),
					Double.parseDouble(a[56].toString()),
					Double.parseDouble(a[57].toString()),
					Double.parseDouble(a[58].toString()),
					Double.parseDouble(a[59].toString()),
					Double.parseDouble(a[60].toString()), 
					Double.parseDouble(a[61].toString()),
					Double.parseDouble(a[62].toString()),
					Double.parseDouble(a[63].toString()),
					Double.parseDouble(a[64].toString()),
					Double.parseDouble(a[65].toString()),
					Double.parseDouble(a[66].toString()),
					Double.parseDouble(a[67].toString()),
					Double.parseDouble(a[68].toString()),
					Double.parseDouble(a[69].toString()),
					Double.parseDouble(a[70].toString()),
					a[71].toString(), 
					a[72].toString(), 
					Double.parseDouble(a[73].toString()), 
					a[74].toString(), 
					Double.parseDouble(a[75].toString()));
		  lista.add(item);
		    
		}
	    
	    return lista;
	}



	@Override
	public List<Unidad> ByUnidad(String codigo) {

		return(List<Unidad>)  usuarioDao.ByUnidad(codigo);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<TcfyDet> ByTcfyDetMM(String codPeriodo, String codUnidad, Long tipoExamen) {
		Query q = em.createNativeQuery("select  t.id,t.CGRADO_DESCCORT,t.VARMAS_DESCCORT,u.VPERSONA_APETPAT||u.VPERSONA_APETMAT||u.VPERSONA_NOMBRE NOMBRE,t.CPERSONA_SEXO, t.NEDAD_NUM,NVL(t.NPESO_NUM,0.00) NPESO_NUM,NVL(t.NTALLA_NUM,0.00) NTALLA_NUM,u.CASIMILADO_VAL,t.CNUCLEO_COD,t.CGGUU_COD,t.CMILITAR_UUACTUAL, case when (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) is null then -1 else (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end NOTI,case when (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) is null then -1 else (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end PUNI, case when (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3)is null then -1 else (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=3) end REPI ,case when (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select nnotas_num  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end NOTII,case when (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select npuntos_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end PUNII, case when (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) is null then -1 else (select nrepet_num   from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=12) end REPII ,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end NOTIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end PUNIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=14) end REPIII,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end NOTIV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end PUNIV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=13) end REPIV,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end NOTV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end PUNV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=1) end REPV,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end NOTVI,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end PUNVI, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end REPVI,case when (select NVL(COPT_VAL,' ')  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) is null then ' ' else (select NVL(COPT_VAL,' ')  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=4) end EJEVI_OPT,0 REPVI_MIN,0 REPVI_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end NOTVIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end PUNVIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=11) end REPVIII,0 REPVIII_MIN,0 REPVIII_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end NOTIX,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end PUNIX, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=9) end REPIX,0 REPVIX_MIN,0 REPVIX_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end NOTX,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end PUNX, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=8) end REPX,0 REPX_MIN,0 REPX_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end NOTXI,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end PUNXI, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=2) end REPXI,0 REPXI_MIN,0 REPXI_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end NOTXII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end PUNXII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=5) end REPXII,0 REPXII_MIN,0 REPXII_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end NOTXIII,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end PUNXIII, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=6) end REPXIII,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end NOTXIV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end PUNXIV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=10) end REPXIV,0 REPXIV_MIN,0 REPXIV_SEC,case when (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(nnotas_num,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end NOTXV,case when (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(npuntos_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end PUNXV, case when (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) is null then -1 else (select NVL(nrepet_num ,0)  from doc_testcapacidadfisicadetalle td  where t.id=td.tcf_id and td.examen_id=7) end REPXV,0 REPXV_MIN,0 REPXV_SEC,NVL(t.COBS_VAL,' ') COBS_VAL,NVL(t.VOBSERV_NOM,' ') VOBSERV_NOM,NVL(t.NPROMEDIO_NUM,0.00) NPROMEDIO_NUM,NVL(t.CRESULTADO_TIPO,' ') CRESULTADO_TIPO,NVL(t.NTOTAL_NUM,0.00) NTOTAL_NUM from doc_testcapacidadfisica t inner join doc_usuario u on u.id=t.USUARIO_ID WHERE cperiodo_cod=?1 and CMILITAR_UUACTUAL=?2 AND TIPO_EXAMEN_ID=?3 ORDER BY t.cgrado_Cod,u.VPERSONA_APETPAT,u.VPERSONA_APETMAT,u.VPERSONA_NOMBRE,t.NEDAD_NUM ASC");
		q.setParameter(1,codPeriodo);
		q.setParameter(2,codUnidad);
		q.setParameter(3,tipoExamen);
	    List<Object[]> authors = q.getResultList();		    
	    
	    List<TcfyDet> lista = new ArrayList<TcfyDet>();
	    
		for (Object[] a : authors) {
			TcfyDet item = new TcfyDet(
					Long.valueOf(a[0].toString()).longValue(), 
					a[1].toString(), 
					a[2].toString(), 
					a[3].toString(), 
					a[4].toString(), 
					Long.valueOf(a[5].toString()).longValue(),
					Double.parseDouble(a[6].toString()), 
					Double.parseDouble(a[7].toString()), 
					a[8].toString(), 
					a[9].toString(), 
					a[10].toString(), 
					a[11].toString(), 
					Double.parseDouble(a[12].toString()), 
					Double.parseDouble(a[13].toString()),
					Double.parseDouble(a[14].toString()),
					Double.parseDouble(a[15].toString()),
					Double.parseDouble(a[16].toString()),
					Double.parseDouble(a[17].toString()),
					Double.parseDouble(a[18].toString()),
					Double.parseDouble(a[19].toString()), 
					Double.parseDouble(a[20].toString()),
					Double.parseDouble(a[21].toString()),
					Double.parseDouble(a[22].toString()),
					Double.parseDouble(a[23].toString()),
					Double.parseDouble(a[24].toString()),
					Double.parseDouble(a[25].toString()),
					Double.parseDouble(a[26].toString()),
					Double.parseDouble(a[27].toString()),
					Double.parseDouble(a[28].toString()),
					Double.parseDouble(a[29].toString()),
					a[30].toString(),
					Double.parseDouble(a[31].toString()), 
					Double.parseDouble(a[32].toString()),
					Double.parseDouble(a[33].toString()),
					Double.parseDouble(a[34].toString()),
					Double.parseDouble(a[35].toString()),
					Double.parseDouble(a[36].toString()), 
					Double.parseDouble(a[37].toString()),
					Double.parseDouble(a[38].toString()),
					Double.parseDouble(a[39].toString()),
					Double.parseDouble(a[40].toString()),
					Double.parseDouble(a[41].toString()), 
					Double.parseDouble(a[42].toString()),
					Double.parseDouble(a[43].toString()),
					Double.parseDouble(a[44].toString()), 
					Double.parseDouble(a[45].toString()),
					Double.parseDouble(a[46].toString()),
					Double.parseDouble(a[47].toString()),
					Double.parseDouble(a[48].toString()),
					Double.parseDouble(a[49].toString()),
					Double.parseDouble(a[50].toString()),
					Double.parseDouble(a[51].toString()),
					Double.parseDouble(a[52].toString()),
					Double.parseDouble(a[53].toString()),
					Double.parseDouble(a[54].toString()), 
					Double.parseDouble(a[55].toString()),
					Double.parseDouble(a[56].toString()),
					Double.parseDouble(a[57].toString()),
					Double.parseDouble(a[58].toString()),
					Double.parseDouble(a[59].toString()),
					Double.parseDouble(a[60].toString()), 
					Double.parseDouble(a[61].toString()),
					Double.parseDouble(a[62].toString()),
					Double.parseDouble(a[63].toString()),
					Double.parseDouble(a[64].toString()),
					Double.parseDouble(a[65].toString()),
					Double.parseDouble(a[66].toString()),
					Double.parseDouble(a[67].toString()),
					Double.parseDouble(a[68].toString()),
					Double.parseDouble(a[69].toString()),
					Double.parseDouble(a[70].toString()),
					a[71].toString(), 
					a[72].toString(), 
					Double.parseDouble(a[73].toString()), 
					a[74].toString(), 
					Double.parseDouble(a[75].toString()));
		  lista.add(item);
		    
		}
	    
	    return lista;
	}				
	
}
