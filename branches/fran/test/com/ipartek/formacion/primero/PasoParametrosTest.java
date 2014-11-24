package com.ipartek.formacion.primero;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.herencia.VehiculoElectrico;

public class PasoParametrosTest {
	int parametroValor = 2;
	VehiculoElectrico parametroReferencia = new VehiculoElectrico();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPasoParametroValor() {
		int resul = incrementar(parametroValor);
		assertEquals(2, parametroValor);
		assertEquals(3, resul);
	}

	@Test
	public void testPasoParametroReferencia() {
		incrementar(parametroReferencia);
		assertEquals(3, parametroReferencia.getNumPlazas());

		VehiculoElectrico vCopia = parametroReferencia;
		incrementar(vCopia);
		assertEquals(4, parametroReferencia.getNumPlazas());
		assertEquals(4, vCopia.getNumPlazas());

		try {
			VehiculoElectrico vClone = (VehiculoElectrico) parametroReferencia
					.clone();
			incrementar(vClone);
			assertEquals(4, parametroReferencia.getNumPlazas());
			assertEquals(5, vClone.getNumPlazas());
		} catch (Exception e) {
			fail("Error al clonar");
		}

	}

	// Crear dos metodos para poder modificar los parámetros
	int incrementar(int parametroValor) {
		parametroValor++;
		return parametroValor;
	}

	VehiculoElectrico incrementar(VehiculoElectrico parametroReferencia) {
		parametroReferencia
		.setNumPlazas(parametroReferencia.getNumPlazas() + 1);
		return parametroReferencia;
	}

}
