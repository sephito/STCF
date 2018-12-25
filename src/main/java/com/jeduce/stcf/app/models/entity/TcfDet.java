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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DOC_TESTCAPACIDADFISICADETALLE")
public class TcfDet implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_tcfdet")
	@SequenceGenerator(name = "id_tcfdet", sequenceName = "ID_TCFDET")
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Tcf tcf;

	@Column(name = "NNOTAS_NUM")
	private Double nnotasNum=0.00;

	@Column(name = "NPUNTOS_NUM")
	private Double npuntosNum=0.00;

	@Column(name = "NREPET_NUM")
	private Double nrepetNum= -1.00;

	
	@Column(name = "COPT_VAL")
	private String coptVal;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Examen examen;
	


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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dregFec;

	@Column(name = "DMOD_FEC")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dmodFec;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getNnotasNum() {
		return nnotasNum;
	}

	public void setNnotasNum(Double nnotasNum) {
		this.nnotasNum = nnotasNum;
	}

	public Double getNpuntosNum() {
		return npuntosNum;
	}

	public void setNpuntosNum(Double npuntosNum) {
		this.npuntosNum = npuntosNum;
	}

	public Double getNrepetNum() {
		return nrepetNum;
	}

	public void setNrepetNum(Double nrepetNum) {
		this.nrepetNum = nrepetNum;
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

	
	
	public Tcf getTcf() {
		return tcf;
	}

	public void setTcf(Tcf tcf) {
		this.tcf = tcf;
	}





	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}





	public String getCoptVal() {
		return coptVal;
	}

	public void setCoptVal(String coptVal) {
		this.coptVal = coptVal;
	}





	private static final long serialVersionUID = 1L;

}
