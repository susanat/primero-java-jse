package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFichero {

    static final String FICHERO_TEST1 = "test.txt";
    static final String FICHERO_CONTENT = "Hello, I'm a test file";
    static final String FICHERO_CONTENT2 = "filename.txt \nlinea1 \nlinea2";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
	assertTrue(FICHERO_TEST1 + " No se pudo eliminar",
		Fichero.remove(FICHERO_TEST1));
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testFicheroCreate() {
	assertTrue(Fichero.create(FICHERO_TEST1, FICHERO_CONTENT));
    }

    @Test
    public void testFicheroRead() {
	try {
	    assertTrue(Fichero.create(FICHERO_TEST1, FICHERO_CONTENT2));
	    Fichero.read(FICHERO_TEST1);
	} catch (Exception e) {
	    fail("Exception leyendo el fichero");
	}

    }

    @Test(timeout = 1000)
    public void testRendimientoWrite() {

	assertTrue(Fichero.WritetoFile("conWrite.txt", 10000));
	assertTrue(Fichero.remove("conWrite.txt"));
    }

    @Test(timeout = 1000)
    public void testRendimientoStringBuilder() {
	assertTrue(Fichero.WritetoFileStringBuilder("conStringBuilder.txt",
		10000));
	assertTrue(Fichero.remove("conStringBuilder.txt"));
    }

    @Test
    public void testdibujarCarpetas() {

    }
}
