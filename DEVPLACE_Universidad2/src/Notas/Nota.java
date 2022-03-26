package Notas;

import Alumnos.Alumno;
import Materias.Materia;
import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * @author Mariano_mdz 
 */
@Entity
@Table(name = "notas")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Notas.findAll", query = "SELECT n FROM Notas n")
//   , @NamedQuery(name = "Notas.findByIdNota", query = "SELECT n FROM Notas n WHERE n.idNota = :idNota")
//    , @NamedQuery(name = "Notas.findByNota", query = "SELECT n FROM Notas n WHERE n.nota = :nota")})
public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNota")
    private Integer idNota;
    @Column(name = "Nota")
    private String nota;
    @JoinColumn(name = "fk_Materia", referencedColumnName = "idMateria")
    @ManyToOne
    private Materia fkMateria;
    @JoinColumn(name = "fk_Alumno", referencedColumnName = "idAlumno")
    @ManyToOne
    private Alumno fkAlumno;

    public Nota() {
    }

    public Nota(Integer idNota) {
        this.idNota = idNota;
    }

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Materia getFkMateria() {
        return fkMateria;
    }

    public void setFkMateria(Materia fkMateria) {
        this.fkMateria = fkMateria;
    }

    public Alumno getFkAlumno() {
        return fkAlumno;
    }

    public void setFkAlumno(Alumno fkAlumno) {
        this.fkAlumno = fkAlumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNota != null ? idNota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nota)) {
            return false;
        }
        Nota other = (Nota) object;
        if ((this.idNota == null && other.idNota != null) || (this.idNota != null && !this.idNota.equals(other.idNota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Notas.Notas[ idNota=" + idNota + " ]";
    }

}
