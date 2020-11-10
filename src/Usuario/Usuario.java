package Usuario;



import java.util.ArrayList;
import java.util.Objects;
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
public class Usuario {
    private String cedula;
    private String nombre;
    private String telefono;
    private String email;
    private ArrayList<Usuario> arrayUsuario;
    Scanner lector ;
    
    public Usuario(){     
    }
    
    Usuario u;
   
    public Usuario(String cedula, String nombre, String telefono, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula=cedula;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;//no usar aqui el sout :v
        
    }
    

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono=telefono;
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
        
    }

    public ArrayList<Usuario> getArrayUsuario() {
        return arrayUsuario;
    }

    public void setArrayUsuario(ArrayList<Usuario> arrayUsuario) {
        this.arrayUsuario = arrayUsuario;
    }
   
    @Override
    public String toString() {
        return "\nCédula: " + cedula + "\nNombre: " + nombre + "\nTeléfono: " + telefono + "\nEmail: " + email + "\n";
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Usuario){
            Usuario us= (Usuario)obj;
            if(this.cedula.equals(us.cedula)){
                return true;
            }
        }
        return false;
    }

   
  
    
}
