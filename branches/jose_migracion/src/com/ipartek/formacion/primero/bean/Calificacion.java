package com.ipartek.formacion.primero.bean;

import java.sql.Timestamp;

/**
 * Calificaciones para las notas de los alumnos, para una asignatura en una fecha concreta
 * Una Calificacion se compone de:
 * <ul>
 * 	<li>asignatura: asignatura de la calificacion</li>
 *  <li>nota: entre 0.0 y 10.0</li>
 *  <li>fecha: fecha realizacion de la calificacion</li>
 * </ul>
 * 
 * @author Ander Uraga Real
 *
 */
public class Calificacion {

	/**
	 * Nombre de una asignatura por defecto
	 */
	public static final String ASIGNATURA_EMPTY = "Sin determinar";
	
	/**
	 * Maxima nota que puede tener una asignatura
	 */
	public static final float  MAX_NOTA = 10f;
	
	/**
	 * Minima nota que puede tener una asignatura
	 */
	public static final float  MIN_NOTA =  0f;
	
	//Atributos
	
	private String asignatura;
	
	private float nota; // comprendida de 0.0 a 10.0
	
	private Timestamp fecha;

	//constructor
	public Calificacion(String asignatura, float nota, Timestamp fecha) {
		super();
		setAsignatura(asignatura);
		setNota(nota);
		setFecha(fecha);
	}

	
	
	//getters y setters
	
	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		if ( asignatura != null ){
		    this.asignatura = asignatura;	
		}else{
			this.asignatura = ASIGNATURA_EMPTY;
		}
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		if ( nota < MIN_NOTA ){
			this.nota = MIN_NOTA;
		}else if (  nota > MAX_NOTA ){
			this.nota = MAX_NOTA;
		}else{
			this.nota = nota;
		}	
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	
}
