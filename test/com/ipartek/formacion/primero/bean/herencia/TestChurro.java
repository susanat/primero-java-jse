package com.ipartek.formacion.primero.bean.herencia;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.interfaces.IOrdenable;
import com.ipartek.formacion.primero.bean.interfaces.IOrdenable.comparatorPeso;

public class TestChurro {

	ArrayList<IOrdenable> listaInterfacesOrdenable = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		listaInterfacesOrdenable = new ArrayList<IOrdenable>();
		listaInterfacesOrdenable.add(new VehiculoElectrico(100f, 350f));
		listaInterfacesOrdenable.add(new VehiculoElectrico(100f, 0f));
		listaInterfacesOrdenable.add(new VehiculoElectrico(100f, 13f));
		listaInterfacesOrdenable.add(new Churro(50f));
		listaInterfacesOrdenable.add(new Churro(350f));
	}

	@After
	public void tearDown() throws Exception {
		listaInterfacesOrdenable = null;
	}

	@Test
	public void test() {

		// Ordenamos segun el criterio que hemos elegido
		Collections.sort(listaInterfacesOrdenable, new comparatorPeso());

		assertEquals(0f, listaInterfacesOrdenable.get(0).getPeso(),
				Float.MIN_VALUE);
		assertEquals(13f, listaInterfacesOrdenable.get(1).getPeso(),
				Float.MIN_VALUE);
		assertEquals(50f, listaInterfacesOrdenable.get(2).getPeso(),
				Float.MIN_VALUE);
		assertEquals(350f, listaInterfacesOrdenable.get(3).getPeso(),
				Float.MIN_VALUE);
		assertEquals(350f, listaInterfacesOrdenable.get(4).getPeso(),
				Float.MIN_VALUE);

	}
}
