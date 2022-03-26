package persistencia;

import Alumnos.Alumno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class AlumnoDAO  {

    //El parametro de este atributo, es COMO SE NOMBRA MI ARCHIVO PERSISTENCIA (persistence.xml, Persistencia Unit Name)
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAModeloBasePU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarAlumno(Alumno alumno) throws Exception { // Este metodo es para ingresar 
        em.getTransaction().begin();
        em.persist(alumno); // Para guardar - envio el objeto completo
        em.getTransaction().commit();       
    }

    public Alumno buscarAlumnoPorId(int idAlumno) throws Exception {
        Alumno alumno = em.find(Alumno.class, idAlumno); // Para traer objeto con el ID
        return alumno;
    }

    //CONSULTA SIN PARAMETROS
    public List<Alumno> listarAlumnos() throws Exception {
        List<Alumno> alumnos = em.createQuery("SELECT d FROM Alumno d")
                .getResultList();
        return alumnos;
    }

    //CONSULTA SIN PARAMETROS
    public List<Alumno> mostrarInforme() throws Exception {
        List<Alumno> alumnos = em.createQuery("SELECT a.Nombre, a.Apellido, a.Telefono, a.email, u.nombre, p.nombre, l.nombre FROM alumnos a, notas n, universidades u, provincias p, localidades l WHERE n.Nota >= 7")
                .getResultList();
        return alumnos;
    }    
    
    
    //CONSULTA CON PARAMETROS

    public List<Alumno> buscarAlumnoPorCorreoElectronico(String correoElectronico) throws Exception {
        List<Alumno> alumno = em.createQuery("SELECT d "
                + " FROM alumnos d"
                + " WHERE d.Email LIKE :correoElectronico").
                setParameter("correoElectronico", correoElectronico).
                getResultList();      
        return alumno;
    }    
    
}
