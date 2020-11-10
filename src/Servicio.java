import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class Servicio {
    private String nombre;

    private String duracion;

    private double precio;

    private String estado;
    
    private ArrayList<Servicio> arrayServicios;
   
    Scanner lector ;
   
    public Servicio(){     
    }
    
    Servicio s;
    
    public Servicio(String nombre, String duracion, double precio, String estado) {
        this.nombre=nombre;
        this.duracion=duracion;
        this.precio=precio;
        this.estado=estado;
    }
    public String getNombre(){
        return nombre;
    }
    
    public String getEstado(){
        return estado;
    }
    
    public void setNombre(String nombre){
        this.nombre= nombre;
    }
    public void setDuracion(String duracion){
        this.duracion=duracion;
    }
    public void setPrecio(double precio){
        this.precio=precio;
    }
    public void setEstado(String estado){
        this.estado=estado;
    }
    //Setters con lector

    public String getDuracion() {
        return duracion;
    }

    public double getPrecio() {
        return precio;
    }
    
    public void agregarServicio(ArrayList<Servicio> arrayServicios) {
        lector=new Scanner(System.in);
        String nombreserv, duracionserv, estadoserv;
        double precioserv;
        System.out.println("\nIngrese nombre del servicio: ");
        nombreserv= lector.nextLine();
        System.out.println("Ingrese duración del servicio: ");
        duracionserv=lector.nextLine();
        System.out.println("Ingrese precio del servicio: ");
        precioserv= lector.nextDouble();
        lector.nextLine();
                    
        Servicio s1= new Servicio(nombreserv,duracionserv,precioserv, "activo");//se crea un nuevo objeto servicio
        arrayServicios.add(s1);
        
    }
    //Metodo para agregar Servicio
    
    public void editarServicio(String nombre, ArrayList<Servicio> arrayServicios) {
        for(Servicio s:arrayServicios){
            lector= new Scanner(System.in);
            if(s.getNombre().equals(nombre)){//Busca en la lista el servicio que se desea editar
                System.out.println("Servicio encontrado");
                
                String opcionedit="a";
                while(!opcionedit.equals("D")){
                    System.out.println("\n¿Qué desea editar?\n"+ "A. Nombre\n" +"B. Precio\n"+ "C. Duracion\n"+"D. Salir\n");
                    System.out.println("Ingresar letra mayúscula: ");
                    opcionedit=lector.nextLine();//Se solicita el campo a editar
                    if(opcionedit.equals("A")){
                        System.out.println("Ingrese nuevo nombre: ");
                        String n=lector.nextLine();
                        s.setNombre(n);
                    }else if(opcionedit.equals("B")){
                        System.out.println("Ingrese nuevo precio: ");
                        double p = lector.nextDouble();
                        s.setPrecio(p);
                    }else if(opcionedit.equals("C")){
                        System.out.println("Ingrese nueva duracion: ");
                        String d=lector.nextLine();
                        s.setDuracion(d);
                    }else if(opcionedit.equals("D")){
                        System.out.println("\nMenú Servicio\n");//regresa al menu de Servicio
                    }else{
                        
                        System.out.println("Opción no válida");//vuelve a imprimir el menú de editar
                        
                    }
                }
            }
        }

    }

    public void eliminarServicio(String nombre, ArrayList<Servicio> arrayServicios) {
        for(Servicio s:arrayServicios){
            if(s.getNombre().equals(nombre)){
                if(s.estado.equals("activo")){
                    s.estado="inactivo";//Cambia el estado del servicio a inactivo
                }
            }
        }
    }
    public void mostrarServicios(ArrayList<Servicio> arrayServicios){
      /* muestra todos los servicios del array*/ 
        System.out.println("\nServicios\n");
        for (Servicio serv: arrayServicios) {
            
            System.out.println (serv.toString());
            
        }
        
    }

    @Override
    public String toString() {
        return "Nombre= " + nombre + "\nDuracion= " + duracion + "\nPrecio= " + precio + "\nEstado= " + estado +"\n";
    }

    public ArrayList<Servicio> getArrayServicios() {
        return arrayServicios;
    }

    public void setArrayServicios(ArrayList<Servicio> arrayServicios) {
        this.arrayServicios = arrayServicios;
    }

    
    
}
    