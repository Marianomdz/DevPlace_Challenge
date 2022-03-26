package Provincias;


import Paises.Pais;

import persistencia.ProvinciaDAO;

import persistencia.PaisDAO;

public class ProvinciaService {

    private final PaisDAO daoPais;
    private final ProvinciaDAO daoProvincia;



    public ProvinciaService() {
        this.daoPais = new PaisDAO();
        this.daoProvincia = new ProvinciaDAO();

    }

    public void crearProvincia(String nombre,int idPais) throws Exception {

        try {

            //Creamos el Provincia
            Provincia provincia = new Provincia();


            //buscamos al la pais
            Pais pais = daoPais.buscarPaisPorId(idPais);
            
            provincia.setNombre(nombre);
            provincia.setFkPais(pais);
            
            daoProvincia.guardarProvincia(provincia);
        } catch (Exception e) {
            System.out.println("No se creeo la Provincia"+ e.getMessage());
        }
    }

     
    }
  
