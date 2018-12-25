package com.jeduce.stcf.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DOC_PERIODO")
public class Periodo implements Serializable {

	
	@Id
	@NotEmpty
	@NotNull
	@Column(name = "CPERIODO_COD")	
	private String cperiodoCod;
	
	@NotEmpty
	@NotNull
	@Column(name = "VTITULO_NOM")	
	private String vtituloNom;
	
	@NotEmpty
	@NotNull
	@Column(name = "CANIO_COD")	
	private String canioCod;
	
	@NotEmpty
	@NotNull
	@Column(name = "CMES_COD")	
	private String cmesCod;	
	
	@Column(name = "DCIERRE_FEC")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")	
	private Date dcierreFec;	

	@NotEmpty
	@NotNull
	@Column(name = "CAPTITUD_VAL")	
	private String captitudVal;	

	@NotEmpty
	@NotNull
	@Column(name = "CEVA_TIPO")	
	private String cevaTipo;	
	

	
	@Column(name = "CRELACION_COD")	
	private String crelacionCod;	
	
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

	


	public String getCperiodoCod() {
		return cperiodoCod;
	}



	public void setCperiodoCod(String cperiodoCod) {
		this.cperiodoCod = cperiodoCod;
	}



	public String getVtituloNom() {
		return vtituloNom;
	}



	public void setVtituloNom(String vtituloNom) {
		this.vtituloNom = vtituloNom;
	}



	public String getCanioCod() {
		return canioCod;
	}



	public void setCanioCod(String canioCod) {
		this.canioCod = canioCod;
	}



	public String getCmesCod() {
		return cmesCod;
	}



	public void setCmesCod(String cmesCod) {
		this.cmesCod = cmesCod;
	}



	public Date getDcierreFec() {
		return dcierreFec;
	}



	public void setDcierreFec(Date dcierreFec) {
		this.dcierreFec = dcierreFec;
	}



	public String getCaptitudVal() {
		return captitudVal;
	}



	public void setCaptitudVal(String captitudVal) {
		this.captitudVal = captitudVal;
	}



	public String getCevaTipo() {
		return cevaTipo;
	}



	public void setCevaTipo(String cevaTipo) {
		this.cevaTipo = cevaTipo;
	}



	public String getCrelacionCod() {
		return crelacionCod;
	}



	public void setCrelacionCod(String crelacionCOD) {
		this.crelacionCod = crelacionCOD;
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
