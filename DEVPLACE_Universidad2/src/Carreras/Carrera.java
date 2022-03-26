package Carreras;

import Alumnos.Alumno;
import Materias.Materia;
import Universidades.Universidad;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
 * @author Mariano_mdz 
 */
@Entity
@Table(name = "carreras")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Carrera.findAll", query = "SELECT c FROM Carrera c")
//    , @NamedQuery(name = "Carrera.findByIdCarrera", query = "SELECT c FROM Carrera c WHERE c.idCarrera = :idCarrera")
//    , @NamedQuery(name = "Carrera.findByNombre", query = "SELECT c FROM Carrera c WHERE c.nombre = :nombre")})
public class Carrera implements Serializable {

    @OneToMany(mappedBy = "fkCarrera")
    private Collection<Materia> materiasCollection;

    @OneToMany(mappedBy = "fkCarrera")
    private Collection<Alumno> alumnosCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCarrera")
    private Integer idCarrera;
    @Column(name = "Nombre")
    private String nombre;
    @JoinColumn(name = "fk_Universidad", referencedColumnName = "idUniversidad")
    @ManyToOne
    private Universidad fkUniversidad;

    public Carrera() {
    }

    public Carrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Universidad getFkUniversidad() {
        return fkUniversidad;
    }

    public void setFkUniversidad(Universidad fkUniversidad) {
        this.fkUniversidad = fkUniversidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarrera != null ? idCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.idCarrera == null && other.idCarrera != null) || (this.idCarrera != null && !this.idCarrera.equals(other.idCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carreras.Carreras[ idCarrera=" + idCarrera + " ]";
    }

    @XmlTransient
    public Collection<Alumno> getAlumnosCollection() {
        return alumnosCollection;
    }

    public void setAlumnosCollection(Collection<Alumno> alumnosCollection) {
        this.alumnosCollection = alumnosCollection;
    }

    @XmlTransient
    public Collection<Materia> getMateriasCollection() {
        return materiasCollection;
    }

    public void setMateriasCollection(Collection<Materia> materiasCollection) {
        this.materiasCollection = materiasCollection;
    }

}
