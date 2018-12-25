package com.jeduce.stcf.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "DOC_EXAMEN")
public class Examen implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_exa")
	@SequenceGenerator(name = "id_exa", sequenceName = "ID_EXA",initialValue = 28, allocationSize = 1)
	private Long id;	
	
	@Column(name = "NORDEN_NUM")	
	private Long nordenNum;	
	
	@NotNull
	@Column(name = "NCOEF_NUM")
	private Long ncoefNum;
	
	
	@NotEmpty
	@NotNull
	@Column(name = "CESTADO_VAL")		
	private String cestadoVal;
	
	
	@Column(name = "NUSU_REG")
	private Long nusuReg;
	
	
	@Column(name = "NUSU_MOD")
	private Long nusuMod;
	

	@Column(name = "DREG_FEC")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")	
	private Date dregFec;
	
	
	@Column(name = "DMOD_FEC")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")	
	private Date dmodFec;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn
	private TipoExamen tipoExamen;
	

	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn
	private Prueba prueba;
	

	
	
	
	
	public Long getNordenNum() {
		return nordenNum;
	}




	public void setNordenNum(Long nordenNum) {
		this.nordenNum = nordenNum;
	}




	public TipoExamen getTipoExamen() {
		return tipoExamen;
	}




	public void setTipoExamen(TipoExamen tipoExamen) {
		this.tipoExamen = tipoExamen;
	}




	public Prueba getPrueba() {
		return prueba;
	}




	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}












	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}








	public Long getNcoefNum() {
		return ncoefNum;
	}




	public void setNcoefNum(Long ncoefNum) {
		this.ncoefNum = ncoefNum;
	}




	public String getCestadoVal() {
		return cestadoVal;
	}




	public void setCestadoVal(String cestadoVal) {
		this.cestadoVal = cestadoVal;
	}




	public Long getNusuReg() {
		return nusuReg;
	}




	public void setNusuReg(Long nusuReg) {
		this.nusuReg = nusuReg;
	}




	public Long getNusuMod() {
		return nusuMod;
	}




	public void setNusuMod(Long nusuMod) {
		this.nusuMod = nusuMod;
	}




	public Date getDregFec() {
		return dregFec;
	}




	public void setDregFec(Date dregFec) {
		this.dregFec = dregFec;
	}




	public Date getDmodFec() {
		return dmodFec;
	}




	public void setDmodFec(Date dmodFec) {
		this.dmodFec = dmodFec;
	}









	private static final long serialVersionUID = 1L;
	
}
