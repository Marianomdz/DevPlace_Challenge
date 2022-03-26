package Carreras;

import Universidades.*;

import persistencia.CarreraDAO;
import persistencia.UniversidadDAO;

public class CarreraService {

    private final UniversidadDAO daoUniversidad;
    private final CarreraDAO daoCarrera;

    public CarreraService() {
        this.daoUniversidad = new UniversidadDAO();
        this.daoCarrera = new CarreraDAO();

    }

    public void crearCarrera(String nombre, int idUniversidad) throws Exception {

        try {

            //Creamos el Carrera
            Carrera carrera = new Carrera();

            //buscamos al la Universidad 
            Universidad universidad = daoUniversidad.buscarUniversidadPorId(idUniversidad);

            carrera.setNombre(nombre);
            carrera.setFkUniversidad(universidad);

            daoCarrera.guardarCarrera(carrera);
        } catch (Exception e) {
            System.out.println("No se creeo la Provincia" + e.getMessage());
        }
    }


}
