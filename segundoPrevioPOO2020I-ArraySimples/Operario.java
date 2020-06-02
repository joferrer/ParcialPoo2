public class Operario extends Empleado
{
  
  public Operario(){
  }
  
  
  public Operario(String cedula, String nombres, String apellidos, double salarioBase, int fechaIngreso, int fechaRetiro){
    //COMPLETE recuerde el super para herencia de constructores
    super(cedula,nombres,apellidos,salarioBase,fechaIngreso,fechaRetiro);
  }
  
  public double getProvisionRiesgos(Fecha fechaLiquidacion){
      this.liquidarEmpleado(fechaLiquidacion);
      double rest= 0.0;
      rest=this.getTotalAPagar()*0.025;
   return rest;//COMPLETE
  }
}
