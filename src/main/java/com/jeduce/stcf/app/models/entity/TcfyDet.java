package com.jeduce.stcf.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;



public class TcfyDet implements Serializable {		
	
	private Long key;		
	private String grado;
	private String arma;	
	private String nombre;
	private String sexo;
	private Long edad;		
	private Double peso;	
	private Double talla;
	private String procedencia;
	private String brigada;
	private String division;	
	private String unidad;
	
	
	private Double ejercicioi_not;
	private Double ejercicioi_ptos;
	private Double ejercicioi_rep;

	private Double ejercicioii_not;
	private Double ejercicioii_ptos;
	private Double ejercicioii_rep;

	private Double ejercicioiii_not;
	private Double ejercicioiii_ptos;
	private Double ejercicioiii_rep;

	private Double ejercicioiv_not;
	private Double ejercicioiv_ptos;
	private Double ejercicioiv_rep;

	private Double ejerciciov_not;
	private Double ejerciciov_ptos;
	private Double ejerciciov_rep;

	private Double ejerciciovi_not;
	private Double ejerciciovi_ptos;
	private Double ejerciciovi_rep;
	private String optvii;
	private Double ejerciciovi_rep_min;
	private Double ejerciciovi_rep_sec;
	
	
	

	private Double ejercicioviii_not;
	private Double ejercicioviii_ptos;
	private Double ejercicioviii_rep;
	private Double ejercicioviii_rep_min;
	private Double ejercicioviii_rep_sec;
	

	private Double ejercicioix_not;
	private Double ejercicioix_ptos;
	private Double ejercicioix_rep;
	private Double ejercicioix_rep_min;
	private Double ejercicioix_rep_sec;	

	private Double ejerciciox_not;
	private Double ejerciciox_ptos;
	private Double ejerciciox_rep;
	private Double ejerciciox_rep_min;
	private Double ejerciciox_rep_sec;



	private Double ejercicioexi_not;
	private Double ejercicioexi_ptos;
	private Double ejercicioexi_rep;
	private Double ejercicioexi_rep_min;
	private Double ejercicioexi_rep_sec;	
	
	private Double ejercicioexii_not;
	private Double ejercicioexii_ptos;
	private Double ejercicioexii_rep;
	private Double ejercicioexii_rep_min;
	private Double ejercicioexii_rep_sec;	

	private Double ejercicioexiii_not;
	private Double ejercicioexiii_ptos;
	private Double ejercicioexiii_rep;

	private Double ejercicioexiv_not;
	private Double ejercicioexiv_ptos;
	private Double ejercicioexiv_rep;
	private Double ejercicioexiv_rep_min;
	private Double ejercicioexiv_rep_sec;
	
	private Double ejercicioexv_not;
	private Double ejercicioexv_ptos;
	private Double ejercicioexv_rep;
	private Double ejercicioexv_rep_min;
	private Double ejercicioexv_rep_sec;
	
	private String observacion;
	private String sit_observacion;
	
	private Double promedio;
	private String resultado;
	private Double total;
	
	public Long getKey() {
		return key;
	}
	public void setKey(Long key) {
		this.key = key;
	}
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}
	public String getArma() {
		return arma;
	}
	public void setArma(String arma) {
		this.arma = arma;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Long getEdad() {
		return edad;
	}
	public void setEdad(Long edad) {
		this.edad = edad;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getTalla() {
		return talla;
	}
	public void setTalla(Double talla) {
		this.talla = talla;
	}
	public String getProcedencia() {
		return procedencia;
	}
	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	public String getBrigada() {
		return brigada;
	}
	public void setBrigada(String brigada) {
		this.brigada = brigada;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public Double getEjercicioi_not() {
		return ejercicioi_not;
	}
	public void setEjercicioi_not(Double ejercicioi_not) {
		this.ejercicioi_not = ejercicioi_not;
	}
	public Double getEjercicioi_ptos() {
		return ejercicioi_ptos;
	}
	public void setEjercicioi_ptos(Double ejercicioi_ptos) {
		this.ejercicioi_ptos = ejercicioi_ptos;
	}
	public Double getEjercicioi_rep() {
		return ejercicioi_rep;
	}
	public void setEjercicioi_rep(Double ejercicioi_rep) {
		this.ejercicioi_rep = ejercicioi_rep;
	}
	public Double getEjercicioii_not() {
		return ejercicioii_not;
	}
	public void setEjercicioii_not(Double ejercicioii_not) {
		this.ejercicioii_not = ejercicioii_not;
	}
	public Double getEjercicioii_ptos() {
		return ejercicioii_ptos;
	}
	public void setEjercicioii_ptos(Double ejercicioii_ptos) {
		this.ejercicioii_ptos = ejercicioii_ptos;
	}
	public Double getEjercicioii_rep() {
		return ejercicioii_rep;
	}
	public void setEjercicioii_rep(Double ejercicioii_rep) {
		this.ejercicioii_rep = ejercicioii_rep;
	}
	public Double getEjercicioiii_not() {
		return ejercicioiii_not;
	}
	public void setEjercicioiii_not(Double ejercicioiii_not) {
		this.ejercicioiii_not = ejercicioiii_not;
	}
	public Double getEjercicioiii_ptos() {
		return ejercicioiii_ptos;
	}
	public void setEjercicioiii_ptos(Double ejercicioiii_ptos) {
		this.ejercicioiii_ptos = ejercicioiii_ptos;
	}
	public Double getEjercicioiii_rep() {
		return ejercicioiii_rep;
	}
	public void setEjercicioiii_rep(Double ejercicioiii_rep) {
		this.ejercicioiii_rep = ejercicioiii_rep;
	}
	public Double getEjercicioiv_not() {
		return ejercicioiv_not;
	}
	public void setEjercicioiv_not(Double ejercicioiv_not) {
		this.ejercicioiv_not = ejercicioiv_not;
	}
	public Double getEjercicioiv_ptos() {
		return ejercicioiv_ptos;
	}
	public void setEjercicioiv_ptos(Double ejercicioiv_ptos) {
		this.ejercicioiv_ptos = ejercicioiv_ptos;
	}
	public Double getEjercicioiv_rep() {
		return ejercicioiv_rep;
	}
	public void setEjercicioiv_rep(Double ejercicioiv_rep) {
		this.ejercicioiv_rep = ejercicioiv_rep;
	}
	public Double getEjerciciov_not() {
		return ejerciciov_not;
	}
	public void setEjerciciov_not(Double ejerciciov_not) {
		this.ejerciciov_not = ejerciciov_not;
	}
	public Double getEjerciciov_ptos() {
		return ejerciciov_ptos;
	}
	public void setEjerciciov_ptos(Double ejerciciov_ptos) {
		this.ejerciciov_ptos = ejerciciov_ptos;
	}
	public Double getEjerciciov_rep() {
		return ejerciciov_rep;
	}
	public void setEjerciciov_rep(Double ejerciciov_rep) {
		this.ejerciciov_rep = ejerciciov_rep;
	}
	
	

	public Double getEjerciciovi_not() {
		return ejerciciovi_not;
	}
	public void setEjerciciovi_not(Double ejerciciovi_not) {
		this.ejerciciovi_not = ejerciciovi_not;
	}
	public Double getEjerciciovi_ptos() {
		return ejerciciovi_ptos;
	}
	public void setEjerciciovi_ptos(Double ejerciciovi_ptos) {
		this.ejerciciovi_ptos = ejerciciovi_ptos;
	}
	public Double getEjerciciovi_rep() {
		return ejerciciovi_rep;
	}
	public void setEjerciciovi_rep(Double ejerciciovi_rep) {
		this.ejerciciovi_rep = ejerciciovi_rep;
	}
	public String getOptvii() {
		return optvii;
	}
	public void setOptvii(String optvii) {
		this.optvii = optvii;
	}
	public Double getEjerciciovi_rep_min() {
		return ejerciciovi_rep_min;
	}
	public void setEjerciciovi_rep_min(Double ejerciciovi_rep_min) {
		this.ejerciciovi_rep_min = ejerciciovi_rep_min;
	}
	public Double getEjerciciovi_rep_sec() {
		return ejerciciovi_rep_sec;
	}
	public void setEjerciciovi_rep_sec(Double ejerciciovi_rep_sec) {
		this.ejerciciovi_rep_sec = ejerciciovi_rep_sec;
	}
	public Double getEjercicioviii_not() {
		return ejercicioviii_not;
	}
	public void setEjercicioviii_not(Double ejercicioviii_not) {
		this.ejercicioviii_not = ejercicioviii_not;
	}
	public Double getEjercicioviii_ptos() {
		return ejercicioviii_ptos;
	}
	public void setEjercicioviii_ptos(Double ejercicioviii_ptos) {
		this.ejercicioviii_ptos = ejercicioviii_ptos;
	}
	public Double getEjercicioviii_rep() {
		return ejercicioviii_rep;
	}
	public void setEjercicioviii_rep(Double ejercicioviii_rep) {
		this.ejercicioviii_rep = ejercicioviii_rep;
	}
	public Double getEjercicioviii_rep_min() {
		return ejercicioviii_rep_min;
	}
	public void setEjercicioviii_rep_min(Double ejercicioviii_rep_min) {
		this.ejercicioviii_rep_min = ejercicioviii_rep_min;
	}
	public Double getEjercicioviii_rep_sec() {
		return ejercicioviii_rep_sec;
	}
	public void setEjercicioviii_rep_sec(Double ejercicioviii_rep_sec) {
		this.ejercicioviii_rep_sec = ejercicioviii_rep_sec;
	}
	public Double getEjercicioix_not() {
		return ejercicioix_not;
	}
	public void setEjercicioix_not(Double ejercicioix_not) {
		this.ejercicioix_not = ejercicioix_not;
	}
	public Double getEjercicioix_ptos() {
		return ejercicioix_ptos;
	}
	public void setEjercicioix_ptos(Double ejercicioix_ptos) {
		this.ejercicioix_ptos = ejercicioix_ptos;
	}
	public Double getEjercicioix_rep() {
		return ejercicioix_rep;
	}
	public void setEjercicioix_rep(Double ejercicioix_rep) {
		this.ejercicioix_rep = ejercicioix_rep;
	}
	public Double getEjercicioix_rep_min() {
		return ejercicioix_rep_min;
	}
	public void setEjercicioix_rep_min(Double ejercicioix_rep_min) {
		this.ejercicioix_rep_min = ejercicioix_rep_min;
	}
	public Double getEjercicioix_rep_sec() {
		return ejercicioix_rep_sec;
	}
	public void setEjercicioix_rep_sec(Double ejercicioix_rep_sec) {
		this.ejercicioix_rep_sec = ejercicioix_rep_sec;
	}
	public Double getEjerciciox_not() {
		return ejerciciox_not;
	}
	public void setEjerciciox_not(Double ejerciciox_not) {
		this.ejerciciox_not = ejerciciox_not;
	}
	public Double getEjerciciox_ptos() {
		return ejerciciox_ptos;
	}
	public void setEjerciciox_ptos(Double ejerciciox_ptos) {
		this.ejerciciox_ptos = ejerciciox_ptos;
	}
	public Double getEjerciciox_rep() {
		return ejerciciox_rep;
	}
	public void setEjerciciox_rep(Double ejerciciox_rep) {
		this.ejerciciox_rep = ejerciciox_rep;
	}
	public Double getEjerciciox_rep_min() {
		return ejerciciox_rep_min;
	}
	public void setEjerciciox_rep_min(Double ejerciciox_rep_min) {
		this.ejerciciox_rep_min = ejerciciox_rep_min;
	}
	public Double getEjerciciox_rep_sec() {
		return ejerciciox_rep_sec;
	}
	public void setEjerciciox_rep_sec(Double ejerciciox_rep_sec) {
		this.ejerciciox_rep_sec = ejerciciox_rep_sec;
	}
	public Double getEjercicioexi_not() {
		return ejercicioexi_not;
	}
	public void setEjercicioexi_not(Double ejercicioexi_not) {
		this.ejercicioexi_not = ejercicioexi_not;
	}
	public Double getEjercicioexi_ptos() {
		return ejercicioexi_ptos;
	}
	public void setEjercicioexi_ptos(Double ejercicioexi_ptos) {
		this.ejercicioexi_ptos = ejercicioexi_ptos;
	}
	public Double getEjercicioexi_rep() {
		return ejercicioexi_rep;
	}
	public void setEjercicioexi_rep(Double ejercicioexi_rep) {
		this.ejercicioexi_rep = ejercicioexi_rep;
	}
	public Double getEjercicioexi_rep_min() {
		return ejercicioexi_rep_min;
	}
	public void setEjercicioexi_rep_min(Double ejercicioexi_rep_min) {
		this.ejercicioexi_rep_min = ejercicioexi_rep_min;
	}
	public Double getEjercicioexi_rep_sec() {
		return ejercicioexi_rep_sec;
	}
	public void setEjercicioexi_rep_sec(Double ejercicioexi_rep_sec) {
		this.ejercicioexi_rep_sec = ejercicioexi_rep_sec;
	}
	public Double getEjercicioexii_not() {
		return ejercicioexii_not;
	}
	public void setEjercicioexii_not(Double ejercicioexii_not) {
		this.ejercicioexii_not = ejercicioexii_not;
	}
	public Double getEjercicioexii_ptos() {
		return ejercicioexii_ptos;
	}
	public void setEjercicioexii_ptos(Double ejercicioexii_ptos) {
		this.ejercicioexii_ptos = ejercicioexii_ptos;
	}
	public Double getEjercicioexii_rep() {
		return ejercicioexii_rep;
	}
	public void setEjercicioexii_rep(Double ejercicioexii_rep) {
		this.ejercicioexii_rep = ejercicioexii_rep;
	}
	public Double getEjercicioexii_rep_min() {
		return ejercicioexii_rep_min;
	}
	public void setEjercicioexii_rep_min(Double ejercicioexii_rep_min) {
		this.ejercicioexii_rep_min = ejercicioexii_rep_min;
	}
	public Double getEjercicioexii_rep_sec() {
		return ejercicioexii_rep_sec;
	}
	public void setEjercicioexii_rep_sec(Double ejercicioexii_rep_sec) {
		this.ejercicioexii_rep_sec = ejercicioexii_rep_sec;
	}
	public Double getEjercicioexiii_not() {
		return ejercicioexiii_not;
	}
	public void setEjercicioexiii_not(Double ejercicioexiii_not) {
		this.ejercicioexiii_not = ejercicioexiii_not;
	}
	public Double getEjercicioexiii_ptos() {
		return ejercicioexiii_ptos;
	}
	public void setEjercicioexiii_ptos(Double ejercicioexiii_ptos) {
		this.ejercicioexiii_ptos = ejercicioexiii_ptos;
	}
	public Double getEjercicioexiii_rep() {
		return ejercicioexiii_rep;
	}
	public void setEjercicioexiii_rep(Double ejercicioexiii_rep) {
		this.ejercicioexiii_rep = ejercicioexiii_rep;
	}
	public Double getEjercicioexiv_not() {
		return ejercicioexiv_not;
	}
	public void setEjercicioexiv_not(Double ejercicioexiv_not) {
		this.ejercicioexiv_not = ejercicioexiv_not;
	}
	public Double getEjercicioexiv_ptos() {
		return ejercicioexiv_ptos;
	}
	public void setEjercicioexiv_ptos(Double ejercicioexiv_ptos) {
		this.ejercicioexiv_ptos = ejercicioexiv_ptos;
	}
	public Double getEjercicioexiv_rep() {
		return ejercicioexiv_rep;
	}
	public void setEjercicioexiv_rep(Double ejercicioexiv_rep) {
		this.ejercicioexiv_rep = ejercicioexiv_rep;
	}
	public Double getEjercicioexiv_rep_min() {
		return ejercicioexiv_rep_min;
	}
	public void setEjercicioexiv_rep_min(Double ejercicioexiv_rep_min) {
		this.ejercicioexiv_rep_min = ejercicioexiv_rep_min;
	}
	public Double getEjercicioexiv_rep_sec() {
		return ejercicioexiv_rep_sec;
	}
	public void setEjercicioexiv_rep_sec(Double ejercicioexiv_rep_sec) {
		this.ejercicioexiv_rep_sec = ejercicioexiv_rep_sec;
	}
	public Double getEjercicioexv_not() {
		return ejercicioexv_not;
	}
	public void setEjercicioexv_not(Double ejercicioexv_not) {
		this.ejercicioexv_not = ejercicioexv_not;
	}
	public Double getEjercicioexv_ptos() {
		return ejercicioexv_ptos;
	}
	public void setEjercicioexv_ptos(Double ejercicioexv_ptos) {
		this.ejercicioexv_ptos = ejercicioexv_ptos;
	}
	public Double getEjercicioexv_rep() {
		return ejercicioexv_rep;
	}
	public void setEjercicioexv_rep(Double ejercicioexv_rep) {
		this.ejercicioexv_rep = ejercicioexv_rep;
	}
	public Double getEjercicioexv_rep_min() {
		return ejercicioexv_rep_min;
	}
	public void setEjercicioexv_rep_min(Double ejercicioexv_rep_min) {
		this.ejercicioexv_rep_min = ejercicioexv_rep_min;
	}
	public Double getEjercicioexv_rep_sec() {
		return ejercicioexv_rep_sec;
	}
	public void setEjercicioexv_rep_sec(Double ejercicioexv_rep_sec) {
		this.ejercicioexv_rep_sec = ejercicioexv_rep_sec;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getSit_observacion() {
		return sit_observacion;
	}
	public void setSit_observacion(String sit_observacion) {
		this.sit_observacion = sit_observacion;
	}
	public Double getPromedio() {
		return promedio;
	}
	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public TcfyDet(Long key, 
			String grado,
			String arma, 
			String nombre, 
			String sexo,
			Long edad, 
			Double peso,
			Double talla, 
			String procedencia,
			String brigada, 
			String division, 
			String unidad, 
			Double ejercicioi_not,
			Double ejercicioi_ptos, 
			Double ejercicioi_rep,
			Double ejercicioii_not, 
			Double ejercicioii_ptos,
			Double ejercicioii_rep, 
			Double ejercicioiii_not, 
			Double ejercicioiii_ptos, 
			Double ejercicioiii_rep,
			Double ejercicioiv_not, 
			Double ejercicioiv_ptos, 
			Double ejercicioiv_rep, 
			Double ejerciciov_not,
			Double ejerciciov_ptos, 
			Double ejerciciov_rep, 
			Double ejerciciovi_not,
			Double ejerciciovi_ptos,
			
			Double ejerciciovi_rep, String optvii, Double ejerciciovi_rep_min, Double ejerciciovi_rep_sec,
			Double ejercicioviii_not, Double ejercicioviii_ptos, Double ejercicioviii_rep, Double ejercicioviii_rep_min,
			Double ejercicioviii_rep_sec, Double ejercicioix_not, Double ejercicioix_ptos, Double ejercicioix_rep,
			Double ejercicioix_rep_min, Double ejercicioix_rep_sec, Double ejerciciox_not, Double ejerciciox_ptos,
			Double ejerciciox_rep, Double ejerciciox_rep_min, Double ejerciciox_rep_sec, Double ejercicioexi_not,
			Double ejercicioexi_ptos, Double ejercicioexi_rep, Double ejercicioexi_rep_min, Double ejercicioexi_rep_sec,
			Double ejercicioexii_not, Double ejercicioexii_ptos, Double ejercicioexii_rep, Double ejercicioexii_rep_min,
			Double ejercicioexii_rep_sec, Double ejercicioexiii_not, Double ejercicioexiii_ptos,
			Double ejercicioexiii_rep, Double ejercicioexiv_not, Double ejercicioexiv_ptos, Double ejercicioexiv_rep,
			Double ejercicioexiv_rep_min, Double ejercicioexiv_rep_sec, Double ejercicioexv_not,
			Double ejercicioexv_ptos, Double ejercicioexv_rep, Double ejercicioexv_rep_min, Double ejercicioexv_rep_sec,
			String observacion, String sit_observacion, Double promedio, String resultado, Double total) {

		this.key = key;
		this.grado = grado;
		this.arma = arma;
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.peso = peso;
		this.talla = talla;
		this.procedencia = procedencia;
		this.brigada = brigada;
		this.division = division;
		this.unidad = unidad;
		this.ejercicioi_not = ejercicioi_not;
		this.ejercicioi_ptos = ejercicioi_ptos;
		this.ejercicioi_rep = ejercicioi_rep;
		this.ejercicioii_not = ejercicioii_not;
		this.ejercicioii_ptos = ejercicioii_ptos;
		this.ejercicioii_rep = ejercicioii_rep;
		this.ejercicioiii_not = ejercicioiii_not;
		this.ejercicioiii_ptos = ejercicioiii_ptos;
		this.ejercicioiii_rep = ejercicioiii_rep;
		this.ejercicioiv_not = ejercicioiv_not;
		this.ejercicioiv_ptos = ejercicioiv_ptos;
		this.ejercicioiv_rep = ejercicioiv_rep;
		this.ejerciciov_not = ejerciciov_not;
		this.ejerciciov_ptos = ejerciciov_ptos;
		this.ejerciciov_rep = ejerciciov_rep;
		this.ejerciciovi_not = ejerciciovi_not;
		
		this.ejerciciovi_ptos = ejerciciovi_ptos;
		this.ejerciciovi_rep = ejerciciovi_rep;
		this.optvii = optvii;
		this.ejerciciovi_rep_min = ejerciciovi_rep_min;
		this.ejerciciovi_rep_sec = ejerciciovi_rep_sec;
		this.ejercicioviii_not = ejercicioviii_not;
		this.ejercicioviii_ptos = ejercicioviii_ptos;
		this.ejercicioviii_rep = ejercicioviii_rep;
		this.ejercicioviii_rep_min = ejercicioviii_rep_min;
		this.ejercicioviii_rep_sec = ejercicioviii_rep_sec;
		this.ejercicioix_not = ejercicioix_not;
		this.ejercicioix_ptos = ejercicioix_ptos;
		this.ejercicioix_rep = ejercicioix_rep;
		this.ejercicioix_rep_min = ejercicioix_rep_min;
		this.ejercicioix_rep_sec = ejercicioix_rep_sec;
		this.ejerciciox_not = ejerciciox_not;
		this.ejerciciox_ptos = ejerciciox_ptos;
		this.ejerciciox_rep = ejerciciox_rep;
		this.ejerciciox_rep_min = ejerciciox_rep_min;
		this.ejerciciox_rep_sec = ejerciciox_rep_sec;
		this.ejercicioexi_not = ejercicioexi_not;
		this.ejercicioexi_ptos = ejercicioexi_ptos;
		this.ejercicioexi_rep = ejercicioexi_rep;
		this.ejercicioexi_rep_min = ejercicioexi_rep_min;
		this.ejercicioexi_rep_sec = ejercicioexi_rep_sec;
		this.ejercicioexii_not = ejercicioexii_not;
		this.ejercicioexii_ptos = ejercicioexii_ptos;
		this.ejercicioexii_rep = ejercicioexii_rep;
		this.ejercicioexii_rep_min = ejercicioexii_rep_min;
		this.ejercicioexii_rep_sec = ejercicioexii_rep_sec;
		this.ejercicioexiii_not = ejercicioexiii_not;
		this.ejercicioexiii_ptos = ejercicioexiii_ptos;
		this.ejercicioexiii_rep = ejercicioexiii_rep;
		this.ejercicioexiv_not = ejercicioexiv_not;
		this.ejercicioexiv_ptos = ejercicioexiv_ptos;
		this.ejercicioexiv_rep = ejercicioexiv_rep;
		this.ejercicioexiv_rep_min = ejercicioexiv_rep_min;
		this.ejercicioexiv_rep_sec = ejercicioexiv_rep_sec;
		this.ejercicioexv_not = ejercicioexv_not;
		this.ejercicioexv_ptos = ejercicioexv_ptos;
		this.ejercicioexv_rep = ejercicioexv_rep;
		this.ejercicioexv_rep_min = ejercicioexv_rep_min;
		this.ejercicioexv_rep_sec = ejercicioexv_rep_sec;
		this.observacion = observacion;
		this.sit_observacion = sit_observacion;
		this.promedio = promedio;
		this.resultado = resultado;
		this.total = total;
	}

	

	private static final long serialVersionUID = 1L;
	

}
