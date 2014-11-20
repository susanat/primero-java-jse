package com.ipartek.formacion.primero.practicas.migracion;

import java.util.GregorianCalendar;

public class Estadistica {
	private int registrosLeidos;
	private long inicioProceso;
	private long finalProceso;

	private int registrosCorrectos;
	private int registrosErroneos;
	private int registrosDuplicados;

	public void Estadistica() {

		this.registrosLeidos = 0;
		this.registrosCorrectos = 0;
		this.registrosErroneos = 0;
		this.registrosDuplicados = 0;
	}

	public void inicializar() {
		GregorianCalendar gc = new GregorianCalendar();
		this.inicioProceso = gc.getTimeInMillis();
	}

	public void finalizar() {
		GregorianCalendar gc = new GregorianCalendar();
		this.finalProceso = gc.getTimeInMillis();
	}

	public int getRegistrosLeidos() {
		return registrosLeidos;
	}

	public int getRegistrosCorrectos() {
		return registrosCorrectos;
	}

	public int getRegistrosErroneos() {
		return registrosErroneos;
	}

	public int getRegistrosDuplicados() {
		return registrosDuplicados;
	}

	public void aumentarRegistrosLeidos() {
		this.registrosLeidos++;
	}

	public void aumentarRegistrosCorrectos() {
		this.registrosCorrectos++;
	}

	public void aumentarRegistrosErroneos() {
		this.registrosErroneos++;
	}

	public void aumentarRegistrosDuplicados() {
		this.registrosDuplicados++;
	}
}
