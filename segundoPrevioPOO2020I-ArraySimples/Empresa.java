/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miljeveco
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
    protected Empleado[] empleados;
    private int totalEmpleados;

    public Empresa(){
        //COMPLETE
        empleados= new Empleado[50];
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
        int totalEmpleadosLiquidables = 0;
        double descuentosSalud = 0;
        double salarioBaseEmpleados = 0;
        double descuentoPensiones = 0;
        double totalCesantias = 0;
        double totalConceptoSalud = 0;
        double totalPagoEmpleados = 0;
        double totalPrimas = 0;
        
        for(int i=0;i<totalEmpleados;i++){
        if(empleados[i].esEmpleadoLiquidable(fechaLiquidacion)){
        empleados[i].liquidarEmpleado(fechaLiquidacion);
        totalEmpleadosLiquidables++;
        salarioBaseEmpleados += empleados[i].getSalarioBase();
        descuentosSalud += empleados[i].getDescuentoSalud();
        descuentoPensiones += empleados[i].getDescuentoPension();
        totalCesantias += empleados[i].getProvisionCesantias();
        totalPagoEmpleados += empleados[i].getTotalAPagar();
        totalPrimas += empleados[i].getPrima();
        }
        }
        this.aporteSalud = salarioBaseEmpleados*0.085;
        this.aportePensiones = salarioBaseEmpleados*0.12;
        this.totalConsignarSalud = descuentosSalud + this.aporteSalud;
        this.totalConsignarPensiones = descuentoPensiones + this.aportePensiones;
        this.totalProvisionCesantias = totalCesantias;
        this.totalPrimas = totalPrimas;
        this.totalEmpleadosLiquidables = totalEmpleadosLiquidables;
        this.totalPagarEmpleados = totalPagoEmpleados;
    }

    public double getCostoNomina() {
          double costoNomina = this.totalConsignarPensiones + this.totalConsignarSalud + this.totalProvisionCesantias +this.totalPagarEmpleados;
        return costoNomina;//COMPLETE
    }

    public int getTotalEmpleados() {
        return totalEmpleados;
    }

    public int getTotalEmpleadosActivos() {
        int total=0;
        for(int i=0;i<totalEmpleados;i++){
            if(empleados[i].esEmpleadoActivo())total++;
        }
        return total;//COMPLETE
    }

    public int getTotalEmpleadosValidos() {
       int total=0;
        for(int i=0;i<totalEmpleados;i++){
            if(empleados[i].esEmpleadoValido())total++;
        }
        return total;
    }    

    public int getTotalEmpleadosActivosYValidos() {
        //COMPLETE
        int total=0;
        for(Empleado x:empleados){
            if(x.esEmpleadoActivo()&&x.esEmpleadoValido())total++;
        }
        return total;
    }

    /**Metodo de acceso a la propiedad empleados*/
    public Empleado[] getEmpleados(){
        return this.empleados;
    }//end method getEmpleados

    /**Metodo de modificación a la propiedad empleados*/
    public void setEmpleados(Empleado[] empleados){
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
              Gerente ger = new Gerente(cedula,  nombres,  apellidos,  salarioBase, fechaIngreso, fechaRetiro);
        for(int i=0; i<empleados.length; i++){
        if(empleados[i] == null){
        empleados[i] = ger;
        break;
        }
        }
        this.totalEmpleados++;
    }

    /**
     * Agrega un Operario a la lista de empleados de la empresa
     */
    public void agregarOperario(String cedula, String nombres, String apellidos, double salarioBase, int fechaIngreso, int fechaRetiro){
         Operario oper = new Operario(cedula,  nombres,  apellidos,  salarioBase, fechaIngreso, fechaRetiro);
        for(int i=0; i<empleados.length; i++){
        if(empleados[i] == null){
        empleados[i] = oper;
        break;
        }
        }
        this.totalEmpleados++;
    }    

    /**
     * Agrega un Empleado a la lista de empleados de la empresa
     */
    public void agregarEmpleado(Empleado e){
        //COMPLETE
        //COMPLETE
        /*
        if(totalEmpleados==empleados.length){
            int i=0;
            Empleado nueva[]= new Empleado[empleados.length*2];
            for(Empleado x: empleados){
                nueva[]=
            
            }
        }*/
        for(int i=0; i<empleados.length; i++){
        if(empleados[i] == null){
        empleados[i] = e;
        
        break;
        }
        }
        this.totalEmpleados++;
        
    }
}