package com.ipartek.formacion.primero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.Test;

import com.ipartek.formacion.primero.bean.herencia.VehiculoElectrico;

public class PasoParametros {

    int paramatroValor = 2;
    VehiculoElectrico parametroReferencia = new VehiculoElectrico();

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Test
    public void testPasoParametroValor() {

	int resul = incrementar(paramatroValor);
	assertEquals(2, paramatroValor);
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

	VehiculoElectrico vClon = null;
	try {
	    // recordar que debemos implementar interface Clonable
	    vClon = (VehiculoElectrico) parametroReferencia.clone();
	} catch (CloneNotSupportedException e) {
	    fail("No se puedo clonar " + vClon);
	}
	incrementar(vClon);
	assertEquals(4, parametroReferencia.getNumPlazas());
	assertEquals(5, vClon.getNumPlazas());

    }

    // Crear dos metros para poder modificar los parametros

    // incrementar en uno de 2 a 3
    int incrementar(int paramatroValor) {
	paramatroValor++;
	return paramatroValor;
    }

    // incrementar el numero de puertas de 2 a 3
    VehiculoElectrico incrementar(VehiculoElectrico parametroReferencia) {
	parametroReferencia
		.setNumPlazas(parametroReferencia.getNumPlazas() + 1);
	return parametroReferencia;
    }
}
