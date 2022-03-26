package Alumnos;

import Carreras.Carrera;
import Carreras.CarreraService;
import Localidades.LocalidadService;
import Materias.MateriaService;
import Notas.NotaService;
import Paises.PaisService;
import Provincias.ProvinciaService;
import Universidades.Universidad;
import Universidades.UniversidadService;
import persistencia.AlumnoDAO;

import java.util.Collection;
import java.util.Random;

import persistencia.CarreraDAO;
import persistencia.UniversidadDAO;

public class AlumnoService {

    private final AlumnoDAO daoAlumno;
    private final UniversidadDAO daoUniversidad;
    private final CarreraDAO daoCarrera;

    public AlumnoService() {
        this.daoAlumno = new AlumnoDAO();
        this.daoUniversidad = new UniversidadDAO();
        this.daoCarrera = new CarreraDAO();
    }

    public Alumno crearAlumno(String nombre, String apellido, String telefono, String email, int idUniversidad, int idCarrera) {
        Alumno alumnoNuevo = new Alumno();
        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (apellido == null || apellido.trim().isEmpty()) {
                throw new Exception("Debe indicar la apellido");
            }
            if (telefono == null || telefono.trim().isEmpty()) {
                throw new Exception("Debe indicar el telefono");
            }
            if (email == null || email.trim().isEmpty()) {
                throw new Exception("Debe indicar la email");
            }
            alumnoNuevo.setApellido(apellido);
            alumnoNuevo.setNombre(nombre);
            alumnoNuevo.setEmail(email);
            alumnoNuevo.setTelefono(telefono);

            //buscamos la universidad
            Universidad univesidad = daoUniversidad.buscarUniversidadPorId(idUniversidad);
            alumnoNuevo.setFkUniversidad(univesidad);
            //buscamos al la carrera
            Carrera carrera = daoCarrera.buscarCarreraPorId(idCarrera);
            alumnoNuevo.setFkCarrera(carrera);

            daoAlumno.guardarAlumno(alumnoNuevo);

            return alumnoNuevo;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void imprimirAlumnos() throws Exception {
        try {
            //Listamos los usuarios
            Collection<Alumno> alumnos = listaAlumnos();

            //Imprimimos los usuarios - Solo algunos atributos....
            if (alumnos.isEmpty()) {
                throw new Exception("No existen usuarios para imprimir");
            } else {
                for (Alumno u : alumnos) {
                    System.out.println("*****************************************");
                    System.out.println(" nombre:" + u.getNombre()
                            + "\n Apellido:" + u.getApellido()
                            + "\n Telefono:" + u.getTelefono()
                            + "\n Email:" + u.getEmail()
                            + "\n Universidad:" + u.getFkUniversidad().getNombre()
                            + "\n Provincia:" + u.getFkUniversidad().getFkProvincia().getNombre()
                            + "\n Localidad:" + u.getFkUniversidad().getFkLocalidad().getNombre());
                    //"\n Mascota:" + u.getMascota().getApodo());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    public Collection<Alumno> buscarAlumnoPorCorreoElectronico(String correoElectronico) throws Exception {
        try {

            //Validamos
            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }

            Collection<Alumno> alumno = daoAlumno.buscarAlumnoPorCorreoElectronico(correoElectronico);
            return alumno;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Alumno> mostrarInforme() throws Exception {
        try {
            Collection<Alumno> alumnos = daoAlumno.mostrarInforme();
            return alumnos;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Alumno> listaAlumnos() throws Exception {
        try {
            Collection<Alumno> alumnos = daoAlumno.listarAlumnos();
            return alumnos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void llenardb() throws Exception {
        try {
            PaisService paisS = new PaisService();
            paisS.crearPais("Argentina");
            paisS.crearPais("Chile");
            paisS.crearPais("Brasil");

            ProvinciaService ProvinciaS = new ProvinciaService();
            ProvinciaS.crearProvincia("Mendoza", 1);
            ProvinciaS.crearProvincia("San Juan", 1);
            ProvinciaS.crearProvincia("San Luis", 1);

            LocalidadService localidadS = new LocalidadService();
            localidadS.crearLocalidad("Ciudad", 1);
            localidadS.crearLocalidad("Godoy Cruz", 1);
            localidadS.crearLocalidad("Jachal", 2);
            localidadS.crearLocalidad("Merlo", 3);

            UniversidadService unversidadS = new UniversidadService();
            unversidadS.crearUniversidad("UCA", 1, 2);
            unversidadS.crearUniversidad("uncuyo", 1, 1);
            unversidadS.crearUniversidad("Champagnat", 1, 2);
            unversidadS.crearUniversidad("U de San Juan", 2, 3);
            unversidadS.crearUniversidad("U de San Luis", 3, 4);

            // cargo Carreras a cada Universidad        
            CarreraService carreaS = new CarreraService();

            for (int i = 1; i < 6; i++) {
                String nombre = "Lic en sistemas" + i;
                int universidad = i;
                String nombre1 = "Enfermeria" + i;
                int universidad1 = i;
                String nombre2 = "Psicologia" + i;
                int universidad2 = i;
                String nombre3 = "RRHH" + i;
                int universidad3 = i;

                carreaS.crearCarrera(nombre, universidad);
                carreaS.crearCarrera(nombre1, universidad1);
                carreaS.crearCarrera(nombre2, universidad2);
                carreaS.crearCarrera(nombre3, universidad3);

            }

            // cargo Materias a cada carrera
            MateriaService materiaS = new MateriaService();
            for (int i = 1; i < 10; i++) {

                materiaS.crearMateria("Matematica", i);
                materiaS.crearMateria("Literatura", i);
                materiaS.crearMateria("Programacion 1", i);
                materiaS.crearMateria("Lengua", i);
                materiaS.crearMateria("Programacion 1", i);
                materiaS.crearMateria("Anallisis Matematico", i);
                materiaS.crearMateria("Algebra", i);
                materiaS.crearMateria("Programacion 2", i);
                materiaS.crearMateria("Literatura 2", i);
                materiaS.crearMateria("Matematica 2", i);
                materiaS.crearMateria("Lengua 2", i);
                materiaS.crearMateria("Programacion 3", i);
                materiaS.crearMateria("Anallisis Matematico 2", i);
                materiaS.crearMateria("Algebra 2", i);

            }

            // Cargo los Alumnos
            AlumnoService alumnoS = new AlumnoService();
            // Instanciamos la clase Random para poder generar notaas aleatorias
            Random random = new Random();
            // cargo Notas a cada Materia del alumno        
            NotaService notaS = new NotaService();

            for (int i = 1; i < 10; i++) {
                String nombre = "Mariano" + i;
                String apellido = "Velasco" + i;
                String email = "02613456860" + i;
                String telefono = "mail" + i + "@mail.com";
                int universidad = 1;
                int carrera = 1;

                alumnoS.crearAlumno(nombre, apellido, telefono, email, universidad, carrera);

                for (int j = 1; j < 15; j++) {
                    String nota = "" + random.nextInt(10) + "";

                    int idalumno = i;
                    int idmateria = i;

                    notaS.cargarNota(nota, idalumno, idmateria);

                }

            }

            for (int i = 1; i < 10; i++) {
                String nombre = "silvina" + i;
                String apellido = "Gonzalez" + i;
                String email = "026133556" + i;
                String telefono = "email" + i + "@mail.com";
                int universidad = 2;
                int carrera = 3;
                alumnoS.crearAlumno(nombre, apellido, telefono, email, universidad, carrera);

                for (int j = 1; j < 15; j++) {
                    String nota = "" + random.nextInt(10) + "";

                    int idalumno = i;
                    int idmateria = i;

                    notaS.cargarNota(nota, idalumno, idmateria);

                }
            }
            for (int i = 1; i < 10; i++) {
                String nombre = "Augusto" + i;
                String apellido = "Pena" + i;
                String email = "02612251" + i;
                String telefono = "email" + i + "@gmail.com";
                int universidad = 3;
                int carrera = 5;
                alumnoS.crearAlumno(nombre, apellido, telefono, email, universidad, carrera);

                for (int j = 1; j < 15; j++) {
                    String nota = "" + random.nextInt(10) + "";

                    int idalumno = i;
                    int idmateria = i;

                    notaS.cargarNota(nota, idalumno, idmateria);

                }
            }
            for (int i = 1; i < 10; i++) {
                String nombre = "Bernardo" + i;
                String apellido = "Penesi" + i;
                String email = "026133256" + i;
                String telefono = "1email" + i + "@mail.com";
                int universidad = 4;
                int carrera = 9;
                alumnoS.crearAlumno(nombre, apellido, telefono, email, universidad, carrera);

                for (int j = 1; j < 15; j++) {
                    String nota = "" + random.nextInt(10) + "";

                    int idalumno = i;
                    int idmateria = i;

                    notaS.cargarNota(nota, idalumno, idmateria);

                }
            }

            for (int i = 1; i < 10; i++) {
                String nombre = "Lorena" + i;
                String apellido = "Poni" + i;
                String email = "026233556" + i;
                String telefono = "2email" + i + "@mail.com";
                int universidad = 5;
                int carrera = 12;
                alumnoS.crearAlumno(nombre, apellido, telefono, email, universidad, carrera);

                for (int j = 1; j < 15; j++) {
                    String nota = "" + random.nextInt(10) + "";

                    int idalumno = i;
                    int idmateria = i;

                    notaS.cargarNota(nota, idalumno, idmateria);

                }
            }

            for (int i = 1; i < 10; i++) {
                String nombre = "Vaniva" + i;
                String apellido = "Guerra" + i;
                String email = "026333556" + i;
                String telefono = "3email" + i + "@mail.com";
                int universidad = 5;
                int carrera = 15;
                alumnoS.crearAlumno(nombre, apellido, telefono, email, universidad, carrera);

                for (int j = 1; j < 15; j++) {
                    String nota = "" + random.nextInt(10) + "";

                    int idalumno = i;
                    int idmateria = i;

                    notaS.cargarNota(nota, idalumno, idmateria);

                }
            }
            for (int i = 1; i < 10; i++) {
                String nombre = "Carolina" + i;
                String apellido = "Victoria" + i;
                String email = "026433556" + i;
                String telefono = "4email" + i + "@mail.com";
                int universidad = 5;
                int carrera = 18;
                alumnoS.crearAlumno(nombre, apellido, telefono, email, universidad, carrera);

                for (int j = 1; j < 15; j++) {
                    String nota = "" + random.nextInt(10) + "";

                    int idalumno = i;
                    int idmateria = i;

                    notaS.cargarNota(nota, idalumno, idmateria);

                }
            }
            for (int i = 1; i < 10; i++) {
                String nombre = "Fernanda" + i;
                String apellido = "Ibanez" + i;
                String email = "026533556" + i;
                String telefono = "5email" + i + "@mail.com";
                int universidad = 5;
                int carrera = 20;
                alumnoS.crearAlumno(nombre, apellido, telefono, email, universidad, carrera);

                for (int j = 1; j < 15; j++) {
                    String nota = "" + random.nextInt(10) + "";

                    int idalumno = i;
                    int idmateria = i;

                    notaS.cargarNota(nota, idalumno, idmateria);

                }
            }

        } catch (Exception e) {
            throw e;
        }

    }

}
