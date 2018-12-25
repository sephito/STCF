package com.jeduce.stcf.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DOC_USUARIO")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_usu")
	@SequenceGenerator(name = "id_usu", sequenceName = "ID_USU")
	private Long id;

	@NotEmpty
	@NotNull
	@Column(name = "VPERSONA_APETPAT")
	private String vpersonaApetpat;

	@NotEmpty
	@NotNull
	@Column(name = "VPERSONA_APETMAT")
	private String vpersonaApetmat;

	@NotEmpty
	@NotNull
	@Column(name = "VPERSONA_NOMBRE")
	private String vpersonaNomre;

	@NotEmpty
	@NotNull
	@Column(name = "VUSUARIO_NOM", length = 30, unique = true)
	private String vusuarioNom;

	@NotEmpty
	@NotNull
	@Column(name = "VPASSWORD_COD", length = 60)
	private String vpasswordCod;

	private Boolean enabled;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Role> roles;

	@Column(name = "CASIMILADO_VAL")
	private String casimiladoVal;	
	
	@NotEmpty
	@NotNull
	@Column(name = "CESTADO_VAL")
	private String cestadoVal;

	@Column(name = "CUSU_REG")
	private String cusuReg;

	@Column(name = "CUSU_MOD")
	private String cusuMod;

	@Column(name = "DREG_FEC")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dregFec;

	@Column(name = "DMOD_FEC")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dmodFec;

	@Column(name = "CPERSONA_NRODOC")
	private String cpersonaNroDoc;

	@Column(name = "CDOCIDENTIDAD_COD")
	private String cdocidentidadCod;

	public String getVpersonaApetpat() {
		return vpersonaApetpat;
	}

	public void setVpersonaApetpat(String vpersonaApetpat) {
		this.vpersonaApetpat = vpersonaApetpat;
	}

	public String getVpersonaApetmat() {
		return vpersonaApetmat;
	}

	public void setVpersonaApetmat(String vpersonaApetmat) {
		this.vpersonaApetmat = vpersonaApetmat;
	}

	public String getVpersonaNomre() {
		return vpersonaNomre;
	}

	public void setVpersonaNomre(String vpersonaNomre) {
		this.vpersonaNomre = vpersonaNomre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVusuarioNom() {
		return vusuarioNom;
	}

	public void setVusuarioNom(String vusuarioNom) {
		this.vusuarioNom = vusuarioNom;
	}

	public String getVpasswordCod() {
		return vpasswordCod;
	}

	public void setVpasswordCod(String vpasswordCod) {
		this.vpasswordCod = vpasswordCod;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getCestadoVal() {
		return cestadoVal;
	}

	public void setCestadoVal(String cestadoVal) {
		this.cestadoVal = cestadoVal;
	}

	public String getCusuReg() {
		return cusuReg;
	}

	public void setCusuReg(String cusuReg) {
		this.cusuReg = cusuReg;
	}

	public String getCusuMod() {
		return cusuMod;
	}

	public void setCusuMod(String cusuMod) {
		this.cusuMod = cusuMod;
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

	public String getCpersonaNroDoc() {
		return cpersonaNroDoc;
	}

	public void setCpersonaNroDoc(String cpersonaNroDoc) {
		this.cpersonaNroDoc = cpersonaNroDoc;
	}

	public String getCdocidentidadCod() {
		return cdocidentidadCod;
	}

	public void setCdocidentidadCod(String cdocidentidadCod) {
		this.cdocidentidadCod = cdocidentidadCod;
	}	
	
	public String getCasimiladoVal() {
		return casimiladoVal;
	}

	public void setCasimiladoVal(String casimiladoVal) {
		this.casimiladoVal = casimiladoVal;
	}

	@PrePersist
	public void prePersiste() {
		dregFec = new Date();
	}

	private static final long serialVersionUID = 1L;

}
