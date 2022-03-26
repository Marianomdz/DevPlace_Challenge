package principal;

import Alumnos.Alumno;
import Alumnos.AlumnoService;
import Carreras.CarreraService;
import Localidades.LocalidadService;
import Materias.MateriaService;
import Notas.NotaService;
import Paises.PaisService;
import Provincias.ProvinciaService;
import Universidades.UniversidadService;
import java.awt.AWTException;
import java.awt.Robot;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class MenuOpciones {

    /*Recordar que este menu es a modo de orden para ir probando los metodos, no tiene importancia
    en si, ya que muy pronto los datos seran recibidos desde los formularios de las paginas web*/
    private final Scanner sc;
    private final PaisService paisService;
    private final ProvinciaService provinciaService;
    private final LocalidadService localidadService;
    private final UniversidadService universidadService;
    private final MateriaService materiaService;
    private final AlumnoService alumnoService;
    private final NotaService notaService;
    private final CarreraService carreraService;

    // private final AlumnoService alumnoService;
    public MenuOpciones() {
        this.sc = new Scanner(System.in).useDelimiter("\n");
        //this.alumnoService = new AlumnoService();
        this.paisService = new PaisService();
        this.provinciaService = new ProvinciaService();
        this.localidadService = new LocalidadService();
        this.universidadService = new UniversidadService();
        this.materiaService = new MateriaService();
        this.alumnoService = new AlumnoService();
        this.notaService = new NotaService();
        this.carreraService = new CarreraService();
    }

    public void menu() throws Exception {
        String respuesta;
        do {
            System.out.println("Seleccione la opción:");
            System.out.println("=====================================");
            System.out.println(" 0- RELLENAR DB");//OK
            System.out.println(" 1- Crear Pais");//OK
            System.out.println(" 2- Crear Provincia");//OK

            System.out.println(" 3- Crear Localidad");//OK
            System.out.println(" 4- Crear Universidad");//OK
            System.out.println(" 5- Crear Carrera");//OK
            System.out.println(" 6- Crear Materia");//OK
            System.out.println(" 7- Crear Alumno");//OK            

            System.out.println(" 8- Cargar Nota");//OK
            System.out.println(" 9- Mostar Informe");//OK

            //System.out.println(" 9 - Modificar Apodo Mascota");

            System.out.println(" 10- Salir");

            int opcion = sc.nextInt();
            switch (opcion) {
                
                case 0:
                    alumnoService.llenardb();
                    break;
                case 1:
                    paisService.crearPais(cargarNombre());
                    break;
                case 2:
                    provinciaService.crearProvincia(cargarNombre(), cargarIdPais());
                    break;
                case 3:
                    localidadService.crearLocalidad(cargarNombre(), cargarIdProvincia());
                    break;
                case 4:
                    universidadService.crearUniversidad(cargarNombre(), cargarIdProvincia(), cargarIdLocalidad());
                    break;
                case 5:
                    carreraService.crearCarrera(cargarNombre(), cargarIdUniversidad());
                    break;
                case 6:
                    materiaService.crearMateria(cargarNombre(), cargarIdCarrera());
                    break;
                case 67:
                    alumnoService.crearAlumno(cargarNombre(), cargarApellido(), cargarTelefono(), cargarCorreo(), cargarIdUniversidad(), cargarIdCarrera());
                    break;

                case 8:
                    notaService.cargarNota(cargarNota(), cargarIdAlumno(), cargarIdMateria());
                    break;
                case 9:
                    alumnoService.imprimirAlumnos(); 
                    break;

                case 10:
                    System.exit(0);
                    break;
            }

            System.out.println("Desea realizar una nueva consulta o gestion ???:SI/NO");
            respuesta = sc.next();
            respuesta = respuesta.toUpperCase();
            limpiarPantalla();
        } while ("SI".equals(respuesta));

    }

    public void limpiarPantalla() throws AWTException {
        //Dejo esre metodo para ir borrando la consola.. y que no sea un desorden.
        Robot pressbot = new Robot();
        pressbot.setAutoDelay(30); // Tiempo de espera antes de borrar
        pressbot.keyPress(17); // Orden para apretar CTRL key
        pressbot.keyPress(76);// Orden para apretar L key
        pressbot.keyRelease(17); // Orden para soltar CTRL key
        pressbot.keyRelease(76); // Orden para soltar L key

    }

    public String cargarNombre() {
        System.out.println("Ingrese nombre");
        String nombre = sc.next();
        return nombre;
    }

    public Integer cargarIdPais() {
        System.out.println("Ingrese id Pais");
        Integer id_pais = sc.nextInt();
        return id_pais;
    }

    public Integer cargarIdProvincia() {
        System.out.println("Ingrese id Provincia");
        Integer id_provincia = sc.nextInt();
        return id_provincia;
    }

    public Integer cargarIdLocalidad() {
        System.out.println("Ingrese id Localidad");
        Integer id_localidad = sc.nextInt();
        return id_localidad;
    }

    public Integer cargarIdUniversidad() {
        System.out.println("Ingrese id Universidad");
        Integer id_universidad = sc.nextInt();
        return id_universidad;
    }

    public Integer cargarIdCarrera() {
        System.out.println("Ingrese id Carrera");
        Integer id_carrera = sc.nextInt();
        return id_carrera;
    }
    
    public Integer cargarIdAlumno() {
        System.out.println("Ingrese id Alumno");
        Integer id_alumno = sc.nextInt();
        return id_alumno;
    }

    public Integer cargarIdMateria() {
        System.out.println("Ingrese id Materia");
        Integer id_materia = sc.nextInt();
        return id_materia;
    }

    public String cargarNota() {
        System.out.println("Ingrese la Nota");
        String nota = sc.next();
        return nota;
    }

    public String cargarApellido() {
        System.out.println("Ingrese Apellido del Alumno");
        String apellido = sc.next();
        return apellido;
    }

    public String cargarTelefono() {
        System.out.println("Ingrese Telefono del Alumno");
        String telefono = sc.next();
        return telefono;
    }

    public String cargarCorreo() throws Exception {
        String correoI;
        System.out.println("Ingrese el correo");
        correoI = sc.next();
        try {
            if (validarCorreo(correoI)) {
                System.out.println("Correo ingresado NO registrado con antelacion, continue con el registro d datos");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            cargarCorreo();
        }
        return correoI;
    }

    public boolean validarCorreo(String correoI) throws Exception {
        boolean validar = false;
        try {
            Collection<Alumno> alumnos = alumnoService.listaAlumnos();
            for (Alumno u : alumnos) {
                if (u.getEmail().equalsIgnoreCase(correoI)) {
                    throw new Exception("Correo electronico ya registrado, ingrese un correo valido");
                }
            }
            validar = true;
        } catch (Exception e) {
            throw e;
        }
        return validar;
    }

 
}
