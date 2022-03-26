package Universidades;

import Localidades.Localidad;
import Provincias.Provincia;
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
@Table(name = "universidades")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Universidades.findAll", query = "SELECT u FROM Universidades u")
//    , @NamedQuery(name = "Universidades.findByIdUniversidad", query = "SELECT u FROM Universidades u WHERE u.idUniversidad = :idUniversidad")
//    , @NamedQuery(name = "Universidades.findByNombre", query = "SELECT u FROM Universidades u WHERE u.nombre = :nombre")})
public class Universidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUniversidad")
    private Integer idUniversidad;
    @Column(name = "Nombre")
    private String nombre;
    @JoinColumn(name = "fk_Provincia", referencedColumnName = "idProvincia")
    @ManyToOne
    private Provincia fkProvincia;
    @JoinColumn(name = "fk_Localidad", referencedColumnName = "idLocalidad")
    @ManyToOne
    private Localidad fkLocalidad;

    public Universidad() {
    }

    public Universidad(Integer idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    public Integer getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(Integer idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getFkProvincia() {
        return fkProvincia;
    }

    public void setFkProvincia(Provincia fkProvincia) {
        this.fkProvincia = fkProvincia;
    }

    public Localidad getFkLocalidad() {
        return fkLocalidad;
    }

    public void setFkLocalidad(Localidad fkLocalidad) {
        this.fkLocalidad = fkLocalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUniversidad != null ? idUniversidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Universidad)) {
            return false;
        }
        Universidad other = (Universidad) object;
        if ((this.idUniversidad == null && other.idUniversidad != null) || (this.idUniversidad != null && !this.idUniversidad.equals(other.idUniversidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Universidades.Universidades[ idUniversidad=" + idUniversidad + " ]";
    }

}
