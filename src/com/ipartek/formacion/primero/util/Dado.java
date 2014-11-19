package com.ipartek.formacion.primero.util;

import com.ipartek.formacion.sergio.utils.ClsUtilsNumeros;

public class Dado {
	
	final public static String[] alumnos = new String[]{
		"Susana",
		"Zuahitz",
		"Kepa",
		"Urko",
		"Jon",
		"Sergio",
		"Joseba",
		"Mario",
		"Aritz",
		"Fran",
		"Maitane",
		"Jose"
	};	
	
	
	private String lastAlumno = "";
	private int lastIndexTirada = -1;
		
	
	public int getLastIndexTirada(){
		return lastIndexTirada;
	}
	
	public void tirar(){			
		this.lastIndexTirada = ClsUtilsNumeros.valorAleatorio(0, alumnos.length - 1);
		this.lastAlumno = Dado.alumnos[lastIndexTirada];
	}
	
	@Override
	public String toString(){
		return lastAlumno;
	}

	
}
