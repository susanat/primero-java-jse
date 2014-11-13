package com.ipartek.formacion.vueltasdinero;

import com.ipartek.formacion.vueltasdinero.util.Calculadora;

public class CalcularVueltas {

	public static void main(String[] args) {

		Calculadora calc = new Calculadora();

		calc.calcularVueltas((float) 1326.24, 2000);

		calc.pintarVueltas();

	}

}
