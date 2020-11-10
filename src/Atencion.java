
import Usuario.Cliente;
import Usuario.Empleado;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Atencion {
    private Cliente cliente;

    private Empleado empleado;

    private Servicio servicio_actual;
    private Cita cita;

    public Atencion(Cliente cliente, Empleado empleado, Servicio servicio_actual) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.servicio_actual = servicio_actual;
    }
    public Atencion(Cita cita,Servicio servicio){
        this.cita=cita;
        this.servicio_actual=servicio;
    }
    public Atencion(){}
    
    
    public void AgregarAtencion(ArrayList<Atencion> atenciones,ArrayList<Cita>citas,ArrayList<Cliente> clientes,ArrayList<Empleado> empleados){//agrega nueva atencion al array
        Scanner sc= new Scanner(System.in);
        System.out.println("Nombre del servicio: ");
        Servicio servicio= new Servicio();
        String name=sc.nextLine();
        servicio.setNombre(name);
        Cita cita= new Cita();
        cita.crearCita(citas,clientes,empleados);
        Cita cita2= citas.get(citas.size()-1);
        Atencion atencion= new Atencion(cita2,servicio);
        System.out.println("Su atencion ha sido agregada");
        
        
    }
    //Este metodo nos ayuda a determinar los minutos que dura la cita
    public int TiempoAtencion(String hora1,String minutos1,String hora2,String minutos2){
            int minutosInicio=Integer.parseInt(hora1)*60+Integer.parseInt(minutos1);
            int minutosFinal=Integer.parseInt(hora2)*60+Integer.parseInt(minutos2);
            int diferencia=minutosFinal-minutosInicio;
            return diferencia;
        }
    //Este metodo nos ayuda a encontrar la cita que corresponte a la cedula de ese usuario
    public Cita BuscarCita(ArrayList<Cita> citas,String cedula){
        Cita cita= new Cita();
        for(int i=0;i<citas.size();i++){
            Cliente cliente=citas.get(i).getConsumidor();
            String cedu=empleado.getCedula();
            if(cedula.equals(cedu)){
                cita=citas.get(i);
            }
            }
        return cita;
    }
    
    public void ImprimirAtencion(Cita cita,Servicio servicio){//imprime la atencion
        System.out.println(cita.toString());
        String horaI=cita.getHora_inicio().split(":")[0];
        String minI=cita.getHora_inicio().split(":")[1];
        String horaF=cita.getHora_fin().split(":")[0];
        String minF=cita.getHora_fin().split(":")[1];

        String nombServicio=servicio.getNombre();
        System.out.println("Servicio: "+nombServicio);
        System.out.println("Tiempo de duración de la cita: "+TiempoAtencion(horaI,minI,horaF,minF)+" minutos");
    }
    public void ConsultarAtenciones(ArrayList<Atencion> atenciones){
        for(int i=0;i<atenciones.size();i++){
            Cita cita= atenciones.get(i).getCita();
            Servicio servicio=atenciones.get(i).getServicio_actual();
            ImprimirAtencion(cita,servicio);
        }
    }

    public void ConsultarAtencionCliente(ArrayList<Atencion> atenciones,String cedu_clie){
        int num=0;
        for(int i=0;i<atenciones.size();i++){
            Cita cita=atenciones.get(i).getCita();
            String cedu=cita.getConsumidor().getCedula();
            Servicio servicio=atenciones.get(i).getServicio_actual();
            if(cedu_clie.equals(cedu)){
                ImprimirAtencion(cita,servicio);
                num++;
            }
        }
        if(num==0){
            System.out.println("Esta cédula no ha sido ingresada anteriromente");
        }
    }
    public void ConsultarAtencionEmple(ArrayList<Atencion> atenciones,String cedu_empleado){
        int num=0;
        
        for(int i=0;i<atenciones.size();i++){
            Cita cita=atenciones.get(i).getCita();
            String cedu=cita.getProveedor().getCedula();
            Servicio servicio= atenciones.get(i).getServicio_actual();
            if(cedu_empleado.equals(cedu)){
                ImprimirAtencion(cita,servicio);
                num++;
            }
        }
        if(num==0){
            System.out.println("Esta cédula no ha sido ingresada anteriromente");
        }
    }
    public void ConsultarAtencionFecha(ArrayList<Atencion> atenciones,String fecha){
        int num=0;
        for(int i=0;i<atenciones.size();i++){
            Cita cita=atenciones.get(i).getCita();
            String fech=cita.getFecha();
            Servicio servicio=atenciones.get(i).getServicio_actual();
            if(fecha.equals(fech)){
                ImprimirAtencion(cita,servicio);
                num++;
            }
        }
        if(num==0){
            System.out.println("La fecha ingresada no ha sido registrada anteriormente");
        }
    }
    
    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Servicio getServicio_actual() {
        return servicio_actual;
    }

    public void setServicio_actual(Servicio servicio_actual) {
        this.servicio_actual = servicio_actual;
    }

            
    
}
