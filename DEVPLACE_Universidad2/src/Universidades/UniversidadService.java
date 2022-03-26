package Universidades;

import Localidades.Localidad;
import Provincias.Provincia;
import persistencia.LocalidadDAO;

import persistencia.ProvinciaDAO;
import persistencia.UniversidadDAO;

public class UniversidadService {


    private final ProvinciaDAO daoProvincia;
    private final LocalidadDAO daoLocalidad;
    private final UniversidadDAO daoUniversidad;

    public UniversidadService() {
        this.daoProvincia = new ProvinciaDAO();
        this.daoLocalidad = new LocalidadDAO();
        this.daoUniversidad = new UniversidadDAO();
    }

    public void crearUniversidad(String nombre, int idProvincia, int idLocalidad) throws Exception {

        try {

            //Creamos el usuario
            Universidad universidad = new Universidad();

            //buscamos al la provincia de la universidad
            Provincia provincia = daoProvincia.buscarProvinciaPorId(idProvincia);

            //buscamos al la Localidad de la universidad
            Localidad localidad = daoLocalidad.buscarLocalidadPorId(idLocalidad);

            universidad.setNombre(nombre);
            universidad.setFkProvincia(provincia);
            universidad.setFkLocalidad(localidad);


            daoUniversidad.guardarUniversidad(universidad);
        } catch (Exception e) {
            System.out.println("No se creeo la Universidad" + e.getMessage());
        }
    }

}
