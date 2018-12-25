package com.jeduce.stcf.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DOC_TIPOEXAMEN")
public class TipoExamen implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_tipexa")
	@SequenceGenerator(name = "id_tipexa", sequenceName = "ID_TIPEXA",initialValue = 6, allocationSize = 1)
	private Long id;
	
	@NotEmpty
	@NotNull
	@Column(name = "VNOMBRE_COM")	
	private String vnombreCom;
	
	@NotEmpty
	@NotNull
	@Column(name = "VNOMBRE_ABRV")	
	private String vnombreAbr;	
		
	
	@Column(name = "VDSC")	
	private String vdsc;
	
	
	@NotEmpty
	@NotNull
	@Column(name = "CESTADO_VAL")		
	private String cestadoVal;
	
	
	@Column(name = "NUSU_REG")
	private String nusuReg;
	
	
	@Column(name = "NUSU_MOD")
	private String nusuMod;
	

	@Column(name = "DREG_FEC")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")	
	private Date dregFec;
	
	
	@Column(name = "DMOD_FEC")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")	
	private Date dmodFec;


	@PrePersist
	public void prePersiste() {
		dregFec = new Date();
	}		
	
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




	public String getNusuReg() {
		return nusuReg;
	}


	public void setNusuReg(String nusuReg) {
		this.nusuReg = nusuReg;
	}


	public String getNusuMod() {
		return nusuMod;
	}


	public void setNusuMod(String nusuMod) {
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
	
	
	
	public String getVdsc() {
		return vdsc;
	}


	public void setVdsc(String vdsc) {
		this.vdsc = vdsc;
	}



	private static final long serialVersionUID = 1L;
}
