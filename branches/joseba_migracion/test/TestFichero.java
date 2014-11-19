import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.ejercicio.migracion.util.Fichero;

public class TestFichero {

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
    public void testFichero() {
	String linea = "Ted,Upton,Sant Andreu De La Barca,8,tedfupton@mailinator.com,12277015Y,TRABAJADOR";
	List<String> al1 = new ArrayList<String>();
	al1 = Fichero.separarValores(linea);
	assertEquals("Ted", al1.get(0));
	assertEquals("TRABAJADOR", al1.get(6));
    }

}
