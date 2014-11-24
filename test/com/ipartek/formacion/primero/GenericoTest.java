package com.ipartek.formacion.primero;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.Generico;

public class GenericoTest {

	@Test
	public void test() {
		Generico<String> gString = new Generico<String>();
		gString.setAtributo("Hola");

		Generico<Integer> gInteger = new Generico<Integer>();
		gInteger.setAtributo(3);

		ArrayList<Generico<String>> gListString = new ArrayList<Generico<String>>();
		gListString.add(gString);
	}

}
