package com.autoparts.Adapter;

/**
 * 
 * @author anfer
 * 
 */
public class Model {

	private String model;
	private String god;
	private String motor;
	private String moshnost;
	private String odem;
	private String celinder;
	private String toplevo;
	private String kuzov;
	private String kod;

	public Model(String model, String god, String kod) {
		this.model = model;
		this.god = god;
		this.kod = kod;
	}

	public Model(String model, String god, String motor, String moshnost, String odem, String celinder, String toplevo, String kuzov) {
		this.model = model;
		this.god = god;
		this.motor = motor;
		this.moshnost = moshnost;
		this.odem = odem;
		this.celinder = celinder;
		this.toplevo = toplevo;
		this.kuzov = kuzov;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getGod() {
		return god;
	}

	public void setGod(String god) {
		this.god = god;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getMoshnost() {
		return moshnost;
	}

	public void setMoshnost(String moshnost) {
		this.moshnost = moshnost;
	}

	public String getOdem() {
		return odem;
	}

	public void setOdem(String odem) {
		this.odem = odem;
	}

	public String getCelinder() {
		return celinder;
	}

	public void setCelinder(String celinder) {
		this.celinder = celinder;
	}

	public String getToplevo() {
		return toplevo;
	}

	public void setToplevo(String toplevo) {
		this.toplevo = toplevo;
	}

	public String getKuzov() {
		return kuzov;
	}

	public void setKuzov(String kuzov) {
		this.kuzov = kuzov;
	}
}
