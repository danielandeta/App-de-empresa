
import Usuario.Cliente;
import Usuario.Empleado;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Principal {

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Empleado> empleados;
    private static ArrayList<Cliente> clientes;
    private static ArrayList<Servicio> servicios;
    private static ArrayList<Cita> arrayCitas;
    private static ArrayList<Atencion> arrayAtenciones;
    private static Negocio negocio;
    private static Empleado admi;
    private static Empleado empleado;
    private static Servicio servicio1;
    private static Servicio servicio2;
    private static Servicio servicio3;
    private static Cliente cliente1;
    private static Cliente cliente2;
    private static Cita cita1;
    private static Cita cita2;
    private static Atencion atencion1;

    public static void main(String[] args) {
        
        inicializarSistema();
        
        menu();
        

    }

    public static String subMenu() {
        Scanner sca = new Scanner(System.in);
        String opcion = "";
        System.out.println("\nSELECCIONE UNA OPCIÓN PARA INICIAR\n1. Negocio\n"
                + "2. Servicios\n"
                + "3. Empleados\n"
                + "4. Clientes\n"
                + "5. Citas\n"
                + "6. Atenciones\n"
                + "7. Salir\n");
        System.out.println("Ingrese el número de la opción que desea solicitar: ");
        opcion = sca.nextLine();
        return opcion;
    }

    
    public static String MicroMenuNegocios() {
        ArrayList<String> rango;
        String opcion = "";
        do{
        Scanner sca = new Scanner(System.in);
        System.out.println("\n1.1 Visualizar\n"
                + "1.2 Modificar\n" + "1.3 Atrás\n");
        System.out.println("Ingrese la opción a solicitar (#.#): ");
        opcion = sca.nextLine();
        rango=RangoDeElementos(1,3);
        }while(!rango.contains(opcion));
        return opcion;
    }
    //Menu para servicios
    public static String MicroMenuServicios() {
        ArrayList<String> rango;
        String opcion = "";
        do{
        Scanner sca = new Scanner(System.in);
        System.out.println("\n2.1 Servicios\n" + "2.2 Agregar\n" + "2.3 Editar\n" + "2.4 Eliminar\n" + "2.5 Salir\n");
        System.out.println("Ingrese la opción a solicitar (#.#): ");
        opcion = sca.nextLine();
        rango=RangoDeElementos(2,5);
        }while(!rango.contains(opcion));
        return opcion;
    }

    //Menu para empleados
    public static String MicroMenuEmpleados() {
        ArrayList<String> rango;
        String opcion = "";
        do{
        Scanner sca = new Scanner(System.in);
        System.out.println("\n3.1 Visualizar\n" + "3.2 Agregar\n" + "3.3 Editar\n" + "3.4 Eliminar\n" + "3.5 Salir");
        System.out.println("Ingrese la opción a solicitar (#.#): ");
        opcion = sca.nextLine();
        rango=RangoDeElementos(3,5);
        }while(!rango.contains(opcion));
        return opcion;
    }
    //  Nos ayuda a crear una lista de elementos con opciones que deseemos
    public static ArrayList<String> RangoDeElementos(int num_opcion,int cant_opciones){
        ArrayList<String> lista= new ArrayList();
        for(int i=1;i<=cant_opciones;i++){
            lista.add(num_opcion+"."+i);
        }
        return lista;
    }
    //Menu para clientes
    public static String MicroMenuClientes() {
        ArrayList<String> rango;
        String opcion = "";
        do{
        Scanner sca = new Scanner(System.in);
        System.out.println("\n4.1 Visualizar\n"
                + "4.2 Agregar\n" + "4.3 Editar\n" + "4.4 Atrás\n");
        System.out.println("Ingrese la opción a solicitar (#.#): ");
        opcion = sca.nextLine();
        rango=RangoDeElementos(4,4);
        }while(!rango.contains(opcion));
        return opcion;
    }
    //Menu para citas
    public static String MicroMenuCitas() {
        ArrayList<String> rango;
        String opcion = "";
        do{
        Scanner sca = new Scanner(System.in);
        System.out.println("\n5.1 Ver citas\n" + "5.2 Agregar Citas\n" + "5.3 Eliminar Citas\n" + "5.4 Consultar Citas por Fecha\n" + "5.5 Salir\n");
                        System.out.println("Ingrese la opción a solicitar (#.#): ");
        opcion = sca.nextLine();
        rango=RangoDeElementos(5,5);
        }while(!rango.contains(opcion));
        return opcion;
    }
    //Menu para atencion
    public static String MicroMenuAtencion() {
        ArrayList<String> rango;
        String opcion = "";
        do{
        Scanner sca = new Scanner(System.in);
        System.out.println("\n6.1 Ver Atenciones\n" + "6.2 Agregar Atención\n" + "6.3 Buscar Atención por cédula del cliente\n"+ "6.4 Buscar Atención por cédula del empleado \n"+ "6.5 Buscar Atención por Fecha\n" + "6.6 Salir\n");
                        System.out.println("Ingrese la opción a solicitar (#.#): ");
        opcion = sca.nextLine();
        rango=RangoDeElementos(6,6);
        }while(!rango.contains(opcion));
        return opcion;
    }
    public static void menu() {

        String opcion;
        int global = 0;

        do {
            opcion = subMenu();

            switch (opcion) {
                //CONFIGURACIONES
                case "1":

                    String opcion1;

                    opcion1 = MicroMenuNegocios();
                    if (opcion1.equals("1.1")) {
                        System.out.println(negocio);
                        global = 1;

                    } else if (opcion1.equals("1.2")) {
                        modificarNegocio();
                        global = 1;

                    } else if (opcion1.equals("1.3")) {
                        System.out.println("Menú principal");
                        global = 1;
                    } else {
                        System.out.println("Opción no válida");
                        global = 1;
                    }
//                    }

                    break;

                case "2":
                    
                    String opcion2;

                    opcion2 = MicroMenuServicios();//Se solicita opcion del servicio
                    if (opcion2.equals("2.1")) {
                        Servicio s = new Servicio();
                        s.mostrarServicios(servicios);
                        global = 1;
                    } else if (opcion2.equals("2.2")) {
                        Servicio s = new Servicio();
                        s.agregarServicio(servicios);
                        System.out.println("Servicio agregado");
                        global = 1;
                    } else if (opcion2.equals("2.3")) {
                        Servicio s = new Servicio();
                        System.out.println("Ingrese nombre de servicio a editar: ");
                        String nombre = sc.nextLine();
                        s.editarServicio(nombre, servicios);//Se edita el servicio
                        System.out.println("Servicio editado");
                        global = 1;
                    } else if (opcion2.equals("2.4")) {
                        Servicio s = new Servicio();
                        System.out.println("Ingrese servicio a eliminar: ");
                        String nombre = sc.nextLine();
                        s.eliminarServicio(nombre, servicios);//Se elimina el servicio
                        System.out.println("Servicio eliminado");
                        global = 1;
                    } else if (opcion2.equals("2.5")) {
                        System.out.println("Menú principal");
                        global = 1;
                    } else {
                        System.out.println("Opción no válida");
                        global = 1;
                    }


                    //...
                    break;

                case "3":
                    
                    String opcion3;

                    opcion3 = MicroMenuEmpleados();
                    if(opcion3.equals("3.1")) {
                        Empleado e=new Empleado();
                        e.mostrarEmpleados(empleados);
                        global = 1;
                    }else if (opcion3.equals("3.2")) {
                        Empleado e = new Empleado();
                        e.agregar(empleados);
                        global = 1;

                    } else if (opcion3.equals("3.3")) {

                        String ced_empl;
                        System.out.println("\nIngrese cédula del empleado que desea editar: ");
                        ced_empl = sc.nextLine();
                        Empleado e = new Empleado();
                        e.editar(ced_empl, empleados);//modifica un empleado
                        global = 1;
                        
                    } else if (opcion3.equals("3.4")) {
                        
                        Empleado empleado = new Empleado();
                        System.out.println("\nIngrese cédula del empleado que desea eliminar: ");
                        String ced=sc.nextLine();
                        Empleado e = Empleado.RetornarEmpleado(empleados,ced);
                        if(e!=null){
                            empleado.eliminar(e); //pone inactivo al empleado
                            System.out.println("Se ha eliminado el empleado");
                        }
                        else{
                            System.out.println("La cédula de este empleado no está en el registro");
                        }
                        global = 1;
                                            
                    } else if (opcion3.equals("3.5")) {
                        System.out.println("Menú principal");
                    } else {
                        System.out.println("Opción no válida");
                    }
//                    }
                    break;

                case "4":
                    
                    String opcion4;

                        opcion4 = MicroMenuClientes();

                        if (opcion4.equals("4.1")) {

                            for (Cliente cl : clientes) {
                                System.out.println(cl.toString());
                            }
                            global=1;

                        } else if (opcion4.equals("4.2")) {

                            Cliente cl = new Cliente();
                            cl.agregar(clientes);
                            global=1;

                        } else if (opcion4.equals("4.3")) {

                            String ced_cliente;
                            System.out.println("\nIngrese cédula del cliente que desea editar: ");
                            ced_cliente = sc.nextLine();
                            Cliente cl = new Cliente();
                            cl.editar(ced_cliente, clientes);
                            global=1;

                        } else if (opcion4.equals("4.4")) {

                            System.out.println("Menú principal");
                            global=1;

                        } else {

                            System.out.println("Opción no válida");
                            global=1;

                        }
//                    }
                    break;

                case "5":
                    
                    String opcion5;

                        
                        opcion5 = MicroMenuCitas();
                        if (opcion5.equals("5.1")) {
                            Cita c = new Cita();
                            c.mostrarCitas(arrayCitas);
                            global=1;
                            
                        }
                        if (opcion5.equals("5.2")) {
                            Cita c = new Cita();
                            c.crearCita(arrayCitas,clientes,empleados);//Se agrega la cita
                            c.mostrarCitas(arrayCitas);
                            global=1;
                            
                        } else if (opcion5.equals("5.3")) {
                            Cita c = new Cita();
                            System.out.println("Ingrese cédula del cliente: ");
                            String cedula = sc.nextLine();
                            c.eliminarCita(arrayCitas,cedula);//Se elimina la cita
                            c.mostrarCitas(arrayCitas);
                            global=1;
                            
                        } else if (opcion5.equals("5.4")) {
                            Cita c = new Cita();
                            System.out.println("Ingrese fecha: ");
                            String fecha = sc.nextLine();
                            c.consultarCita( arrayCitas,fecha);//Se consulta la cita
                            global=1;
                            
                        } else if (opcion5.equals("5.5")) {
                            System.out.println("Menú principal");
                            global=1;
                            
                        } else {
                            System.out.println("Opción no válida");
                            global=1;
                        }
//                    }
                    break;

                case "6":
                    String opcion6=MicroMenuAtencion();
                    Atencion atencion=new Atencion();
                    if(opcion6.equals("6.1")){
                        atencion.ConsultarAtenciones(arrayAtenciones);
                        global=1;
                    }
                    else if(opcion6.equals("6.2")){
                    atencion.AgregarAtencion(arrayAtenciones, arrayCitas,clientes,empleados);
                    global=1;
                    }
                    else if(opcion6.equals("6.3")){
                        System.out.println("Ingrese la cédula del usuario: ");
                        Scanner sc6= new Scanner(System.in);
                        String cedu= sc6.nextLine();
                        atencion.ConsultarAtencionCliente(arrayAtenciones, cedu);
                        global=1;
                    }
                    else if(opcion6.equals("6.4")){
                        System.out.println("Ingrese la cédula del empleado: ");
                        Scanner sc6= new Scanner(System.in);
                        String cedu= sc6.nextLine();
                        atencion.ConsultarAtencionEmple(arrayAtenciones, cedu);
                        global=1;
                    }
                    else if(opcion6.equals("6.5")){
                        System.out.println("Ingrese la fecha de la atención: ");
                        Scanner sc6= new Scanner(System.in);
                        String fecha= sc6.nextLine();
                        atencion.ConsultarAtencionFecha(arrayAtenciones, fecha);
                        global=1;
                    }
                    else if(opcion6.equals("6.6")){
                        System.out.println("Saliendo.............");
                        global=1;
                    }
                    else{
                        System.out.println("Lo ingresado no forma parte de las opciones");
                        global=1;
                    }
                    break;

                case "7":
                    System.out.println("Gracias por preferirnos");
                    global=0;
                    break;
                default:
                    System.out.println("Esto no forma parte de las opciones");
                    global = 1;
            }
        } while (global == 1);
    }
    //Inicio de sesion para el usuario
    public static void inicializarSistema() {
        /*Se crea el objeto Negocio y los objetos Empleado, Cliente, Servicio, Atencion, Cita
        y se agrega al array de objetos de cada uno*/
        empleados = new ArrayList();
        clientes = new ArrayList();
        servicios = new ArrayList();
        arrayCitas = new ArrayList();
        arrayAtenciones= new ArrayList();

        admi = new Empleado("0925035172", "Jessenia Loja", "0997026391", "jesseniallj@gmail.com", true);
        empleado = new Empleado("0701180135", "Jose Bravo", "0998574127", "josebravo7@gmail.com", true);

        cliente1 = new Cliente("0701178987", "Andrea Castillo", "0997852127", "andycastillo12@gmail.com");
        cliente2 = new Cliente("0707852369", "Michelle Mendieta", "0997823698", "mishumend34@gmail.com");

        negocio = new Negocio("Lemonjuice makeup", "2744307", "lemonjuice@gmail.com", "Urdesa norte", "07:00", "19:00", admi);

        servicio1 = new Servicio("Maquillaje de noche", "2 h", 40, "activo");
        servicio2 = new Servicio("Depilacion de cejas", "30 min", 10, "activo");
        servicio3 = new Servicio("Maquillaje de día", "1 h", 30, "inactivo");

        empleados.add(admi);
        empleados.add(empleado);

        clientes.add(cliente1);
        clientes.add(cliente2);

        servicios.add(servicio1);
        servicios.add(servicio2);
        servicios.add(servicio3);

        cita1 = new Cita("28/02/2020", "14:00","15:00", cliente1, admi);
        cita2 = new Cita("30/02/2020", "15:30","16:30", cliente2, empleado);
        
        arrayCitas.add(cita1);
        arrayCitas.add(cita2);
        Atencion atencion=new Atencion(cita1,servicio1);
        arrayAtenciones.add(atencion);

    }
    //metodo de modificacion de negocio
    public static void modificarNegocio() {
        //Este metodo pide al usuario que ingrese que desea modificar de los datos del negocio y cambia lo que el usuario ingrese
        String opcion_alt = "a", nuevo_nombre, nuevo_tel, nuevo_email, nueva_dir, n_hora_inicio, n_hora_fin, nuevo_admi;

        while (!(opcion_alt.equals("H"))) {

            System.out.println("\n¿Qué desea modificar?\n" + "A. Nombre\n" + "B. Teléfono\n" + "C. email\n" + "D. Dirección\n" + "E. Hora de inicio\n"
                    + "F. Hora fin\n" + "G. Administrador\n" + "H. Salir\n");

            System.out.println("Ingrese la letra en mayúscula: ");
            opcion_alt = sc.nextLine();

            if (opcion_alt.equals("A")) {

                System.out.println("Agregue nuevo nombre: ");
                nuevo_nombre = sc.nextLine();
                negocio.setNombre(nuevo_nombre);//modifica el nombre del negocio
                System.out.println("Cambio de nombre exitoso");

            } else if (opcion_alt.equals("B")) {

                System.out.println("Agregue nuevo teléfono: ");
                nuevo_tel = sc.nextLine();
                negocio.setTelefono(nuevo_tel);//modifica el telefono del negocio
                System.out.println("Cambio de teléfono exitoso");

            } else if (opcion_alt.equals("C")) {

                System.out.println("Agregue nuevo email: ");
                nuevo_email = sc.nextLine();
                negocio.setEmail(nuevo_email);//modifica el email del negocio
                System.out.println("Cambio de email exitoso");

            } else if (opcion_alt.equals("D")) {

                System.out.println("Agregue nueva dirección: ");
                nueva_dir = sc.nextLine();
                negocio.setDireccion(nueva_dir);//modifica la direccion del negocio
                System.out.println("Cambio de dirección exitosa");

            } else if (opcion_alt.equals("E")) {

                System.out.println("Agregue nueva hora inicio (hh:mm): ");
                n_hora_inicio = sc.nextLine();
                negocio.setHora_inicio(n_hora_inicio);//modifica la hora de inicio del negocio
                System.out.println("Cambio de horario exitoso");

            } else if (opcion_alt.equals("F")) {

                System.out.println("Agregue nueva hora fin (hh:mm): ");
                n_hora_fin = sc.nextLine();
                negocio.setHora_fin(n_hora_fin);//modifica la hora de fin del negocio
                System.out.println("Cambio de horario exitoso");

            } else if (opcion_alt.equals("G")) {

                System.out.println("Ingrese cédula del nuevo Administrador: ");
                nuevo_admi = sc.nextLine();
                Empleado admin = Empleado.RetornarEmpleado(empleados,nuevo_admi);
                if(admin!=null){
                negocio.setAdministrador(admin); //modifica el administrador del negocio
                System.out.println("Cambio de administrador exitoso");
                }
                else{
                    System.out.println("La cedula de este administrador no esta en el registro");
                }
                negocio.setAdministrador(admin); //modifica el administrador del negocio
                //System.out.println("Cambio de administrador exitoso");

            } else if (opcion_alt.equals("H")) {

                System.out.println("\nMenú de Negocio"); //me regresa al menu de negocio

            } else {

                System.out.println("Opción no válida");//cuando la opcion no es correcta vuelve a salir el menu de modificar

            }
        }
    }



}
