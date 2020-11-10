
import Usuario.Empleado;
import java.util.ArrayList;
import java.util.Scanner;


public class Negocio {
    private String nombre;

    private String telefono;

    private String email;

    private String direccion;

    private String hora_inicio;

    private String hora_fin;

    private Empleado administrador;
    
    Scanner lector;
    
    private ArrayList<Empleado> empleados;
    
    public Negocio() {
    }
    Negocio n;

    public Negocio(String nombre, String telefono, String email, String direccion, String hora_inicio, String hora_fin, Empleado administrador) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.administrador = administrador;
    }
 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public Empleado getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Empleado administrador) {
        this.administrador = administrador;
    }
    
    

    @Override
    public String toString() {
        return "\nNegocio: " +nombre+"\nTeléfono: "+ telefono+"\nemail: "+ email+"\nDirección: "+direccion+"\nHora inicio: "+ hora_inicio+"\nHora fin: " +hora_fin+"\nAdministrador: " + administrador.getNombre();
    }
    
}
