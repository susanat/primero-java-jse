package com.ipartek.formacion.primero.bean;

import java.util.ArrayList;

import org.junit.Test;

public class GenericoTest {

	@Test
	public void test() {
		final Generico<String> gString = new Generico<String>();
		gString.setAtributo("Hola");

		final Generico<Integer> gInteger = new Generico<Integer>();
		gInteger.setAtributo(3);

		final ArrayList<Generico<String>> gListString = new ArrayList<Generico<String>>();
		gListString.add(gString);
	}

}
