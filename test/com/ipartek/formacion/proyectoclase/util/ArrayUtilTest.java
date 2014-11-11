package com.ipartek.formacion.proyectoclase.util;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ArrayUtilTest {
	private static ArrayUtil a_util;
	private static int[] array;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		array  = new int[]{10,1,9,7,6};
		a_util =  new ArrayUtil(array);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		a_util = null;
		array  = null;
	}
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSort() {
		int[] ar_solutions	= new int[]{1,6,7,9,10};
		int[] obtained		= null;
		a_util.sort();
		obtained = a_util.getArray();
		/*
		for(int i =0;i<ar_solutions.length;i++){
			System.out.println(ar_solutions[i]);

		}
		for(int valor:  ar_solutions){
			System.out.println(valor);
		}
		*/
		assertArrayEquals("La tarea de ordenación no se realizado correctamente",ar_solutions, obtained);
	}

}
