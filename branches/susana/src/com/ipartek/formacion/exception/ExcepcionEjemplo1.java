package com.ipartek.formacion.exception;

public class ExcepcionEjemplo1 {
	
	static void metodoA(){
		metodoB();
	}
	
	static void metodoB(){
		metodoC();
	}

	static void metodoC(){
		String cadena="";
		
	}
	
	
	public static void main(String[] args) {
		metodoA();

	}

}
