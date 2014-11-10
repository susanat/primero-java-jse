package com.ipartek.formacion.primero.util;

public class Dado {


	
	static String[] alumnos = new String[]{
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
	
	static public void tirar (){		
		int aleatorio = (int)(Math.random()*alumnos.length);
		System.out.println(alumnos[aleatorio]);
	}
	
	public static void main(String[] args) {
		tirar();
		
	}
	
}
