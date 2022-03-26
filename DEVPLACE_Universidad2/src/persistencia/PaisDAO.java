package persistencia;

import Paises.Pais;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class PaisDAO  {

    //El parametro de este atributo, es COMO SE NOMBRA MI ARCHIVO PERSISTENCIA (persistence.xml, Persistencia Unit Name)
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAModeloBasePU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarPais(Pais pais) throws Exception { // Este metodo es para ingresar 
        em.getTransaction().begin();
        em.persist(pais); // Para guardar - envio el objeto completo
        em.getTransaction().commit();       
    }

    public Pais buscarPaisPorId(int id) throws Exception {
        Pais pais = em.find(Pais.class, id); // Para traer objeto con el ID
        return pais;
    }

    //CONSULTA SIN PARAMETROS
    public List<Pais> listarPaises() throws Exception {
        List<Pais> paises = em.createQuery("SELECT d FROM paises d")
                .getResultList();
        return paises;
    }



}
