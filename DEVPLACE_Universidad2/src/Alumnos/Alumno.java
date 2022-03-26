package Alumnos;

import Carreras.Carrera;
import Notas.Nota;
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
@Table(name = "alumnos")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Alumnos.findAll", query = "SELECT a FROM Alumnos a")
//    , @NamedQuery(name = "Alumnos.findByIdAlumno", query = "SELECT a FROM Alumnos a WHERE a.idAlumno = :idAlumno")
//    , @NamedQuery(name = "Alumnos.findByNombre", query = "SELECT a FROM Alumnos a WHERE a.nombre = :nombre")
//    , @NamedQuery(name = "Alumnos.findByApellido", query = "SELECT a FROM Alumnos a WHERE a.apellido = :apellido")
//    , @NamedQuery(name = "Alumnos.findByTelefono", query = "SELECT a FROM Alumnos a WHERE a.telefono = :telefono")
//    , @NamedQuery(name = "Alumnos.findByEmail", query = "SELECT a FROM Alumnos a WHERE a.email = :email")})
public class Alumno implements Serializable {

    @OneToMany(mappedBy = "fkAlumno")
    private Collection<Nota> notasCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAlumno")
    private Integer idAlumno;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "Email")
    private String email;
    @JoinColumn(name = "fk_Universidad", referencedColumnName = "idUniversidad")
    @ManyToOne
    private Universidad fkUniversidad;
    @JoinColumn(name = "fk_Carrera", referencedColumnName = "idCarrera")
    @ManyToOne
    private Carrera fkCarrera;

    public Alumno() {
    }

    public Alumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Universidad getFkUniversidad() {
        return fkUniversidad;
    }

    public void setFkUniversidad(Universidad fkUniversidad) {
        this.fkUniversidad = fkUniversidad;
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
        hash += (idAlumno != null ? idAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.idAlumno == null && other.idAlumno != null) || (this.idAlumno != null && !this.idAlumno.equals(other.idAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Alumnos.Alumnos[ idAlumno=" + idAlumno + " ]";
    }

    @XmlTransient
    public Collection<Nota> getNotasCollection() {
        return notasCollection;
    }

    public void setNotasCollection(Collection<Nota> notasCollection) {
        this.notasCollection = notasCollection;
    }

}
