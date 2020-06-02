
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Formatter;
import java.util.Locale;

/**
 * Clase de pruebas para el examen.
 *
 * @author (Milton Jesús Vera Contreras - miltonjesusvc@ufps.edu.co) 
 * @version 0.000000000000001 :) --> Math.sin(Math.PI-Double.MIN_VALUE)
 */
public class TestNomina{
    private Empresa empresa;
    public static String [] [] datos = {{"108882300","Samuel","Cano Vega","310720","20030516","null"},
            {"102416454","Yeray","Costa Cruz","236585","20090229","null"},
            {"100195907","Jose","Bosch Rojas","300465","20090609","null"},
            {"105728243","Dario","Serra Lozano","161395","20080929","null"},
            {"91993336","Jose","Manuel Roca","83075","20020231","null"},
            {"102898955","Diego","Iglesias Garrido","173370","20080731","20150931"},
            {"108078648","Marco","Cortes Gil","262075","20051029","null"},
            {"93007503","Omar","Casas Sanz","312955","20031006","null"},
            {"100621406","Alberto","Gutierrez Navarro","291065","20031008","null"},
            {"108400772","Jaime","Delgado Gimenez","109790","20151230","null"},
            {"92586381","Marco","Ramos Perez","81965","20041208","null"},
            {"100113935","Jaime","Moreno Martin","214250","20120617","null"},
            {"95731916","Victor","Vila Delgado","308965","20071204","null"},
            {"94229751","Dario","Delgado Parra","124755","20160713","null"},
            {"88924295","Jose","Antonio Dominguez","186430","20140921","20160713"},
            {"94236500","Jose","Manuel Ruiz","292560","20150531","null"},
            {"103422199","Victor","Vargas Morales","93465","20010602","null"},
            {"89530810","Jose","Manuel Perez","321050","20080315","null"},
            {"91734056","Arturo","Moya Santiago","116965","20040923","null"},
            {"103903491","Raquel","Carrasco Rubio","252630","20100115","null"},
            {"90857492","Adriana","Moya Gimenez","145855","20090204","null"},
            {"106324818","Daniel","Alonso Gallardo","196155","20091016","null"},
            {"106930785","Samuel","Hidalgo Delgado","318915","20071121","null"},
            {"99953350","Diego","Serra Castro","329720","20090425","null"},
            {"95107315","Oliver","Fernandez Vega","239905","20000619","null"},
            {"40119440","Esther","Gomez Gimenez","273840","20130622","null"},
            {"109041218","Martina","Torres Gonzalez","170705","20050304","null"},
            {"40536389","Eva","Castro Ortega","260680","20130631","null"},
            {"50695460","Cristina","Cortes Caballero","104475","20080803","null"},
            {"43645033","Noelia","Rubio Ramirez","331295","20010729","null"},
            {"103126115","Sofia","Perez Garrido","119135","20160219","null"},
            {"95060130","Alejandra","Munoz Leon","167350","20020302","null"},
            {"61572915","Erika","Gallardo Ramirez","294410","20030131","20151030"},
            {"65841995","Sandra","Fuentes Mendez","283350","20141207","null"},
            {"76694995","Miriam","Nunez Marin","249295","20061209","null"},
            {"49963535","Patricia","Munoz Vargas","336100","20041221","null"},
            {"85972176","Ariadna","Lopez Velasco","90380","20090814","null"},
            {"106572104","Helena","Santos Navarro","211005","20040208","null"},
            {"39213928","Elsa","Torres Vega","197665","20010630","null"},
            {"68487080","Luna","Reyes Carmona","131130","20110808","null"},
            {"68493552","Valeria","Martin Martinez","144420","20080716","20110808"},
            {"79845305","Laura","Parra Torres","217920","20061027","null"},
            {"70312631","Andrea","Flores Nieto","137290","20120912","null"},
            {"71574679","Irene","Caballero Santiago","179745","20140524","null"},
            {"49592445","Sara","Ibanez Duran","295960","20121226","20140524"},
            {"49531445","Diego","Cortes Gil","161395","20121123","null"},
            {"71546779","Oliver","Casas Sanz","83075","20161112","null"},
            {"22015334","Esther","Gutierrez Navarro","173370","20160310","null"},
            {"108882311","Martina","Delgado Gimenez","262075","20011127","null"},
            {"37104679","Maria","Flores Nieto","179745","20110808","null"}};

    /**
     * Default constructor for test class TestNomina
     */
    public TestNomina()
    {
        Fecha fechaLiquidacion = new Fecha(13, 12, 2016);
        crearEmpresa();
        this.empresa.liquidarNomina(fechaLiquidacion);
    }

    private void crearEmpresa(){
        this.empresa = new Empresa();

        for(int i=0;i<datos.length;i++){
            if(i==0 || i==6 || i ==12 || i==18 || i == 24 || i==30 || i==36  || i==42 || i==48)
                this.empresa.agregarGerente(datos[i][0], datos[i][1], datos[i][2], Double.parseDouble(datos[i][3]),Integer.parseInt(datos[i][4]), "null".equals(datos[i][5]) ? 0:Integer.parseInt(datos[i][5]));
            else
                this.empresa.agregarOperario(datos[i][0], datos[i][1], datos[i][2], Double.parseDouble(datos[i][3]),Integer.parseInt(datos[i][4]), "null".equals(datos[i][5]) ? 0:Integer.parseInt(datos[i][5]));
        }
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

    @Test
    public void testEmpleado3A()
    {
        Empleado empleado = new Operario();
        Fecha fechaLiquidacion = new Fecha(13, 12, 2016);
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20030523);
        empleado.liquidarEmpleado(fechaLiquidacion);
        assertEquals(12428.8, empleado.getDescuentoSalud(), 0.1);
    }

    @Test
    public void testEmpleado3B()
    {
        Empleado empleado = new Operario();
        Fecha fechaLiquidacion = new Fecha(13, 12, 2016);
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20030523);
        empleado.liquidarEmpleado(fechaLiquidacion);
        assertEquals(12428.8, empleado.getDescuentoPension(), 0.1);
    }

    @Test
    public void testEmpleado3C()
    {
        Empleado empleado = new Operario();
        Fecha fechaLiquidacion = new Fecha(13, 12, 2016);
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20030523);
        empleado.liquidarEmpleado(fechaLiquidacion);
        assertEquals(25893.33, empleado.getProvisionCesantias(), 0.1);
    } 

    @Test
    public void testEmpleado3Di()
    {
        Empleado empleado = new Operario();
        Fecha fechaLiquidacion = new Fecha(13, 12, 2016);
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20030523);
        empleado.liquidarEmpleado(fechaLiquidacion);
        assertEquals(155360, empleado.getPrima(), 0.1);
    }

    @Test
    public void testEmpleado3Dii()
    {
        Empleado empleado = new Operario();
        Fecha fechaLiquidacion = new Fecha(13, 06, 2016);
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20030523);
        empleado.liquidarEmpleado(fechaLiquidacion);
        assertEquals(155360, empleado.getPrima(), 0.1);
    }

    @Test
    public void testEmpleado3Diiia()
    {
        Empleado empleado = new Operario();
        Fecha [] fechas = {
                new Fecha(13, 05, 2006),
                new Fecha(13, 05, 2007),
                new Fecha(13, 05, 2008),
                new Fecha(13, 05, 2009),
                new Fecha(13, 05, 2010)
            };
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20050523);
        for(int i=0;i<fechas.length;i++){
            
            empleado.liquidarEmpleado(fechas[i]);
            
            assertEquals(15536*(i+1), empleado.getPrima(), 0.1);
        }
    }

    @Test
    public void testEmpleado3Diiib()
    {
        Empleado empleado = new Operario();
        Fecha [] fechas = {
                new Fecha(13, 05, 2011),
                new Fecha(13, 05, 2012),
                new Fecha(13, 05, 2016),
                new Fecha(13, 05, 2026),
                new Fecha(13, 05, 2036)
            };
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20050523);
        for(int i=0;i<fechas.length;i++){
            empleado.liquidarEmpleado(fechas[i]);
            assertEquals(93216, empleado.getPrima(), 0.1);
        }
    }

    @Test
    public void testEmpleado3D1()
    {
        Empleado empleado = new Operario();
        Fecha [] fechas1 = {
                new Fecha(13, 06, 2006),
                new Fecha(13, 06, 2007),
                new Fecha(13, 06, 2008),
                new Fecha(13, 06, 2009),
                new Fecha(13, 06, 2010)
            };
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20050623);
        for(int i=0;i<fechas1.length;i++){
           
            empleado.liquidarEmpleado(fechas1[i]);
            assertEquals(155360 + 15536*(i+1), empleado.getPrima(), 0.1);
        }
    }

    @Test
    public void testEmpleado3D2()
    {
        Empleado empleado = new Operario();
        Fecha [] fechas2 = {
                new Fecha(13, 12, 2011),
                new Fecha(13, 12, 2012),
                new Fecha(13, 12, 2016),
                new Fecha(13, 12, 2026),
                new Fecha(13, 12, 2036)
            };
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20051223);
        for(int i=0;i<fechas2.length;i++){
            empleado.liquidarEmpleado(fechas2[i]);
            assertEquals(155360 + 93216, empleado.getPrima(), 0.1);
        }
    }

    @Test
    public void testEmpleado3E1()
    {
        Empleado empleado = new Operario();
        Fecha fechaLiquidacion = new Fecha(13, 11, 2016);
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20030523);
        empleado.liquidarEmpleado(fechaLiquidacion);
        assertEquals(310720, empleado.getIngresos(), 0.1);
    }

    @Test
    public void testEmpleado3E2()
    {
        Empleado empleado = new Operario();
        Fecha fechaLiquidacion = new Fecha(13, 12, 2016);
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20030523);
        empleado.liquidarEmpleado(fechaLiquidacion);
        assertEquals(310720 + 155360, empleado.getIngresos(), 0.1);
    }

    @Test
    public void testEmpleado3E3()
    {
        Empleado empleado = new Operario();
        Fecha fechaLiquidacion = new Fecha(13, 06, 2016);
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20030523);
        empleado.liquidarEmpleado(fechaLiquidacion);
        assertEquals(310720 + 155360, empleado.getIngresos(), 0.1);
    }    

    @Test
    public void testEmpleado3E4()
    {
        Empleado empleado = new Operario();
        Fecha fechaLiquidacion = new Fecha(13, 06, 2004);
        empleado.setSalarioBase(310720);
        Fecha [] fechas1 = {
                new Fecha(13, 06, 2006),
                new Fecha(13, 06, 2007),
                new Fecha(13, 06, 2008),
                new Fecha(13, 06, 2009),
                new Fecha(13, 06, 2010)
            };
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20050623);
        for(int i=0;i<fechas1.length;i++){
            empleado.liquidarEmpleado(fechas1[i]);
            assertEquals(310720 + 155360 + 15536*(i+1), empleado.getIngresos(), 0.1);
        }
    }

    @Test
    public void testEmpleado3E5()
    {
        Empleado empleado = new Operario();
        Fecha fechaLiquidacion = new Fecha(13, 12, 2004);
        empleado.setSalarioBase(310720);
        Fecha [] fechas2 = {
                new Fecha(13, 12, 2011),
                new Fecha(13, 12, 2012),
                new Fecha(13, 12, 2016),
                new Fecha(13, 12, 2026),
                new Fecha(13, 12, 2036)
            };
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20051223);
        for(int i=0;i<fechas2.length;i++){
            empleado.liquidarEmpleado(fechas2[i]);
            assertEquals(310720 + 155360 + 93216, empleado.getIngresos(), 0.1);
        }
    }

    @Test
    public void testEmpleado3F()
    {
        Empleado empleado = new Operario();
        Fecha fechaLiquidacion = new Fecha(13, 06, 2016);
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20030523);
        empleado.liquidarEmpleado(fechaLiquidacion);
        assertEquals(12428.8*2, empleado.getDescuentos(), 0.1);
    }

    @Test
    public void testEmpleado3G1()
    {
        Empleado empleado = new Operario();
        Fecha fechaLiquidacion = new Fecha(13, 11, 2016);
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20030523);
        empleado.liquidarEmpleado(fechaLiquidacion);
        assertEquals(310720 - 12428.8*2, empleado.getTotalAPagar(), 0.1);
    }

    @Test
    public void testEmpleado3G2()
    {
        Empleado empleado = new Operario();
        Fecha fechaLiquidacion = new Fecha(13, 12, 2016);
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20030523);
        empleado.liquidarEmpleado(fechaLiquidacion);
        assertEquals(310720 + 155360 - 12428.8*2, empleado.getTotalAPagar(), 0.1);
    }

    @Test
    public void testEmpleado3G3()
    {
        Empleado empleado = new Operario();
        Fecha fechaLiquidacion = new Fecha(13, 06, 2016);
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20030523);
        empleado.liquidarEmpleado(fechaLiquidacion);
        assertEquals(310720 + 155360 - 12428.8*2, empleado.getTotalAPagar(), 0.1);
    }    

    @Test
    public void testEmpleado3G4()
    {
        Empleado empleado = new Operario();
        Fecha fechaLiquidacion = new Fecha(13, 06, 2004);
        empleado.setSalarioBase(310720);
        Fecha [] fechas1 = {
                new Fecha(13, 06, 2006),
                new Fecha(13, 06, 2007),
                new Fecha(13, 06, 2008),
                new Fecha(13, 06, 2009),
                new Fecha(13, 06, 2010)
            };
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20050623);
        for(int i=0;i<fechas1.length;i++){
            empleado.liquidarEmpleado(fechas1[i]);
            assertEquals(310720 + 155360 + 15536*(i+1) - 12428.8*2, empleado.getTotalAPagar(), 0.1);
        }
    }

    @Test
    public void testEmpleado3G5()
    {
        Empleado empleado = new Operario();
        Fecha fechaLiquidacion = new Fecha(13, 12, 2004);
        empleado.setSalarioBase(310720);
        Fecha [] fechas2 = {
                new Fecha(13, 12, 2011),
                new Fecha(13, 12, 2012),
                new Fecha(13, 12, 2016),
                new Fecha(13, 12, 2026),
                new Fecha(13, 12, 2036)
            };
        empleado.setSalarioBase(310720);
        empleado.setFechaIngreso(20051223);
        for(int i=0;i<fechas2.length;i++){
            empleado.liquidarEmpleado(fechas2[i]);
            assertEquals(310720 + 155360 + 93216 - 12428.8*2, empleado.getTotalAPagar(), 0.1);
        }
    }    

    @Test
    public void testEmpleado3Hiii()
    {
        Empleado empleado = new Operario();
        empleado.setFechaIngreso(20150230);
        assertEquals(false, empleado.esEmpleadoValido());
        empleado.setFechaIngreso(201060228);
        assertEquals(true, empleado.esEmpleadoValido());
        empleado.setFechaIngreso(20160132);
        assertEquals(false, empleado.esEmpleadoValido());
        empleado.setFechaIngreso(20060131);
        empleado.setFechaRetiro(20160132);
        assertEquals(false, empleado.esEmpleadoValido());
        empleado.setFechaIngreso(20060131);
        empleado.setFechaRetiro(20160131);
        assertEquals(true, empleado.esEmpleadoValido());
    }

    @Test
    public void testEmpleado3Hii()
    {
        Empleado empleado = new Operario();
        empleado.setFechaIngreso(20150230);
        assertEquals(true, empleado.esEmpleadoActivo());

        empleado.setFechaIngreso(20060132);
        empleado.setFechaRetiro(20160133);
        assertEquals(false, empleado.esEmpleadoActivo());
    }

    @Test
    public void testEmpleado3Hi()
    {
        Empleado empleado = new Operario();
        Fecha fecha1 = new Fecha(30,1,2016);
        Fecha fecha2 = new Fecha(25,12,2016);

        empleado.setFechaIngreso(20150230);
        assertEquals(false, empleado.esEmpleadoLiquidable(fecha1));

        empleado.setFechaIngreso(20060131);
        empleado.setFechaRetiro(20160131);
        assertEquals(false, empleado.esEmpleadoLiquidable(fecha1));

        empleado.setFechaIngreso(20160131);
        assertEquals(false, empleado.esEmpleadoLiquidable(fecha1));

        empleado = new Operario();
        empleado.setFechaIngreso(20161130);
        assertEquals(true, empleado.esEmpleadoLiquidable(fecha2));
    }    

    @Test
    public void testEmpresa4A()
    {
        assertEquals(751906.6, empresa.getAporteSalud(), 0.1);
    }

    @Test
    public void testEmpresa4B()
    {
        assertEquals(1061515.2, empresa.getAportePensiones(), 0.1);
    }

    @Test
    public void testEmpresa4C()
    {
        assertEquals(1105745.0, empresa.getTotalConsignarSalud(), 0.1);
    }

    @Test
    public void testEmpresa4D()
    {
        assertEquals(1415353.59, empresa.getTotalConsignarPensiones(), 0.1);
    }

    @Test
    public void testEmpresa4E()
    {
        assertEquals(737163.33, empresa.getTotalProvisionCesantias(), 0.1);
    }

    @Test
    public void testEmpresa4F()
    {
        assertEquals(4749702, empresa.getTotalPrimas(), 0.1);
    }

    @Test
    public void testEmpresa4G()
    {
        assertEquals(12887985.2, empresa.getTotalPagarEmpleados(), 0.1);
    }

    @Test
    public void testEmpresa4H()
    {
        assertEquals(16146247.13, empresa.getCostoNomina(), 0.1);
    }    

    @Test
    public void testEmpresa4I()
    {
        assertEquals(50, empresa.getTotalEmpleados());
    }

    @Test
    public void testEmpresa4J()
    {
        assertEquals(46, empresa.getTotalEmpleadosValidos());
    }

    @Test
    public void testEmpresa4K()
    {
        assertEquals(45, empresa.getTotalEmpleadosActivos());
    }

    @Test
    public void testEmpresa4L()
    {
        assertEquals(42, empresa.getTotalEmpleadosLiquidables());
    }

    @Test
    public void testEmpresaFull1(){
        Fecha fechaLiquidacion = new Fecha(13, 6, 2016);
        crearEmpresa();
        System.out.println("Full");//20090229
        this.empresa.liquidarNomina(fechaLiquidacion);
       System.out.println("Full2");
        assertEquals(734241.05, empresa.getAporteSalud(), 0.1);
        assertEquals(1036575.6, empresa.getAportePensiones(), 0.1);
        assertEquals(1079766.25, empresa.getTotalConsignarSalud(), 0.1);
        assertEquals(1382100.79, empresa.getTotalConsignarPensiones(), 0.1);
        assertEquals(719844.16, empresa.getTotalProvisionCesantias(), 0.1);
        assertEquals(4652441, empresa.getTotalPrimas(), 0.1);
        assertEquals(12599520.6, empresa.getTotalPagarEmpleados(), 0.1);
        assertEquals(15781231.8166, empresa.getCostoNomina(), 0.1);
        assertEquals(50, empresa.getTotalEmpleados());
        assertEquals(46, empresa.getTotalEmpleadosValidos());
        assertEquals(45, empresa.getTotalEmpleadosActivos());
        assertEquals(40, empresa.getTotalEmpleadosLiquidables());
    }

    @Test
    public void testEmpresaFull2(){
        Fecha fechaLiquidacion = new Fecha(13, 1, 2016);
        crearEmpresa();
        this.empresa.liquidarNomina(fechaLiquidacion);
        assertEquals(709378.125, empresa.getAporteSalud(), 0.1);
        assertEquals(1001475, empresa.getAportePensiones(), 0.1);
        assertEquals(1043203.125, empresa.getTotalConsignarSalud(), 0.1);
        assertEquals(1335300, empresa.getTotalConsignarPensiones(), 0.1);
        assertEquals(695468.75, empresa.getTotalProvisionCesantias(), 0.1);
        assertEquals(75789, empresa.getTotalPrimas(), 0.1);
        assertEquals(7753764, empresa.getTotalPagarEmpleados(), 0.1);
        assertEquals(10827735.875, empresa.getCostoNomina(), 0.1);
        assertEquals(50, empresa.getTotalEmpleados());
        assertEquals(46, empresa.getTotalEmpleadosValidos());
        assertEquals(45, empresa.getTotalEmpleadosActivos());
        assertEquals(38, empresa.getTotalEmpleadosLiquidables());
    }

    @Test
    public void testEmpresaFull3(){
        Fecha fechaLiquidacion = new Fecha(13, 7, 2016);
        crearEmpresa();
        this.empresa.liquidarNomina(fechaLiquidacion);
        assertEquals(734241.05, empresa.getAporteSalud(), 0.1);
        assertEquals(1036575.6, empresa.getAportePensiones(), 0.1);
        assertEquals(1079766.25, empresa.getTotalConsignarSalud(), 0.1);
        assertEquals(1382100.79, empresa.getTotalConsignarPensiones(), 0.1);
        assertEquals(719844.16, empresa.getTotalProvisionCesantias(), 0.1);
        assertEquals(99388.5, empresa.getTotalPrimas(), 0.1);
        assertEquals(8046468.10, empresa.getTotalPagarEmpleados(), 0.1);
        assertEquals(11228179.316, empresa.getCostoNomina(), 0.1);
        assertEquals(50, empresa.getTotalEmpleados());
        assertEquals(46, empresa.getTotalEmpleadosValidos());
        assertEquals(45, empresa.getTotalEmpleadosActivos());
        assertEquals(40, empresa.getTotalEmpleadosLiquidables());
    }

    @Test
    public void testConstructorFecha(){
        Fecha f = new Fecha(20171206);
        assertEquals(2017, f.getAnio());
        assertEquals(12, f.getMes());
        assertEquals(6, f.getDia());
    }

    @Test
    public void testConstructorEmpleado(){
        Operario o = new Operario("1234567", "Juan", "Perez", 1523100, 20171206, 0);
        Fecha fi = o.getFechaIngreso();
        Fecha fr = o.getFechaRetiro();

        assertEquals("1234567", o.getCedula());
        assertEquals("Juan", o.getNombres());
        assertEquals("Perez", o.getApellidos());
        assertEquals(1523100, o.getSalarioBase(), 0.1);
        assertNotNull(fi);
        assertNull(fr);

        o = new Operario("1234567", "Juan", "Perez", 1523100, 20101206, 20170216);
        fi = o.getFechaIngreso();
        fr = o.getFechaRetiro();

        assertEquals("1234567", o.getCedula());
        assertEquals("Juan", o.getNombres());
        assertEquals("Perez", o.getApellidos());
        assertEquals(1523100, o.getSalarioBase(), 0.1);
        assertNotNull(fi);
        assertNotNull(fr);

        Gerente g = new Gerente("7123456", "Pedro", "Perez", 4523100, 20121206, 0);
        fi = g.getFechaIngreso();
        fr = g.getFechaRetiro();
        assertEquals("7123456", g.getCedula());
        assertEquals("Pedro", g.getNombres());
        assertEquals("Perez", g.getApellidos());
        assertEquals(4523100, g.getSalarioBase(), 0.1);
        assertNotNull(fi);
        assertNull(fr);      

        g = new Gerente("7123456", "Pedro", "Perez", 4523100, 20101206, 20100923);
        fi = g.getFechaIngreso();
        fr = g.getFechaRetiro();
        assertEquals("7123456", g.getCedula());
        assertEquals("Pedro", g.getNombres());
        assertEquals("Perez", g.getApellidos());
        assertEquals(4523100, g.getSalarioBase(), 0.1);
        assertNotNull(fi);
        assertNotNull(fr);        
    }   

    @Test
    public void testConstructorEmpresa(){
        Empresa e = new Empresa();
        assertNotNull(e.getEmpleados());
        assertEquals(0, e.getTotalEmpleados());
        assertEquals(0, e.getAporteSalud(), 0.1);
        assertEquals(0, e.getAportePensiones(), 0.1);
        assertEquals(0, e.getTotalConsignarSalud(), 0.1);
        assertEquals(0, e.getTotalConsignarPensiones(), 0.1);
        assertEquals(0, e.getTotalProvisionCesantias(), 0.1);
        assertEquals(0, e.getTotalPrimas(), 0.1);
        assertEquals(0, e.getTotalPagarEmpleados(), 0.1);
        assertEquals(0, e.getCostoNomina(), 0.1);
        assertEquals(0, e.getTotalEmpleadosValidos());
        assertEquals(0, e.getTotalEmpleadosActivos());
        assertEquals(0, e.getTotalEmpleadosLiquidables());
    }

    @Test
    public void testAgregarOperario()
    {
        Exception ex = null;
        Empresa e = new Empresa();
        Operario o = null;
        e.agregarOperario("1234567", "Juan", "Perez", 1523100, 20171206, 0);
        assertEquals(1, e.getTotalEmpleados());
        try{
            o = (Operario)e.getEmpleados().get(0);
        }
        catch(Exception exc){
            ex = exc;
        }
        assertNull(ex);
        assertNotNull(o);
        assertEquals("1234567", o.getCedula());
        assertEquals("Juan", o.getNombres());
        assertEquals("Perez", o.getApellidos());
        assertEquals(1523100, o.getSalarioBase(), 0.1);
    }

    @Test
    public void testAgregarGerente()
    {
        Exception ex = null;
        Empresa e = new Empresa();
        Gerente g = null;
        e.agregarGerente("2345671", "Pedro", "Perez", 4523100, 20171206, 0);
        assertEquals(1, e.getTotalEmpleados());
        try{
            g = (Gerente)e.getEmpleados().get(0);
        }
        catch(Exception exc){
            ex = exc;
        }
        assertNull(ex);
        assertNotNull(g);
        assertEquals("2345671", g.getCedula());
        assertEquals("Pedro", g.getNombres());
        assertEquals("Perez", g.getApellidos());
        assertEquals(4523100, g.getSalarioBase(), 0.1);
    }

    @Test
    public void testAgregarEmpleado()
    {
        Exception ex = null;
        Empresa e = new Empresa();
        Operario o = new Operario("1234567", "Juan", "Perez", 1523100, 20171206, 0);
        Gerente g = new Gerente("7123456", "Pedro", "Perez", 4523100, 20121206, 0);

        e.agregarEmpleado(o);
        assertEquals(1, e.getTotalEmpleados());        
        try{
            o = (Operario)e.getEmpleados().get(0);
        }
        catch(Exception exc){
            ex = exc;
        }
        assertNull(ex);
        assertNotNull(o);

        e.agregarEmpleado(g);
        assertEquals(2, e.getTotalEmpleados());
        try{
            g = (Gerente)e.getEmpleados().get(1);
        }
        catch(Exception exc){
            ex = exc;
        }
        assertNull(ex);
        assertNotNull(g);

    }

    @Test
    public void testProvisionRiesgo()
    {
        Operario operario1 = new Operario();
        operario1.setSalarioBase(785000);
        operario1.setFechaIngreso(20151201);
        Fecha fecha1 = new Fecha(20171221);
        assertEquals(29830, operario1.getProvisionRiesgos(fecha1), 0.1);

        Gerente gerente1 = new Gerente();
        gerente1.setSalarioBase(785000);
        gerente1.setFechaIngreso(20151201);
        assertEquals(17898, gerente1.getProvisionRiesgos(fecha1), 0.1);
    }

    public static void main(String[] arg)
    {
        TestNomina n = new TestNomina();
        double grade = 0;

        try {
            n.testEmpleado3A();
            System.out.println(formatOutput("testEmpleado3A", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3A", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3A", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3B();
            System.out.println(formatOutput("testEmpleado3B", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3B", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3B", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3C();
            System.out.println(formatOutput("testEmpleado3C", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3C", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3C", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3Di();
            System.out.println(formatOutput("testEmpleado3Di", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3Di", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3Di", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3Dii();
            System.out.println(formatOutput("testEmpleado3Dii", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3Dii", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3Dii", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3Diiia();
            System.out.println(formatOutput("testEmpleado3Diiia", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3Diiia", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3Diiia", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3Diiib();
            System.out.println(formatOutput("testEmpleado3Diiib", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3Diiib", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3Diiib", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3D1();
            System.out.println(formatOutput("testEmpleado3D1", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3D1", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3D1", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3D2();
            System.out.println(formatOutput("testEmpleado3D2", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3D2", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3D2", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3E1();
            System.out.println(formatOutput("testEmpleado3E1", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3E1", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3E1", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3E2();
            System.out.println(formatOutput("testEmpleado3E2", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3E2", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3E2", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3E3();
            System.out.println(formatOutput("testEmpleado3E3", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3E3", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3E3", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3E4();
            System.out.println(formatOutput("testEmpleado3E4", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3E4", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3E4", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3E5();
            System.out.println(formatOutput("testEmpleado3E5", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3E5", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3E5", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3F();
            System.out.println(formatOutput("testEmpleado3F", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3F", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3F", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3G1();
            System.out.println(formatOutput("testEmpleado3G1", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3G1", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3G1", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3G2();
            System.out.println(formatOutput("testEmpleado3G2", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3G2", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3G2", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3G3();
            System.out.println(formatOutput("testEmpleado3G3", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3G3", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3G3", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3G4();
            System.out.println(formatOutput("testEmpleado3G4", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3G4", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3G4", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3G5();
            System.out.println(formatOutput("testEmpleado3G5", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3G5", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3G5", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3Hiii();
            System.out.println(formatOutput("testEmpleado3Hiii", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3Hiii", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3Hiii", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3Hii();
            System.out.println(formatOutput("testEmpleado3Hii", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3Hii", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3Hii", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpleado3Hi();
            System.out.println(formatOutput("testEmpleado3Hi", "0.5", null));
            grade += 0.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpleado3Hi", "0.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpleado3Hi", "0.5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpresa4A();
            System.out.println(formatOutput("testEmpresa4A", "4", null));
            grade += 4;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpresa4A", "4", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpresa4A", "4", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpresa4B();
            System.out.println(formatOutput("testEmpresa4B", "4", null));
            grade += 4;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpresa4B", "4", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpresa4B", "4", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpresa4C();
            System.out.println(formatOutput("testEmpresa4C", "4", null));
            grade += 4;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpresa4C", "4", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpresa4C", "4", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpresa4D();
            System.out.println(formatOutput("testEmpresa4D", "4", null));
            grade += 4;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpresa4D", "4", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpresa4D", "4", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpresa4E();
            System.out.println(formatOutput("testEmpresa4E", "4", null));
            grade += 4;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpresa4E", "4", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpresa4E", "4", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpresa4F();
            System.out.println(formatOutput("testEmpresa4F", "4", null));
            grade += 4;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpresa4F", "4", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpresa4F", "4", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpresa4G();
            System.out.println(formatOutput("testEmpresa4G", "4", null));
            grade += 4;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpresa4G", "4", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpresa4G", "4", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpresa4H();
            System.out.println(formatOutput("testEmpresa4H", "4", null));
            grade += 4;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpresa4H", "4", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpresa4H", "4", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpresa4I();
            System.out.println(formatOutput("testEmpresa4I", "4", null));
            grade += 4;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpresa4I", "4", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpresa4I", "4", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpresa4J();
            System.out.println(formatOutput("testEmpresa4J", "4", null));
            grade += 4;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpresa4J", "4", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpresa4J", "4", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpresa4K();
            System.out.println(formatOutput("testEmpresa4K", "4", null));
            grade += 4;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpresa4K", "4", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpresa4K", "4", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpresa4L();
            System.out.println(formatOutput("testEmpresa4L", "4", null));
            grade += 4;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpresa4L", "4", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpresa4L", "4", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpresaFull1();
            System.out.println(formatOutput("testEmpresaFull1", "5", null));
            grade += 5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpresaFull1", "5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpresaFull1", "5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpresaFull2();
            System.out.println(formatOutput("testEmpresaFull2", "5", null));
            grade += 5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpresaFull2", "5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpresaFull2", "5", new AssertionError(e.getMessage())));
        }
        try {
            n.testEmpresaFull3();
            System.out.println(formatOutput("testEmpresaFull3", "5", null));
            grade += 5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testEmpresaFull3", "5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testEmpresaFull3", "5", new AssertionError(e.getMessage())));
        }
        try {
            n.testConstructorFecha();
            System.out.println(formatOutput("testConstructorFecha", "3", null));
            grade += 3;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testConstructorFecha", "3", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testConstructorFecha", "3", new AssertionError(e.getMessage())));
        }
        try {
            n.testConstructorEmpleado();
            System.out.println(formatOutput("testConstructorEmpleado", "3", null));
            grade += 3;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testConstructorEmpleado", "3", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testConstructorEmpleado", "3", new AssertionError(e.getMessage())));
        }
        try {
            n.testConstructorEmpresa();
            System.out.println(formatOutput("testConstructorEmpresa", "3", null));
            grade += 3;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testConstructorEmpresa", "3", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testConstructorEmpresa", "3", new AssertionError(e.getMessage())));
        }
        try {
            n.testAgregarOperario();
            System.out.println(formatOutput("testAgregarOperario", "4", null));
            grade += 4;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testAgregarOperario", "4", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testAgregarOperario", "4", new AssertionError(e.getMessage())));
        }
        try {
            n.testAgregarGerente();
            System.out.println(formatOutput("testAgregarGerente", "4", null));
            grade += 4;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testAgregarGerente", "4", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testAgregarGerente", "4", new AssertionError(e.getMessage())));
        }
        try {
            n.testAgregarEmpleado();
            System.out.println(formatOutput("testAgregarEmpleado", "4", null));
            grade += 4;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testAgregarEmpleado", "4", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testAgregarEmpleado", "4", new AssertionError(e.getMessage())));
        }
        try {
            n.testProvisionRiesgo();
            System.out.println(formatOutput("testProvisionRiesgo", "4.5", null));
            grade += 4.5;
        } catch (AssertionError e) {
            System.out.println(formatOutput("testProvisionRiesgo", "4.5", e));
        } catch (Exception e) {
            System.out.println(formatOutput("testProvisionRiesgo", "4.5", new AssertionError(e.getMessage())));
        }

        System.out.println("Grade :=>> "+ ((int)grade));
    }

    private static String formatOutput(String testName, String value, AssertionError e) {
        StringBuilder sb = new StringBuilder();
        Formatter f = new Formatter(sb, Locale.getDefault());
        String grade = (e == null ? value : "0");
        f.format("Comment :=>> %s: %s. %s marks\n", testName, (e == null ? "success" : "failure"), grade);
        if (e != null) {
            f.format("********************\n%s\n", e.getMessage());
        }
        return sb.toString();
    }

}

