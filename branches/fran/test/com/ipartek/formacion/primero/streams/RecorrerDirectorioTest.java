package com.ipartek.formacion.primero.streams;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RecorrerDirectorioTest {
	// directorioa a crear
	static final String DIR_ROOT = "tmp";
	static final String DIR1 = "tmp/mp3";
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

		Fichero fic = new Fichero();
		assertTrue(fic.create(DIR2 + FILE1, ""));
		assertTrue(fic.create(DIR2 + FILE2, ""));
		assertTrue(fic.create(DIR3 + FILE3, ""));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Fichero fic = new Fichero();
		assertTrue(fic.deleteDirectory(new File(DIR_ROOT)));
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Fichero fic = new Fichero();
		// fic.dibujarCarpetas("C:\\desarrollo\\carpeta1", "");
		fic.dibujarCarpetas(DIR_ROOT, "");
		assertTrue(true);
	}

}
