package Usuario;



import Usuario.Usuario;
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
public class Empleado extends Usuario{
    private boolean estado;
    private ArrayList<Empleado> empleados;
    private Scanner lector ;
    
    public Empleado(){
        
    }
    Empleado e;

    public Empleado(String cedula, String nombre, String telefono, String email, boolean estado) {
        super(cedula, nombre, telefono, email);
        this.estado=estado;
    }

    
    public boolean getEstado() {
        return estado;
    }
    @Override
    public String getNombre(){
       return super.getNombre();
    }
    
    public void setEstado(boolean estado) {
        this.estado=estado;
        
    }

    public void agregar(ArrayList<Empleado> empleados){
       String cedula_em,nombre_em,telefono_em,email_em;
       boolean es=true;
       lector=new Scanner(System.in);
       System.out.println("\nIngrese cédula del empleado: ");
       cedula_em= lector.nextLine();
       System.out.println("Ingrese nombre del empleado: ");
       nombre_em=lector.nextLine();
       System.out.println("Ingrese teléfono del empleado: ");
       telefono_em= lector.nextLine();
       System.out.println("Ingrese email del empleado: ");
       email_em=lector.nextLine();
       
       Empleado e=new Empleado(cedula_em,nombre_em,telefono_em,email_em,es);
       empleados.add(e);
        
    }
    public static String BuscarEmpleado(ArrayList<Empleado> empleados,String cedula){
        String nombre="";
        for(int i=0;i<empleados.size();i++){
            String cedu=empleados.get(i).getCedula();
            nombre=empleados.get(i).getNombre();
            if(cedu.equals(cedula)){
                return nombre;
            }
        }
        return nombre;
    }
    
    public static Empleado RetornarEmpleado(ArrayList<Empleado> empleados, String cedula) {
        Empleado empleado = new Empleado();
        int num = 0;
        for (int i = 0; i < empleados.size(); i++) {
            Empleado emp = empleados.get(i);
            String cedu = emp.getCedula();
            String nombre = emp.getNombre();
            String telf = emp.getTelefono();
            String email = emp.getEmail();
            if (cedu.equals(cedula)) {
                empleado.setNombre(nombre);
                emp.setCedula(cedula);
                emp.setEmail(email);
                emp.setTelefono(telf);
                num++;
            }
        }
        if (num == 0) {
            
            return null;
        }
        else{
            return empleado;
        }
    }
    
    public void editar(String cedula,ArrayList<Empleado> empleados) {//modifica los empleados
        lector= new Scanner(System.in);
        for (Empleado emp: empleados){
            
            String empl=emp.getCedula();
            
            if(cedula.equals(empl)){
                e=emp;//encuentra el empleado en el array
                System.out.println("Usuario encontrado");
                String opcion_edit="a";
                while(!(opcion_edit.equals("D"))){
                    String edit_nombre, edit_tel, edit_email;
                    System.out.println("\n¿Qué desea editar?\n"+"A. Nombre\n"+"B. Teléfono\n"+"C. email\n"+"D. atras\n");
                    System.out.println("\nIngrese la letra en mayúscula: ");
                    opcion_edit= lector.nextLine();   
                        
                    if(opcion_edit.equals("A")){
                        
                        System.out.println("Agregue nuevo nombre: ");
                        edit_nombre=lector.nextLine();
                        e.setNombre(edit_nombre);//se editó el nombre del empleado
                        //break;
                        
                    }else if(opcion_edit.equals("B")){
                        
                        System.out.println("Agregue nuevo teléfono: ");
                        edit_tel=lector.nextLine();
                        e.setTelefono(edit_tel);//se editó el teléfono del empleado
                        //break;
                        
                    }else if(opcion_edit.equals("C")){
                        
                        System.out.println("Agregue nuevo email: ");
                        edit_email=lector.nextLine();
                        e.setEmail(edit_email);//se editó el email del empleado

                    }else if(opcion_edit.equals("D")){
                        System.out.println("\nMenú Cliente");//regresa al menu de Empleado
                    }else{
                        
                        System.out.println("Opción no válida");//vuelve a imprimir el menú de editar
                        
                    }
                }
            }else if (empleados.get(empleados.size()-1).equals(emp)){
                System.out.println("Usuario no encontrado");
            }
     
            
        }
        
    }

    public void eliminar(Empleado e) {//pasa de estado activo a inactivo
        
        if(e.getEstado()==true){
            e.setEstado(false);
        }
    } 
    
    public void mostrarEmpleados(ArrayList<Empleado> arrayEmpleados){//muestra la lista de empleados
        System.out.println("\nEmpleados");
        for(Empleado e:arrayEmpleados){
            System.out.println(e);
        }
    }
     
    @Override
    public String toString() {
        return super.toString() + "Estado: " +estado;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Empleado){
        super.equals(obj);}
        return false;
    }
    
}