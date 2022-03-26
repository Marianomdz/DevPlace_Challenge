package Notas;

import Alumnos.Alumno;
import Materias.*;

import persistencia.AlumnoDAO;

import persistencia.MateriaDAO;
import persistencia.NotaDAO;


public class NotaService {
// RECORDAR QUE SIEMPRE, LA LOGICA DEBE ESTAR EN EL SERVICIO CORRESPONDIENTE
    private final NotaDAO daoNota;
    private final MateriaDAO daoMateria;
    private final AlumnoDAO daoAlumno;
    

    public NotaService() {
        this.daoNota = new NotaDAO();
        this.daoMateria = new MateriaDAO();
        this.daoAlumno = new AlumnoDAO();

    }

    public void cargarNota(String nombre,int idAlumno,int idMateria) throws Exception {

        try {

            //Creamos el usuario
            Nota nota = new Nota();


            //buscamos al la Materia 
            Materia materia = daoMateria.buscarMateriaPorId(idMateria);
            //buscamos el Alumno 
            Alumno alumno = daoAlumno.buscarAlumnoPorId(idAlumno);
            
            nota.setNota(nombre);
            nota.setFkMateria(materia);
            nota.setFkAlumno(alumno);
            
            daoNota.guardarNota(nota);
        } catch (Exception e) {
            System.out.println("No se creeo la Provincia"+ e.getMessage());
        }
    }

 
    }
  
