package Usuario;


import Usuario.Usuario;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Cliente extends Usuario {
    
    private Scanner lector;
    
    
    public Cliente(){    
    }
    Cliente cl;

    public Cliente(String cedula, String nombre, String telefono, String email) {
        super(cedula, nombre, telefono, email);
    }
    
    public void agregar(ArrayList<Cliente> clientes){
        lector= new Scanner(System.in);
        /*recibe el array de clientes para agregar el nuevo cliente al array y se ingresa todos los datos que se necesita del cliente*/
        String cedula_cliente, nombre_cliente,tel_cliente, email_client;
        System.out.println("\nIngrese cédula del cliente: ");
        cedula_cliente= lector.nextLine();
        System.out.println("Ingrese nombre del cliente: ");
        nombre_cliente=lector.nextLine();
        System.out.println("Ingrese teléfono del cliente: ");
        tel_cliente= lector.nextLine();
        System.out.println("Ingrese email del cliente: ");
        email_client=lector.nextLine();
                    
        Cliente c1= new Cliente(cedula_cliente, nombre_cliente, tel_cliente, email_client);//se crea un nuevo objeto cliente
        clientes.add(c1);//se agrega el nuevo cliente al array
    }
    public static String BuscarCliente(ArrayList<Cliente> clientes,String cedula){//busca al cliente segun la cedula
        String nombre="";
        for(int i=0;i<clientes.size();i++){
            String cedu=clientes.get(i).getCedula();
            nombre=clientes.get(i).getNombre();
            if(cedu.equals(cedula)){
                return nombre;
            }
        }
        return nombre;//retorna el nombre del cliente 
    }

    public void editar(String cedula, ArrayList<Cliente> clientes) {
        /*el metodo editar recibe la cedula del cliente que se desea modificar y el array de clientes... este recorre el array y compara la cedula 
        de todos los objetos con la cedula que el método recibe */
        lector=new Scanner(System.in);
        for (Cliente client: clientes){
            String ced=client.getCedula();
            
            if(cedula.equals(ced)){/*se trabaja con el cliente que coincidio con la cedula que recibe el metodo y luego se ingresa lo que se desea
                editar para proceder a cambiarlo*/
                
                cl=client;
                System.out.println("Usuario encontrado");
                String opcion_edit="a";                
                while(!(opcion_edit.equals("D"))){
                    
                    String edit_nombre, edit_tel, edit_email;
                    System.out.println("\n¿Qué desea editar?\n"+"A. Nombre\n"+"B. Teléfono\n"+"C. email\n"+"D. Atrás\n");
                    System.out.println("\nIngrese la letra en mayúscula: ");
                    opcion_edit= lector.nextLine();   
                        
                    if(opcion_edit.equals("A")){
                        
                        System.out.println("Agregue nuevo nombre: ");
                        edit_nombre=lector.nextLine();
                        cl.setNombre(edit_nombre);//se editó el nombre del cliente
                        //break;
                        
                    }else if(opcion_edit.equals("B")){
                        
                        System.out.println("Agregue nuevo teléfono: ");
                        edit_tel=lector.nextLine();
                        cl.setTelefono(edit_tel);//se editó el teléfono del cliente
                        //break;
                        
                    }else if(opcion_edit.equals("C")){
                        
                        System.out.println("Agregue nuevo email: ");
                        edit_email=lector.nextLine();
                        cl.setEmail(edit_email);//se editó el email del cliente
                        //break;
                        
                    }else if(opcion_edit.equals("D")){
                        System.out.println("\nMenú Cliente");//regresa al menu de Cliente
                    }else{
                        
                        System.out.println("Opción no válida");//vuelve a imprimir el menú de editar
                        
                    }
                }
            }else if (clientes.get(clientes.size()-1).equals(client)){
                System.out.println("Usuario no encontrado");
            }
        }
        
    }

    @Override
    public String toString() {
        return super.toString();
    }   


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cliente){
        super.equals(obj);}
        return false;
    }
    
}
