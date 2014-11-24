package com.ipartek.formacion.primero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.herencia.VehiculoElectrico;

public class PasoParametros {

	int parametroValor = 2;
	VehiculoElectrico parametroReferencia = new VehiculoElectrico();

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testPasoParametroValor() {
		final int res = incrementar(parametroValor);
		assertEquals(2, parametroValor);
		assertEquals(3, res);
	}

	@Test
	public void testPasoParametroReferencia() throws Exception {
		incrementar(parametroReferencia);
		assertEquals(3, parametroReferencia.getNumPlazas());

		final VehiculoElectrico vCopia = parametroReferencia;
		incrementar(vCopia);

		assertEquals(4, parametroReferencia.getNumPlazas());
		assertEquals(4, vCopia.getNumPlazas());

		VehiculoElectrico vClon = null;
		try {
			// Se debe implementar la interface cloneable
			vClon = parametroReferencia.clone();
		} catch (final CloneNotSupportedException e) {
			fail("No se puede clonar " + vClon.toString());
		}

		incrementar(vClon);
		assertEquals(4, parametroReferencia.getNumPlazas());
		assertEquals(5, vClon.getNumPlazas());
	}

	// Crear dos parámetros para poder modificar los parámetros
	int incrementar(int parametroValor) {
		parametroValor++;
		return parametroValor;
	}

	VehiculoElectrico incrementar(final VehiculoElectrico parametroReferencia) {
		parametroReferencia.setNumPlazas(parametroReferencia.getNumPlazas() + 1);
		return parametroReferencia;
	}
}
