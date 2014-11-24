package com.ipartek.formacion.primero.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FicheroTest {

    static final String FICHERO_NAME_TEST1 = "filename.txt";
    static final String FICHERO_CONTENT_TEST1 = "Hello Wolrd";
    static final String FICHERO_CONTENT_TEST2 = "filename.txt \nlinea1 \nlinea2";

    static final int BUCLE = 10000;

    // directorioa a crear
    static final String DIR_ROOT = "tmp";
    static final String DIR1 = DIR_ROOT + "/mp3";
    static final String DIR2 = DIR1 + "/CelineDion";
    static final String DIR3 = DIR1 + "/SUtagAR";

    static final String FILE1 = "/track01.mp3";
    static final String FILE2 = "/track02.mp3";
    static final String FILE3 = "/track03.mp3";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

	assertTrue(new File(DIR1).mkdirs());
	assertTrue(new File(DIR2).mkdirs());
	assertTrue(new File(DIR3).mkdirs());

	assertTrue(Fichero.create(DIR2 + FILE1, ""));
	assertTrue(Fichero.create(DIR2 + FILE2, ""));
	assertTrue(Fichero.create(DIR3 + FILE3, ""));

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

	assertTrue(FICHERO_NAME_TEST1 + " No se pudo eliminar",
		Fichero.remove(FICHERO_NAME_TEST1));

	assertTrue(Fichero.deleteDirectory(new File(DIR_ROOT)));

    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreate() {

	assertTrue(Fichero.create(FICHERO_NAME_TEST1, FICHERO_CONTENT_TEST1));

    }

    @Test
    public void testRead() {

	try {

	    assertTrue(Fichero
		    .create(FICHERO_NAME_TEST1, FICHERO_CONTENT_TEST2));
	    Fichero.read(FICHERO_NAME_TEST1);

	} catch (Exception e) {
	    fail("Exception leyendo fichero");
	}

    }

    @Test(timeout = 1000)
    public void testWriteString() {
	String content = "";
	for (int i = 0; i < BUCLE; i++) {
	    content += "linea" + i + "\n";
	}
	Fichero.create(FICHERO_NAME_TEST1, content);
	// Fichero.read(FICHERO_NAME_TEST1);
	assertTrue(Fichero.remove(FICHERO_NAME_TEST1));
    }

    @Test(timeout = 1000)
    public void testWriteStringBuilder() {
	StringBuilder sbContent = new StringBuilder();
	for (int i = 0; i < BUCLE; i++) {
	    sbContent.append("linea" + i + "\n");
	}
	Fichero.create(FICHERO_NAME_TEST1, sbContent.toString());
	// Fichero.read(FICHERO_NAME_TEST1);
	assertTrue(Fichero.remove(FICHERO_NAME_TEST1));
    }

    @Test
    public void testDibujarDirectorio() {
	Fichero.mostrarDirectory(new File(DIR_ROOT));

    }

}
