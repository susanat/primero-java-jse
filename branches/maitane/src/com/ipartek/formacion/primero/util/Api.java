package com.ipartek.formacion.primero.util;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Api {

	public static ArrayList<String> SepararTokenizer(String cadena,
			String separador) {

		String strTemp = null;
		ArrayList<String> elementosCadena = new ArrayList<String>();
		StringTokenizer stringTokenizer = new StringTokenizer(cadena, separador);
		while (stringTokenizer.hasMoreTokens()) {
			strTemp = stringTokenizer.nextToken();
			elementosCadena.add(strTemp);

		}
		return elementosCadena;

	}

	public static String[] separarSplit(final String cadena,
			final String separador) {

		String[] elementosCadena = cadena.split(separador);

		return elementosCadena;

	}

}
