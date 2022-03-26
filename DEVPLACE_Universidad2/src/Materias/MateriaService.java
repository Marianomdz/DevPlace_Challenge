package Materias;

import Carreras.Carrera;

import persistencia.CarreraDAO;

import persistencia.MateriaDAO;

public class MateriaService {

    private final CarreraDAO daoCarrera;
    private final MateriaDAO daoMateria;

    public MateriaService() {
        this.daoCarrera = new CarreraDAO();
        this.daoMateria = new MateriaDAO();

    }

    public void crearMateria(String nombre,int idCarrera) throws Exception {

        try {

            //Creamos el usuario
            Materia materia = new Materia();


            //buscamos al la Universidad 
            Carrera carrera = daoCarrera.buscarCarreraPorId(idCarrera);
            
            materia.setNombre(nombre);
            materia.setFkCarrera(carrera);
           
            daoMateria.guardarMateria(materia);
        } catch (Exception e) {
            System.out.println("No se creeo la Provincia"+ e.getMessage());
        }
    }

    
    }
  
