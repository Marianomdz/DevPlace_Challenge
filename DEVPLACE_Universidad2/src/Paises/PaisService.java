package Paises;

import persistencia.ProvinciaDAO;

import persistencia.PaisDAO;

public class PaisService {

    private final PaisDAO daoPais;
    private final ProvinciaDAO daoProvincia;

    public PaisService() {
        this.daoPais = new PaisDAO();
        this.daoProvincia = new ProvinciaDAO();

    }

    public void crearPais(String nombre) throws Exception {

        try {

            //Creamos el pais
            Pais pais = new Pais();

            
            pais.setNombre(nombre);
           
            daoPais.guardarPais(pais);
        } catch (Exception e) {
            System.out.println("No se creeo el Pais"+ e.getMessage());
        }
    }

 
    }
  
