package persistencia;

import Carreras.Carrera;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class CarreraDAO  {

    //El parametro de este atributo, es COMO SE NOMBRA MI ARCHIVO PERSISTENCIA (persistence.xml, Persistencia Unit Name)
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAModeloBasePU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarCarrera(Carrera carrera) throws Exception { // Este metodo es para ingresar 
        em.getTransaction().begin();
        em.persist(carrera); // Para guardar - envio el objeto completo
        em.getTransaction().commit();       
    }

    public Carrera buscarCarreraPorId(int idCarrera) throws Exception {
        Carrera carrera = em.find(Carrera.class, idCarrera); // Para traer objeto con el ID
        return carrera;
    }

    //CONSULTA SIN PARAMETROS
    public List<Carrera> listarCarreras() throws Exception {
        List<Carrera> carrera = em.createQuery("SELECT d FROM materias d")
                .getResultList();
        return carrera;
    }



}
