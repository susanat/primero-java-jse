package com.ipartek.formacion.primero.bean;

import java.util.ArrayList;



public class Alumno extends Persona {

	private ArrayList<Calificacion> arrayCalificacion = null;	
	
	public Alumno(){
		super();
	}
		
	
	/**
	 * Función que añade una calificación al alumno
	 * 
	 * @param calificacion Calificacion
	 */
	public void addCalificacion(Calificacion calificacion){
		if(arrayCalificacion == null)
			arrayCalificacion = new ArrayList<Calificacion>();
		
		arrayCalificacion.add(calificacion);			
	}
	
	/**
	 * Función que optiene una calificación por su nombre
	 * 
	 * @param asignature
	 * @return Calificacion o null si no existe
	 */
	public Calificacion getCalificacionByAsignature(String asignature){
		
		return checkIfExistCalificacion(asignature);			
					
	}
	
	/**
	 * Elimina una calificación por su nombre
	 * @param asignature
	 */
	public void removeCalificacion(String asignature){
		
		Calificacion obj = checkIfExistCalificacion(asignature);
		
		if(arrayCalificacion != null && obj != null)
			arrayCalificacion.remove(obj);
		
	}
	
	/**
	 * Elimina una calificación por su objeto
	 * 
	 * @param calificacion
	 */
	public void removeCalificacion(Calificacion calificacion){
		this.removeCalificacion(calificacion.getAsignatura());
	}
	
	
	/**
	 * Comprueba si existe una calificación
	 * 
	 * @param asignature
	 * @return
	 */
	private Calificacion checkIfExistCalificacion(String asignature){
		
		if(arrayCalificacion == null) return null;
		
		for(Calificacion d : arrayCalificacion){
	        if(d.getAsignatura() != null && d.getAsignatura().equalsIgnoreCase(asignature))
	        	return d;		           
	    }
		
		return null;
	}
}
