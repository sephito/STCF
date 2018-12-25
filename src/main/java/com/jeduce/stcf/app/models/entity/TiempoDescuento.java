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
@Table(name = "DOC_TEMPODESCUENTO")
public class TiempoDescuento implements Serializable {

	@Id
	@NotNull
	@Column(name = "CUBIGEO_COD")		
	private String cubigeoCod;	
	
	
	
	public String getCubigeoCod() {
		return cubigeoCod;
	}



	public void setCubigeoCod(String cubigeoCod) {
		this.cubigeoCod = cubigeoCod;
	}



	@NotNull
	@Column(name = "NTEMPOSEG_CNT")		
	private Long ntiemposegCnt;
	
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
	
	
	


	


	public Long getNtiemposegCnt() {
		return ntiemposegCnt;
	}



	public void setNtiemposegCnt(Long ntiemposegCnt) {
		this.ntiemposegCnt = ntiemposegCnt;
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
