package com.ipartek.formacion.primero;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runners.ParentRunner;

import com.ipartek.formacion.primero.bean.herencia.VehiculoElectrico;

public class PasoParametros {

	int parametroValor = 2;
	VehiculoElectrico parametroReferencia = new VehiculoElectrico();

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testPasoParametroValor() {
		int rdo = incrementar(parametroValor);
		assertEquals(2, parametroValor);
		assertEquals(3, rdo);
	}

	@Test
	public void testPasoParametroReferencia() {

		incrementar(parametroReferencia);
		assertEquals(3, parametroReferencia.getNumPlazas());

		VehiculoElectrico vCopia = parametroReferencia;
		incrementar(vCopia);
		assertEquals(4, parametroReferencia.getNumPlazas());
		assertEquals(4, vCopia.getNumPlazas());

		VehiculoElectrico vClon = null;
		try {
			vClon = (VehiculoElectrico) parametroReferencia.clone();
		} catch (CloneNotSupportedException e) {
			fail("No se puede clonar " + vClon.toString());
		}

		// recordar que debemos implementar interface Clonable en
		// VehiculoElectrico(o en la clase padre Vehiculo)
		incrementar(vClon);
		assertEquals(4, parametroReferencia.getNumPlazas());
		assertEquals(5, vClon.getNumPlazas());
	}

	// Crear dos metodos para poder modificar los parametros
	int incrementar(int parametroValor) {
		parametroValor++;
		return parametroValor;
	}

	// incrementar el numero de puertas de 2 a 3
	VehiculoElectrico incrementar(VehiculoElectrico parametroReferencia) {
		parametroReferencia
		.setNumPlazas(parametroReferencia.getNumPlazas() + 1);
		return parametroReferencia;
	}
}
