package modelo;

import java.sql.Date;

public class Alumno {
	private String dni, nombre, ap1, ap2, telf;
	private Date fNac;
	public Alumno(String dni, String nombre, String ap1, String ap2, Date fNac, String telf) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.ap1 = ap1;
		this.ap2 = ap2;
		this.telf = telf;
		this.fNac = fNac;
	}
	
	public Alumno() {
		super();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAp1() {
		return ap1;
	}

	public void setAp1(String ap1) {
		this.ap1 = ap1;
	}

	public String getAp2() {
		return ap2;
	}

	public void setAp2(String ap2) {
		this.ap2 = ap2;
	}

	public String getTelf() {
		return telf;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}

	public Date getfNac() {
		return fNac;
	}

	public void setfNac(Date fNac) {
		this.fNac = fNac;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", ap1=" + ap1 + ", ap2=" + ap2 + ", telf=" + telf
				+ ", fNac=" + fNac + "]";
	}

	public String toStringSimple() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", ap1=" + ap1 + "]";
	}
}
