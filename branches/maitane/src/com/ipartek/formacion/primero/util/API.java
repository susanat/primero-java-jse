package com.ipartek.formacion.primero.util;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class API {

	public static ArrayList SepararTokenizer(String cadena, String separador) {

		String strTemp = null;
		ArrayList elementosCadena = new ArrayList<String>();
		StringTokenizer stringTokenizer = new StringTokenizer(cadena, separador);
		while (stringTokenizer.hasMoreTokens()) {
			strTemp = stringTokenizer.nextToken();
			elementosCadena.add(strTemp);

		}
		return elementosCadena;

	}

	public static String[] SepararSplit(String cadena, String separador) {

		String[] elementosCadena = cadena.split(separador);

		return elementosCadena;

	}

}
