package com.jeduce.stcf.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "DOC_TESTCAPACIDADFISICA")
public class Tcf implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_tcf")
	@SequenceGenerator(name = "id_tcf", sequenceName = "ID_TCF")
	private Long id;

	@NotEmpty
	@NotNull
	@Column(name = "CPERIODO_COD")
	private String cperiodoCod;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private TipoExamen tipoExamen;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Usuario usuario;

	@NotEmpty
	@NotNull
	@Column(name = "CGRADO_COD")
	private String cgradoCod;

	@NotEmpty
	@NotNull
	@Column(name = "CGRADO_DESCCORT")
	private String cgradoDesccort;

	@NotEmpty
	@NotNull
	@Column(name = "CARMA_COD")
	private String carmaCod;

	@NotEmpty
	@NotNull
	@Column(name = "VARMAS_DESCCORT")
	private String varmasDesccort;

	@NotEmpty
	@NotNull
	@Column(name = "CPERSONA_SEXO")
	private String cpersonaSexo;

	@Column(name = "NEDAD_NUM")
	private Long nedadNum;

	@Column(name = "NTALLA_NUM")
	private Double ntallaNum;

	@Column(name = "NPESO_NUM")
	private Double npesoNum;

	@Column(name = "NPROMEDIO_NUM")
	private Double npromedioNum;

	@Column(name = "NTOTAL_NUM")
	private Double ntotalNum;

	@Column(name = "CRESULTADO_TIPO", columnDefinition = "char(1)")
	private String cresultadoTipo;

	@Column(name = "COBS_VAL", columnDefinition = "char(1)")
	private String cobsVal;

	@Column(name = "VOBSERV_NOM", length = 255)
	private String vobservNom;

	@Column(name = "CSOLICI_VAL")
	private String csoliciVal;

	@NotEmpty
	@NotNull
	@Column(name = "CMILITAR_UUACTUAL")
	private String cmilitarUuactual;

	@NotEmpty
	@NotNull
	@Column(name = "VUNIDAD_DESCOR")
	private String vunidadDescor;

	@NotEmpty
	@NotNull
	@Column(name = "CGGUU_COD")
	private String cgguuCod;

	@NotEmpty
	@NotNull
	@Column(name = "VGGUU_DESLAR")
	private String vgguuDeslar;

	@NotEmpty
	@NotNull
	@Column(name = "CNUCLEO_COD")
	private String cnucleoCod;

	@NotEmpty
	@NotNull
	@Column(name = "VNUCLEO_DESLAR")
	private String vnucleoDeslar;

	@NotEmpty
	@NotNull
	@Column(name = "CUBIGEO_COD")
	private String cubigeoCod;

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

	public String getCperiodoCod() {
		return cperiodoCod;
	}

	public void setCperiodoCod(String cperiodoCod) {
		this.cperiodoCod = cperiodoCod;
	}

	public TipoExamen getTipoExamen() {
		return tipoExamen;
	}

	public void setTipoExamen(TipoExamen tipoExamen) {
		this.tipoExamen = tipoExamen;
	}

	public String getCgradoCod() {
		return cgradoCod;
	}

	public void setCgradoCod(String cgradoCod) {
		this.cgradoCod = cgradoCod;
	}

	public String getCgradoDesccort() {
		return cgradoDesccort;
	}

	public void setCgradoDesccort(String cgradoDesccort) {
		this.cgradoDesccort = cgradoDesccort;
	}

	public String getCarmaCod() {
		return carmaCod;
	}

	public void setCarmaCod(String carmaCod) {
		this.carmaCod = carmaCod;
	}

	public String getVarmasDesccort() {
		return varmasDesccort;
	}

	public void setVarmasDesccort(String varmasDesccort) {
		this.varmasDesccort = varmasDesccort;
	}

	public String getCpersonaSexo() {
		return cpersonaSexo;
	}

	public void setCpersonaSexo(String cpersonaSexo) {
		this.cpersonaSexo = cpersonaSexo;
	}

	public Long getNedadNum() {
		return nedadNum;
	}

	public void setNedadNum(Long nedadNum) {
		this.nedadNum = nedadNum;
	}

	public Double getNtallaNum() {
		return ntallaNum;
	}

	public void setNtallaNum(Double ntallaNum) {
		this.ntallaNum = ntallaNum;
	}

	public Double getNpesoNum() {
		return npesoNum;
	}

	public void setNpesoNum(Double npesoNum) {
		this.npesoNum = npesoNum;
	}

	public Double getNpromedioNum() {
		return npromedioNum;
	}

	public void setNpromedioNum(Double npromedioNum) {
		this.npromedioNum = npromedioNum;
	}

	public Double getNtotalNum() {
		return ntotalNum;
	}

	public void setNtotalNum(Double ntotalNum) {
		this.ntotalNum = ntotalNum;
	}

	public String getCresultadoTipo() {
		return cresultadoTipo;
	}

	public void setCresultadoTipo(String cresultadoTipo) {
		this.cresultadoTipo = cresultadoTipo;
	}

	public String getCobsVal() {
		return cobsVal;
	}

	public void setCobsVal(String cobsVal) {
		this.cobsVal = cobsVal;
	}

	public String getVobservNom() {
		return vobservNom;
	}

	public void setVobservNom(String vobservNom) {
		this.vobservNom = vobservNom;
	}

	public String getCsoliciVal() {
		return csoliciVal;
	}

	public void setCsoliciVal(String csoliciVal) {
		this.csoliciVal = csoliciVal;
	}

	public String getCmilitarUuactual() {
		return cmilitarUuactual;
	}

	public void setCmilitarUuactual(String cmilitarUuactual) {
		this.cmilitarUuactual = cmilitarUuactual;
	}

	public String getVunidadDescor() {
		return vunidadDescor;
	}

	public void setVunidadDescor(String vunidadDescor) {
		this.vunidadDescor = vunidadDescor;
	}

	public String getCgguuCod() {
		return cgguuCod;
	}

	public void setCgguuCod(String cgguuCod) {
		this.cgguuCod = cgguuCod;
	}

	public String getVgguuDeslar() {
		return vgguuDeslar;
	}

	public void setVgguuDeslar(String vgguuDeslar) {
		this.vgguuDeslar = vgguuDeslar;
	}

	public String getCnucleoCod() {
		return cnucleoCod;
	}

	public void setCnucleoCod(String cnucleoCod) {
		this.cnucleoCod = cnucleoCod;
	}

	public String getVnucleoDeslar() {
		return vnucleoDeslar;
	}

	public void setVnucleoDeslar(String vnucleoDeslar) {
		this.vnucleoDeslar = vnucleoDeslar;
	}

	public String getCubigeoCod() {
		return cubigeoCod;
	}

	public void setCubigeoCod(String cubigeoCod) {
		this.cubigeoCod = cubigeoCod;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private static final long serialVersionUID = 1L;

}
