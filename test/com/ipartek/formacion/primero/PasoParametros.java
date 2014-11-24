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

	int resul = incrementar(parametroValor);
	assertEquals(2, parametroValor);
	assertEquals(3, resul);

    }

    public void testPasoParametroReferencia() {

	incrementar(parametroReferencia);
	assertEquals(3, parametroReferencia.getNumPlazas());

	// apuntan al mismo objeto al mismo sitio de memoria para poder cambiar
	// sin que afecte a l primero clonar
	VehiculoElectrico vCopia = parametroReferencia;
	incrementar(vCopia);

	assertEquals(4, parametroReferencia.getNumPlazas());
	assertEquals(4, vCopia.getNumPlazas());

	// Lo clonamos para qeu no cambie al original
	VehiculoElectrico vClon = null;
	try {
	    // recordar que debemos imp`lementar interface Clonable
	    vClon = parametroReferencia.clone();
	} catch (CloneNotSupportedException e) {
	    fail("No se puede clonar " + vClon);
	}
	// incrementar(parametroReferencia.clone()); - Es lo mismo
	incrementar(vClon);
	assertEquals(4, parametroReferencia.getNumPlazas());
	assertEquals(5, vClon.getNumPlazas());
    }

    // Crear dos metodos para poder modificar los parametros

    // incrementar en uno de 2 a 3
    int incrementar(int parametroValor) {
	parametroValor++;
	return parametroValor;
    }

    // Incrementar el numero de puertas de 2 a 3
    VehiculoElectrico incrementar(VehiculoElectrico parametroReferencia) {
	parametroReferencia
		.setNumPlazas(parametroReferencia.getNumPlazas() + 1);
	return parametroReferencia;
    }

}
