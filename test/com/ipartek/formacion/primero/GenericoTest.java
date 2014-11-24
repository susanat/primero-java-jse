package com.ipartek.formacion.primero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.Test;

import com.ipartek.formacion.primero.bean.Generico;

public class GenericoTest {

    @Test
    public void test() {
	// Generico de String
	Generico<String> gString = new Generico<String>();
	gString.setAtributo("Hola");

	assertEquals("Hola", gString.getAtributo());

	// Generico de Integer
	Generico<Integer> gInteger = new Generico<Integer>();
	gInteger.setAtributo(3);
	assertSame(3, gInteger.getAtributo());

	ArrayList<Generico<String>> gListString = new ArrayList<Generico<String>>();
	gListString.add(gString);

    }

}
