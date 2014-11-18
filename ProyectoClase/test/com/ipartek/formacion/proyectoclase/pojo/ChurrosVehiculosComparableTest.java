package com.ipartek.formacion.proyectoclase.pojo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.proyectoclase.pojo.herencia.VehiculoElectrico;

public class ChurrosVehiculosComparableTest {
	ArrayList<IOrdenable> ordenables = null;
	Churro ch1 = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ordenables = new ArrayList<IOrdenable>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCompare() {
		// fail("Not yet implemented");
		ordenables.add(new VehiculoElectrico(100.0));
		ordenables.add(new VehiculoElectrico(101.0));
		ordenables.add(new VehiculoElectrico(102.0));
		ordenables.add(new VehiculoElectrico(103.0));

		ordenables.add(new Churro(100.0));
		ordenables.add(new Churro(120.0));
		ordenables.add(new Churro(12.0));
		ordenables.add(new Churro(1030.0));

		// Collections.sort(lista, new ComparatorOrdenable());
		Collections.sort(ordenables, new OrdenarCurroElectrico());
		// test ordenacion del 1º y ultimo
		assertEquals(Double.valueOf(12.0), ordenables.get(0).getPeso());
		assertEquals(Double.valueOf(101.0), ordenables.get(3).getPeso());
		assertEquals(Double.valueOf(1030.0),
				ordenables.get((ordenables.size() - 1)).getPeso());

	}

}
