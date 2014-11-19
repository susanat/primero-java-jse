import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.ejercicio.migracion.util.Utilidades;

public class TestDNIValidator {

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
    public void testDNIValidator() {
	String validDNI = "45669077R";
	String invalidDNI = "45669077rr";
	String invalidDNI2 = "4556";
	assertTrue(Utilidades.validarDNI(validDNI));
	assertFalse(Utilidades.validarDNI(invalidDNI));

    }
}
