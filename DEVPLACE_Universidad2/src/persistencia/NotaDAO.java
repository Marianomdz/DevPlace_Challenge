package persistencia;

import Notas.Nota;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class NotaDAO  {

    //El parametro de este atributo, es COMO SE NOMBRA MI ARCHIVO PERSISTENCIA (persistence.xml, Persistencia Unit Name)
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAModeloBasePU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarNota(Nota nota) throws Exception { // Este metodo es para ingresar 
        em.getTransaction().begin();
        em.persist(nota); // Para guardar - envio el objeto completo
        em.getTransaction().commit();       
    }


    //CONSULTA SIN PARAMETROS
    public List<Nota> listarNotas() throws Exception {
        List<Nota> notas = em.createQuery("SELECT d FROM notas d")
                .getResultList();
        return notas;
    }



}
