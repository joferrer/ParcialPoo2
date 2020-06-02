class Fecha {

    private int dia;
    private int mes;
    private int anio;

    public static final int[] diasDelMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Fecha(int dia, int mes, int anio) {
        //COMPLETE
        this.dia=dia;
        this.mes=mes;
        this.anio=anio;
    }
    
    public Fecha(int numero){
      //COMPLETE
      this.anio=numero/10000;
      this.mes=(numero%10000)/100;
      this.dia=(numero%10000)%100;
      
      
    }

    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * Regresa true si ésta fecha es mayor que otra
     */
    public boolean esMayor(Fecha otra) {
        boolean esMayor=this.anio>otra.getAnio()&&this.mes>otra.getDia()&&this.dia>otra.dia;
        
       return esMayor;//COMPLETE
    }//fin esMayor

    /**
     * Regresa true si ésta fecha es igual que otra
     */
    public boolean esIgual(Fecha otra) {
        
      return this.anio==otra.getAnio()&&this.dia==otra.getDia()&&this.mes==otra.getMes();//COMPLETE
    }

    /**
     * Regresa true si ésta fecha es menor que otra
     */
    public boolean esMenor(Fecha otra) {
        boolean esMenor=this.anio<otra.getAnio()&&this.mes<otra.getDia()&&this.dia<otra.dia;
      return false;//COMPLETE
    }

    public boolean esFechaValida() {
       boolean esValida=this.mes>0&&this.dia>0&&this.anio>0;
       if(esValida)esValida=this.mes<=12&&this.dia<=diasDelMes[this.mes-1];
     
      return esValida;//COMPLETE
    }

}