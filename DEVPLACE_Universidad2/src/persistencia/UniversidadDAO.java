package persistencia;

import Universidades.Universidad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class UniversidadDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAModeloBasePU");
    private final EntityManager em = emf.createEntityManager();
                
    public void guardarUniversidad(Universidad universidad) throws Exception {
        em.getTransaction().begin();
        em.persist(universidad);       
        em.getTransaction().commit();
    }


    public Universidad buscarUniversidadPorId(int id) throws Exception {
        Universidad universidad = em.find(Universidad.class, id); // Esto que envio es la llave primaria
        return universidad;
    }

  
}
