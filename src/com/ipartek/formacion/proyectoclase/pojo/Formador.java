package com.ipartek.formacion.proyectoclase.pojo;

public class Formador extends Persona {
	
	private Double sueldo;

	public final static Double SUELDO_MINIMO = 756.00;
	public Formador() {
		// TODO Auto-generated constructor stub
		super();
		setSueldo(SUELDO_MINIMO);
		
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		if(sueldo>=Formador.SUELDO_MINIMO)
			this.sueldo = sueldo;
	}
	
}
