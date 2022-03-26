package persistencia;

import Materias.Materia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class MateriaDAO  {

    //El parametro de este atributo, es COMO SE NOMBRA MI ARCHIVO PERSISTENCIA (persistence.xml, Persistencia Unit Name)
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAModeloBasePU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarMateria(Materia materia) throws Exception { // Este metodo es para ingresar 
        em.getTransaction().begin();
        em.persist(materia); // Para guardar - envio el objeto completo
        em.getTransaction().commit();       
    }

    public Materia buscarMateriaPorId(int idMateria) throws Exception {
        Materia materia = em.find(Materia.class, idMateria); // Para traer objeto con el ID
        return materia;
    }

    //CONSULTA SIN PARAMETROS
    public List<Materia> listarMaterias() throws Exception {
        List<Materia> materias = em.createQuery("SELECT d FROM materias d")
                .getResultList();
        return materias;
    }



}
