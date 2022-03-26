package Localidades;

import Provincias.*;

import persistencia.ProvinciaDAO;

import persistencia.LocalidadDAO;


public class LocalidadService {

    private final ProvinciaDAO daoProvincia;
    private final LocalidadDAO daoLocalidad;

    public LocalidadService() {

        this.daoProvincia = new ProvinciaDAO();
        this.daoLocalidad = new LocalidadDAO();

    }

    public void crearLocalidad(String nombre,int idProvincia) throws Exception {

        try {

            //Creamos la Localidad
            Localidad localidad = new Localidad();

            //buscamos al la provincia de la universidad
            Provincia provincia = daoProvincia.buscarProvinciaPorId(idProvincia);
            
            localidad.setNombre(nombre);
            localidad.setFkProvincia(provincia);
           
            daoLocalidad.guardarLocalidad(localidad);
        } catch (Exception e) {
            System.out.println("No se creeo la Provincia"+ e.getMessage());
        }
    }

    
    }
  
