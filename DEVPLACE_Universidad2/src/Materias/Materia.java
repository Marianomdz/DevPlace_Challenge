package Materias;

import Carreras.Carrera;
import Notas.Nota;
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
@Table(name = "materias")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Materias.findAll", query = "SELECT m FROM Materias m")
//    , @NamedQuery(name = "Materias.findByIdMateria", query = "SELECT m FROM Materias m WHERE m.idMateria = :idMateria")
//    , @NamedQuery(name = "Materias.findByNombre", query = "SELECT m FROM Materias m WHERE m.nombre = :nombre")})
public class Materia implements Serializable {

    @OneToMany(mappedBy = "fkMateria")
    private Collection<Nota> notasCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMateria")
    private Integer idMateria;
    @Column(name = "Nombre")
    private String nombre;
    @JoinColumn(name = "fk_Carrera", referencedColumnName = "idCarrera")
    @ManyToOne
    private Carrera fkCarrera;

    public Materia() {
    }

    public Materia(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Carrera getFkCarrera() {
        return fkCarrera;
    }

    public void setFkCarrera(Carrera fkCarrera) {
        this.fkCarrera = fkCarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateria != null ? idMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.idMateria == null && other.idMateria != null) || (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Materias.Materias[ idMateria=" + idMateria + " ]";
    }

    @XmlTransient
    public Collection<Nota> getNotasCollection() {
        return notasCollection;
    }

    public void setNotasCollection(Collection<Nota> notasCollection) {
        this.notasCollection = notasCollection;
    }

}
