package com.jeduce.stcf.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DOC_PRUEBA")
public class Prueba implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_prueba")
	@SequenceGenerator(name = "id_prueba", sequenceName = "ID_PRUEBA",initialValue = 15, allocationSize = 1)
	private Long id;	
	
	@NotEmpty
	@NotNull
	@Column(name = "VNOMBRE_COM")	
	private String vnombreCom;
	
	@NotEmpty
	@NotNull
	@Column(name = "VNOMBRE_ABRV")	
	private String vnombreAbr;	
		
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
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getVnombreCom() {
		return vnombreCom;
	}



	public void setVnombreCom(String vnombreCom) {
		this.vnombreCom = vnombreCom;
	}



	public String getVnombreAbr() {
		return vnombreAbr;
	}



	public void setVnombreAbr(String vnombreAbr) {
		this.vnombreAbr = vnombreAbr;
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
