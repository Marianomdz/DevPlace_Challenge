package persistencia;

import Provincias.Provincia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class ProvinciaDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAModeloBasePU");
    private final EntityManager em = emf.createEntityManager();
                
    public void guardarProvincia(Provincia provincia) throws Exception {
        em.getTransaction().begin();
        em.persist(provincia);       
        em.getTransaction().commit();
    }


    public Provincia buscarProvinciaPorId(int id) throws Exception {
        Provincia provincia = em.find(Provincia.class, id); // Esto que envio es la llave primaria
        return provincia;
    }
 
  
}
