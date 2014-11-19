import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.ejercicio.migracion.util.Utilidades;

public class TestEmailValidator {

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
    public void testEmail() {
	String validMail = "josebacarr@gmail.com";
	String invalidMail = "josebacarr@.com";
	assertTrue(Utilidades.validarEmail(validMail));
	assertFalse(Utilidades.validarEmail(invalidMail));

    }

}
