import java.util.ArrayList;
 
/**
 *
 * @author Realizado: Jeison Ferrer 1152004 Y Sebastian Martinez 1151990 (https://github.com/joferrer/ParcialPoo2)
 */
public class Empresa {

    protected double aporteSalud;
    protected double aportePensiones;
    protected double totalConsignarSalud;
    protected double totalConsignarPensiones;
    protected double totalProvisionCesantias;
    protected double totalPrimas;
    protected double totalPagarEmpleados;    
    protected int totalEmpleadosLiquidables;
    protected ArrayList<Empleado> empleados;
    private int totalEmpleados;

    public Empresa(){
        //COMPLETE
        empleados= new ArrayList();
    }

    /**
     * @return the aporteSalud
     */
    public double getAporteSalud() {
        return aporteSalud;
    }

    /**
     * @param aporteSalud the aporteSalud to set
     */
    public void setAporteSalud(double aporteSalud) {
        this.aporteSalud = aporteSalud;
    }

    /**
     * @return the aportePensiones
     */
    public double getAportePensiones() {
        return aportePensiones;
    }

    /**
     * @param aportePensiones the aportePensiones to set
     */
    public void setAportePensiones(double aportePensiones) {
        this.aportePensiones = aportePensiones;
    }

    /**
     * @return the totalConsignarSalud
     */
    public double getTotalConsignarSalud() {
        return totalConsignarSalud;
    }

    /**
     * @param totalConsignarSalud the totalConsignarSalud to set
     */
    public void setTotalConsignarSalud(double totalConsignarSalud) {
        this.totalConsignarSalud = totalConsignarSalud;
    }

    /**
     * @return the totalConsignarPensiones
     */
    public double getTotalConsignarPensiones() {
        return totalConsignarPensiones;
    }

    /**
     * @param totalConsignarPensiones the totalConsignarPensiones to set
     */
    public void setTotalConsignarPensiones(double totalConsignarPensiones) {
        this.totalConsignarPensiones = totalConsignarPensiones;
    }

    /**
     * @return the totalProvisionCesantias
     */
    public double getTotalProvisionCesantias() {
        return totalProvisionCesantias;
    }

    /**
     * @param totalProvisionCesantias the totalProvisionCesantias to set
     */
    public void setTotalProvisionCesantias(double totalProvisionCesantias) {
        this.totalProvisionCesantias = totalProvisionCesantias;
    }

    /**
     * @return the totalPrimas
     */
    public double getTotalPrimas() {
        return totalPrimas;
    }

    /**
     * @param totalPrimas the totalPrimas to set
     */
    public void setTotalPrimas(double totalPrimas) {
        this.totalPrimas = totalPrimas;
    }

    /**
     * @return the totalPagarEmpleados
     */
    public double getTotalPagarEmpleados() {
        return totalPagarEmpleados;
    }

    /**
     * @param totalPagarEmpleados the totalPagarEmpleados to set
     */
    public void setTotalPagarEmpleados(double totalPagarEmpleados) {
        this.totalPagarEmpleados = totalPagarEmpleados;
    }

    /**
     * Este metodo llama el metodo del mismo nombre en la clase Empleado, dentro de un ciclo for por cada 
     * objeto empleado dentro del arreglo o ArrayList
     */    
    public void liquidarNomina(Fecha fechaLiquidacion) {
        //COMPLETE
        int totalEmpleadosLiquidables=0;
        double salarioBaseEmpleados=0;
         double costoNomina=0;
         double descuentoSalud=0;
         double descuentoPenciones=0;
         double cesantias=0;
         double primas=0;
        for(Empleado x : empleados){
            if(x.esEmpleadoLiquidable(fechaLiquidacion)){
            x.liquidarEmpleado(fechaLiquidacion);
            totalEmpleadosLiquidables++;
            salarioBaseEmpleados+=x.getSalarioBase();
            descuentoSalud+=x.getDescuentoSalud();
            descuentoPenciones+=x.getDescuentoPension();
            cesantias+=x.getProvisionCesantias();
            primas+=x.getPrima();   
            costoNomina+=x.getTotalAPagar();
            System.out.println("C:"+x.getCedula()+"SB:"+x.getSalarioBase()+":"+salarioBaseEmpleados);
        }
        }
        this.aporteSalud=salarioBaseEmpleados*0.085;
        this.aportePensiones=salarioBaseEmpleados*0.12;
        
        this.totalConsignarSalud=this.aporteSalud+descuentoSalud;
        this.totalConsignarPensiones=this.aportePensiones+descuentoPenciones;
        this.totalProvisionCesantias=cesantias;
        this.totalPrimas=primas;
        this.totalEmpleadosLiquidables=totalEmpleadosLiquidables;
        this.totalPagarEmpleados=costoNomina;
       
    }

    public double getCostoNomina() {
       double costoNomina=this.totalConsignarPensiones+this.totalConsignarSalud+this.totalProvisionCesantias
       +this.totalPagarEmpleados;
        
        return costoNomina;//COMPLETE
    }

    public int getTotalEmpleados() {
        return totalEmpleados;
    }

    public int getTotalEmpleadosActivos() {
          int empleadosActivos = 0;
        for(int i=0; i<empleados.size();i++){
        if(empleados.get(i).esEmpleadoActivo())empleadosActivos++;
        }
        return empleadosActivos;//COMPLETE
    }

    public int getTotalEmpleadosValidos() {
          int empleadosValidos = 0;
        for(int i=0; i<empleados.size();i++){
        if(empleados.get(i).esEmpleadoValido())empleadosValidos++;
        }
        return empleadosValidos;//COMPLETE
    }    

    public int getTotalEmpleadosActivosYValidos() {
       int empleadosAyV = 0;
        for(int i=0; i<empleados.size();i++){
        if(empleados.get(i).esEmpleadoActivo() && empleados.get(i).esEmpleadoValido())empleadosAyV++;
    }
        return empleadosAyV;//COMPLETE
    }

    /**Metodo de acceso a la propiedad empleados*/
    public ArrayList<Empleado> getEmpleados(){
        return this.empleados;
    }//end method getEmpleados

    /**Metodo de modificación a la propiedad empleados*/
    public void setEmpleados(ArrayList<Empleado> empleados){
        this.empleados = empleados;
    }//end method setEmpleados

    /**Metodo de acceso a la propiedad totalEmpleadosLiquidables*/
    public int getTotalEmpleadosLiquidables(){
        return this.totalEmpleadosLiquidables;
    }//end method getTotalEmpleadosLiquidables

    /**Metodo de modificación a la propiedad totalEmpleadosLiquidables*/
    public void setTotalEmpleadosLiquidables(int totalEmpleadosLiquidables){
        this.totalEmpleadosLiquidables = totalEmpleadosLiquidables;
    }//end method setTotalEmpleadosLiquidables

    /**
     * Agrega un Gerente a la lista de empleados de la empresa
     */
    public void agregarGerente(String cedula, String nombres, String apellidos, double salarioBase, int fechaIngreso, int fechaRetiro){
        //COMPLETE
        Gerente op = new Gerente( cedula,  nombres,  apellidos,  salarioBase, fechaIngreso, fechaRetiro);
        empleados.add(op);
        this.totalEmpleados++;
    }

    /**
     * Agrega un Operario a la lista de empleados de la empresa
     */
    public void agregarOperario(String cedula, String nombres, String apellidos, double salarioBase, int fechaIngreso, int fechaRetiro){
        //COMPLETE
        Operario op = new Operario( cedula,  nombres,  apellidos,  salarioBase, fechaIngreso, fechaRetiro);
        empleados.add(op);
        this.totalEmpleados++;
    }    

    /**
     * Agrega un Empleado a la lista de empleados de la empresa
     */
    public void agregarEmpleado(Empleado e){
        //COMPLETE
        empleados.add(e);
        this.totalEmpleados++;
    }
}