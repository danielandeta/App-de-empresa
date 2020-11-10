
import Usuario.Cliente;
import Usuario.Empleado;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Cita {
    
    private String fecha;

    private String hora_inicio;
    private String hora_fin;

    private Cliente consumidor;

    private Empleado proveedor;
    
    
    Scanner lector;
    
    public Cita (){
    }
    
    Cita cita;
    
    public Cita(String fecha, String hora,String hora2, Cliente consumidor, Empleado proveedor) {
        this.fecha= fecha;
        this.hora_inicio= hora;
        this.consumidor=consumidor;
        this.proveedor= proveedor;
        this.hora_fin=hora2;
    }
    
    public String getFecha() {
        return fecha;
    }


    public Cliente getConsumidor() {
        return consumidor;
    }

    public Empleado getProveedor() {
        return proveedor;
    }
    
    
    public void setFecha(String fecha){
        this.fecha= fecha;
    }
    
    
    public void setCliente(Cliente consumidor){
        this.consumidor= consumidor;
    }
    public void setProveedor(Empleado proveedor){
        this.proveedor= proveedor;
    }

    public String getHora_fin() {
        return hora_fin;
    }
    

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }
    //metodo para crear la cita
    public void crearCita( ArrayList<Cita> arrayCitas,ArrayList<Cliente> clientes,ArrayList<Empleado> empleados) {
        cita =new Cita();
        lector= new Scanner(System.in);
        /*Se registra la fecha, hora, cliente, persona encargada de proveer el servicio.  Aquí se debe verificar que la hora de la cita esté dentro del rango 
        de atención, además de verificar que no exista otra cita a la misma fecha y hora con la persona encargada o que no se cruce con otra.*/
        /*cita.fecha=fecha;
        cita.hora=hora;
        cita.consumidor=c;
        cita.proveedor=p;*/
        String fech;
        do{
        System.out.println("Ingrese fecha de la cita (dd/mm/aaaa): ");
        fech= lector.nextLine();
        }while(validarFecha(fech)!=true);        
        System.out.println("Ingrese hora de inicio de  la cita (hh:mm): ");
        String hora=lector.nextLine();
        System.out.println("Ingrese hora de fin de  la cita (hh:mm): ");
        String hora2=lector.nextLine();
        System.out.println("Ingrese cédula del proveedor de servicio: ");
        String ced_proveedor=lector.nextLine();
        Empleado emp=new Empleado();
                
        System.out.println("Ingrese cédula del cliente: ");
        String ced_consumidor=lector.nextLine();
        Cliente cl=new Cliente();
        
        boolean rangoAtencion=false;
        boolean compFecha=false;
        
        
            
        int num=0;
        Cita cit=new Cita();
        if(VerificarExistenciCedulaCli(clientes,ced_consumidor) && VerificarExistenciCedulaEmp(empleados,ced_proveedor) ){
        for(int i=0;i<arrayCitas.size();i++){
            String hora1=arrayCitas.get(i).getHora_inicio();
            String hora3=arrayCitas.get(i).getHora_fin();
            String fecha1=arrayCitas.get(i).getFecha();
            Empleado proveedor= arrayCitas.get(i).getProveedor();
                                                          
            //se comprueba de que no exista otra cita igual
            if(ComprobarIgualCita(arrayCitas,fech,hora,hora2,ced_proveedor)){
                System.out.println("Espacio disponible");
                Cliente cl2= new Cliente();
                cl2.setCedula(ced_consumidor);
                cl2.setNombre(Cliente.BuscarCliente(clientes,ced_consumidor ));
                Empleado emp2= new Empleado();
                emp2.setCedula(ced_proveedor);
                emp2.setNombre(Empleado.BuscarEmpleado(empleados, ced_proveedor));
                 cit= new Cita(fech,hora,hora2,cl2,emp2);   
                 num++;
                                
            }
            else{
                System.out.println("Este horario ya a sido ocupado");
            }
            } 
            if(num!=0){
                arrayCitas.add(cit);
            }
        }
        else{
            System.out.println("La cedula del empleado o la del cliente no ha sido registrada anteriormente");
        }
    }
    
    public boolean VerificarExistenciCedulaCli(ArrayList<Cliente> clientes,String cedula){ //verifica si existe la cedula del cliente
        for(int i=0;i<clientes.size();i++){
            String cedu=clientes.get(i).getCedula();
            if(cedu.equals(cedula)){
                return true;
            }
        }
        return false;
    }
    
    public boolean VerificarExistenciCedulaEmp(ArrayList<Empleado> empleados,String cedula){ //verifica si existe la cedula del empleado
        for(int i=0;i<empleados.size();i++){
            String cedu=empleados.get(i).getCedula();
            if(cedu.equals(cedula)){
                return true;
            }
        }
        return false;
    }
    
    public static boolean validarEntero(String entrada){
    long num;
    try{
        num = Integer.parseInt(entrada);
        return true;
    }
    catch(Exception e)
    {
        return false;
    } }
    
    public static boolean validarFecha(String entrada){//valida que la fecha esté en el formato indicado
        
      String fecha[]=entrada.split("/");
      String dia="";
      String mes="";
      String ano="";
      if(fecha.length==3){
          
          dia=fecha[0];
          mes=fecha[1];
          ano=fecha[2];
          if(validarEntero(dia) && validarEntero(mes) && validarEntero(ano)){
              return true;
          }
      }
      return false;
    }
    
    public void eliminarCita(ArrayList<Cita>citas, String cedula){//elimina la cita del array
        int num=0;
        for(int i=0;i<citas.size();i++){
            String cedu=citas.get(i).getConsumidor().getCedula();
            if(cedula.equals(cedu)){
                citas.remove(citas.get(i));
                num++;
            }
        }
        if(num==0){
            System.out.println("ESta cedula no existe en el registro");
        }
    }
    
    public void consultarCita(ArrayList<Cita> citas,String fecha){
        int num=0;
        for(int i=0;i<citas.size();i++){
            String fech=citas.get(i).getFecha();
            if(fecha.equals(fech)){
                System.out.println(citas.get(i).toString());
                num++;
            }
        }
        if(num==0){
            System.out.println("Esta fecha no esta registrada a inguna cita");
        }
        
    }
    
    public void mostrarCitas(ArrayList<Cita> arrayCitas){
        for (Cita c: arrayCitas) {
            System.out.println(c.toString());
            //muestra todas las citas del array
        }
    }
    public boolean ComprobarIgualCita(ArrayList<Cita> citas,String fecha, String hora1,String hora2,String cedu_emple){//comprueba si la cita ya está ocupada
        String fech="";
        System.out.println(citas.size());
        for(int i=0;i<citas.size();i++){
            fech=citas.get(i).getFecha();
            String horaI=citas.get(i).getHora_inicio();
            String horaF= citas.get(i).getHora_fin();
            String empleado=citas.get(i).getProveedor().getCedula();
            System.out.println(fech+" "+i);
            if(fech!=null){
            if(fech.equals(fecha) && cedu_emple.equals(empleado) && !EstaEnElIntervaloTiempo(horaI,horaF,hora1,hora2)){
                return false;
            }}
        }
        return true;
    }
    public boolean EstaEnElIntervaloTiempo(String hora1,String hora2,String horaI,String horaF){//verifica que este en el intervalo de tiempo del que el negocio funciona
        try{
        int intervalorInf=Integer.parseInt(hora1.split(":")[0])+Integer.parseInt(hora1.split(":")[1]);
        int intervaloSup=Integer.parseInt(hora2.split(":")[0])+Integer.parseInt(hora2.split(":")[1]);
        int evaluarIntervaloInf=Integer.parseInt(horaI.split(":")[0])+Integer.parseInt(horaI.split(":")[1]);
        int evaluarIntervaloSup=Integer.parseInt(horaF.split(":")[0])+Integer.parseInt(horaF.split(":")[1]);
        if((evaluarIntervaloInf<=intervaloSup && evaluarIntervaloInf>=intervalorInf) || (evaluarIntervaloSup<=intervaloSup && evaluarIntervaloSup>=intervalorInf) ){
            return true;
        }
        return false;}
        catch(Exception e){
            System.out.println("No a ingresado los datos con el formato que se le indico");
            return true;
        }
    }

    @Override
    public String toString() {
        return  "\nFecha= " + fecha + "\nHora inicio= " + hora_inicio + "\nHora fin= " + hora_fin + "\nConsumidor= " + consumidor.getNombre() + "\nProveedor= " + proveedor.getNombre() + '\n';
    }

 

    @Override
    public boolean equals(Object obj) {
        
        final Cita other = (Cita) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.hora_inicio, other.hora_inicio)) {
            return false;
        }
        if (!Objects.equals(this.hora_fin, other.hora_fin)) {
            return false;
        }
        if (!Objects.equals(this.proveedor, other.proveedor)) {
            return false;
        }
        return true;
    }
    
   
    
    
    
}
