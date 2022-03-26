package Provincias;

import Localidades.Localidad;
import Paises.Pais;
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
@Table(name = "provincias")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Provincias.findAll", query = "SELECT p FROM Provincias p")
//    , @NamedQuery(name = "Provincias.findByIdProvincia", query = "SELECT p FROM Provincias p WHERE p.idProvincia = :idProvincia")
//    , @NamedQuery(name = "Provincias.findByNombre", query = "SELECT p FROM Provincias p WHERE p.nombre = :nombre")})
public class Provincia implements Serializable {

    @OneToMany(mappedBy = "fkProvincia")
    private Collection<Localidad> localidadesCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProvincia")
    private Integer idProvincia;
    @Column(name = "Nombre")
    private String nombre;
    @JoinColumn(name = "fk_Pais", referencedColumnName = "idPais")
    @ManyToOne
    private Pais fkPais;

    public Provincia() {
    }

    public Provincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getFkPais() {
        return fkPais;
    }

    public void setFkPais(Pais fkPais) {
        this.fkPais = fkPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProvincia != null ? idProvincia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.idProvincia == null && other.idProvincia != null) || (this.idProvincia != null && !this.idProvincia.equals(other.idProvincia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Provincias.Provincias[ idProvincia=" + idProvincia + " ]";
    }

    @XmlTransient
    public Collection<Localidad> getLocalidadesCollection() {
        return localidadesCollection;
    }

    public void setLocalidadesCollection(Collection<Localidad> localidadesCollection) {
        this.localidadesCollection = localidadesCollection;
    }

}
