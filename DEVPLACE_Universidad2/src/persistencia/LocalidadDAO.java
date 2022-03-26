package persistencia;

import Localidades.Localidad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class LocalidadDAO  {

    //El parametro de este atributo, es COMO SE NOMBRA MI ARCHIVO PERSISTENCIA (persistence.xml, Persistencia Unit Name)
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAModeloBasePU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarLocalidad(Localidad localidad) throws Exception { // Este metodo es para ingresar 
        em.getTransaction().begin();
        em.persist(localidad); // Para guardar - envio el objeto completo
        em.getTransaction().commit();       
    }

    public Localidad buscarLocalidadPorId(int id) throws Exception {
        Localidad localidad = em.find(Localidad.class, id); // Para traer objeto con el ID
        return localidad;
    }



}
