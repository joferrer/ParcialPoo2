public abstract class Empleado {

    protected String cedula;
    protected String apellidos;
    protected String nombres;
    protected double salarioBase;
    protected double descuentoSalud;
    protected double descuentoPension;
    protected double provisionCesantias;
    protected double prima;
    protected double ingresos;
    protected double descuentos;
    protected double totalAPagar;
    protected Fecha fechaIngreso;
    protected Fecha fechaRetiro;

    /**
     * Constructor default
     */
    public Empleado() {
        //COMPLETE
    }

    /**
     * Constructor con parámetros. Recibe todos los datos del empleado
     */
    public Empleado(String cedula, String nombres, String apellidos, double salarioBase, int fechaIngreso, int fechaRetiro){
        //COMPLETE
        this.cedula= cedula;
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.salarioBase=salarioBase;
        this.fechaIngreso= new Fecha(fechaIngreso);
        if(fechaRetiro!=0)this.fechaRetiro=new Fecha(fechaRetiro);
        else this.fechaRetiro=null;

    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the salarioBase
     */
    public double getSalarioBase() {
        return salarioBase;
    }

    /**
     * @param salarioBase the salarioBase to set
     */
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    /**
     * @return the descuentoSalud
     */
    public double getDescuentoSalud() {
        return descuentoSalud;
    }

    /**
     * @param descuentoSalud the descuentoSalud to set
     */
    public void setDescuentoSalud(double descuentoSalud) {
        this.descuentoSalud = descuentoSalud;
    }

    /**
     * @return the descuentoPension
     */
    public double getDescuentoPension() {
        return descuentoPension;
    }

    /**
     * @param descuentoPension the descuentoPension to set
     */
    public void setDescuentoPension(double descuentoPension) {
        this.descuentoPension = descuentoPension;
    }

    /**
     * @return the provisionCesantias
     */
    public double getProvisionCesantias() {
        return provisionCesantias;
    }

    /**
     * @param provisionCesantias the provisionCesantias to set
     */
    public void setProvisionCesantias(double provisionCesantias) {
        this.provisionCesantias = provisionCesantias;
    }

    /**
     * @return the prima
     */
    public double getPrima() {
        return prima;
    }

    /**
     * @param prima the prima to set
     */
    public void setPrima(double prima) {
        this.prima = prima;
    }

    public void setFechaIngreso(int fecha) {
        this.fechaIngreso = new Fecha(fecha);
    }

    public void setFechaRetiro(int fecha) {
        this.fechaRetiro = new Fecha(fecha);
    }

    /**
     * En este metodo se liquida a un unico empleado, de manera que desde la clase empresa
     * se llame a este metodo por cada empleado dentro del array o ArrayList
     */
    public void liquidarEmpleado(Fecha fechaLiquidacion) {
        //COMPLETE
        double prima=0; 
        boolean antiguo=false;
        double aniosEnServicio=fechaLiquidacion.getAnio()-this.fechaIngreso.getAnio();
        if(aniosEnServicio>0&&
        fechaLiquidacion.getMes()>this.fechaIngreso.getMes())
            aniosEnServicio--;      
        
        //System.out.println("A:"+aniosEnServicio+":"+esEmpleadoLiquidable(fechaLiquidacion));
        if(esEmpleadoLiquidable(fechaLiquidacion)){
            this.descuentoSalud=salarioBase*0.04;
            this.descuentoPension=salarioBase*0.04;
            this.provisionCesantias=salarioBase/12;
            if(fechaLiquidacion.getMes()==12||fechaLiquidacion.getMes()==6)
                prima+=this.salarioBase*0.5;    
            if(aniosEnServicio<6&&
            fechaLiquidacion.getMes()==this.fechaIngreso.getMes())prima+=((aniosEnServicio*5)/100)*this.salarioBase;
            if(aniosEnServicio>=6&&fechaLiquidacion.getMes()==this.fechaIngreso.getMes()) prima+=this.salarioBase*0.3;

            this.prima=prima;
            this.setIngresos(this.salarioBase+prima);
            
            this.setDescuentos(this.descuentoSalud+this.descuentoPension);
            this.setTotalAPagar(this.getIngresos()-this.getDescuentos());
        }

    }

    public boolean esEmpleadoActivo() {
        boolean activo = false;
        if(this.fechaRetiro == null){
            activo = true;
        }
        return activo;
    }

    public boolean esEmpleadoValido() {
        //COMPLETE
        boolean valido = false;
        if(this.fechaIngreso.esFechaValida() && this.fechaRetiro == null){
            valido = true;
        }else if((this.fechaIngreso.esFechaValida() && fechaRetiro.esFechaValida()) 
        && (!this.fechaIngreso.esMayor(this.fechaRetiro))){
            valido = true;
        }
        return valido;
    }

    public boolean esEmpleadoLiquidable(Fecha fechaLiquidacion){
        boolean esLiquidable=false;
        boolean antiguo=false;
        int aniosEnServicio=fechaLiquidacion.getAnio()-this.fechaIngreso.getAnio();
        if(aniosEnServicio>0&&
        fechaLiquidacion.getMes()>this.fechaIngreso.getMes())
            aniosEnServicio--;
        if(aniosEnServicio>0||
        fechaLiquidacion.getMes()>this.fechaIngreso.getMes()) 
            antiguo=true;
        if(esEmpleadoActivo()&&esEmpleadoValido()&&antiguo)esLiquidable=true;
        return esLiquidable;//COMPLETE
    }

    /**Metodo de acceso a la propiedad ingresos*/
    public double getIngresos(){
        return this.ingresos;
    }//end method getIngresos

    /**Metodo de modificación a la propiedad ingresos*/
    public void setIngresos(double ingresos){
        this.ingresos = ingresos;
    }//end method setIngresos

    /**Metodo de acceso a la propiedad descuentos*/
    public double getDescuentos(){
        return this.descuentos;
    }//end method getDescuentos

    /**Metodo de modificación a la propiedad descuentos*/
    public void setDescuentos(double descuentos){
        this.descuentos = descuentos;
    }//end method setDescuentos

    /**Metodo de acceso a la propiedad totalAPagar*/
    public double getTotalAPagar(){
        return this.totalAPagar;
    }//end method getTotalAPagar

    /**Metodo de modificación a la propiedad totalAPagar*/
    public void setTotalAPagar(double totalAPagar){
        this.totalAPagar = totalAPagar;
    }//end method setTotalAPagar

    /**Metodo de acceso a la propiedad fechaIngreso*/
    public Fecha getFechaIngreso(){
        return this.fechaIngreso;
    }//end method getFechaIngreso

    /**Metodo de modificación a la propiedad fechaIngreso*/
    public void setFechaIngreso(Fecha fechaIngreso){
        this.fechaIngreso = fechaIngreso;
    }//end method setFechaIngreso

    /**Metodo de acceso a la propiedad fechaRetiro*/
    public Fecha getFechaRetiro(){
        return this.fechaRetiro;
    }//end method getFechaRetiro

    /**Metodo de modificación a la propiedad fechaRetiro*/
    public void setFechaRetiro(Fecha fechaRetiro){
        this.fechaRetiro = fechaRetiro;
    }//end method setFechaRetiro

    public abstract double getProvisionRiesgos(Fecha fechaLiquidacion);
}