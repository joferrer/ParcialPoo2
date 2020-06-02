

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestFecha.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestFecha
{
    private Fecha fecha;
    /**
     * Default constructor for test class TestFecha
     */
    public TestFecha()
    {
        fecha= new Fecha(20171010);
    }
    @Test
    public void testEmpleado3A()
    {
        Fecha  nueva = new Fecha(10,10,2017);
        Fecha otra= new Fecha(20171001);
        assertEquals(fecha.getDia(),nueva.getDia());
      
       
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
