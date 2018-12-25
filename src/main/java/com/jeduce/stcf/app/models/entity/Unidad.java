package com.jeduce.stcf.app.models.entity;

public class Unidad {
	
	private String vnucleoDeslar;
	private String vgguuDeslar;
	private String vunidadDescor;
	private String cmilitarUuactual;
	
	
	public String getVunidadDescor() {
		return vunidadDescor;
	}
	public void setVunidadDescor(String vunidadDescor) {
		this.vunidadDescor = vunidadDescor;
	}
	public String getVnucleoDeslar() {
		return vnucleoDeslar;
	}
	public void setVnucleoDeslar(String vnucleoDeslar) {
		this.vnucleoDeslar = vnucleoDeslar;
	}
	public String getVgguuDeslar() {
		return vgguuDeslar;
	}
	public void setVgguuDeslar(String vgguuDeslar) {
		this.vgguuDeslar = vgguuDeslar;
	}
	public String getCmilitarUuactual() {
		return cmilitarUuactual;
	}
	public void setCmilitarUuactual(String cmilitarUuactual) {
		this.cmilitarUuactual = cmilitarUuactual;
	}
	public Unidad(String vnucleoDeslar, String vgguuDeslar, String vunidadDescor, String cmilitarUuactual) {
		this.vnucleoDeslar = vnucleoDeslar;
		this.vgguuDeslar = vgguuDeslar;
		this.vunidadDescor = vunidadDescor;
		this.cmilitarUuactual = cmilitarUuactual;
	}
	
	
}
