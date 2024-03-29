package Localidades;

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
@Table(name = "localidades")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Localidades.findAll", query = "SELECT l FROM Localidades l")
//    , @NamedQuery(name = "Localidades.findByIdLocalidad", query = "SELECT l FROM Localidades l WHERE l.idLocalidad = :idLocalidad")
//    , @NamedQuery(name = "Localidades.findByNombre", query = "SELECT l FROM Localidades l WHERE l.nombre = :nombre")})
public class Localidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLocalidad")
    private Integer idLocalidad;
    @Column(name = "Nombre")
    private String nombre;
    @JoinColumn(name = "fk_Provincia", referencedColumnName = "idProvincia")
    @ManyToOne
    private Provincia fkProvincia;

    public Localidad() {
    }

    public Localidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public Integer getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocalidad != null ? idLocalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidad)) {
            return false;
        }
        Localidad other = (Localidad) object;
        if ((this.idLocalidad == null && other.idLocalidad != null) || (this.idLocalidad != null && !this.idLocalidad.equals(other.idLocalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Localidades.Localidades[ idLocalidad=" + idLocalidad + " ]";
    }

}
