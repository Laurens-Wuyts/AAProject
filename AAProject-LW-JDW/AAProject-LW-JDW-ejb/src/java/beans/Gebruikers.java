/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author r0614941
 */
@Entity
@Table(name = "GEBRUIKERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gebruikers.findAll", query = "SELECT g FROM Gebruikers g")
    , @NamedQuery(name = "Gebruikers.findByLogin", query = "SELECT g FROM Gebruikers g WHERE g.login = :login")
    , @NamedQuery(name = "Gebruikers.findByPwd", query = "SELECT g FROM Gebruikers g WHERE g.pwd = :pwd")
    , @NamedQuery(name = "Gebruikers.findByGnaam", query = "SELECT g FROM Gebruikers g WHERE g.gnaam = :gnaam")
    , @NamedQuery(name = "Gebruikers.findByOpl", query = "SELECT g FROM Gebruikers g WHERE g.opl = :opl")})
public class Gebruikers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LOGIN")
    private String login;
    @Size(max = 20)
    @Column(name = "PWD")
    private String pwd;
    @Size(max = 20)
    @Column(name = "GNAAM")
    private String gnaam;
    @Size(max = 10)
    @Column(name = "OPL")
    private String opl;
    @OneToMany(mappedBy = "login")
    private Collection<Reservaties> reservatiesCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "gebruikers")
    private Groepen groepen;

    public Gebruikers() {
    }

    public Gebruikers(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getGnaam() {
        return gnaam;
    }

    public void setGnaam(String gnaam) {
        this.gnaam = gnaam;
    }

    public String getOpl() {
        return opl;
    }

    public void setOpl(String opl) {
        this.opl = opl;
    }

    @XmlTransient
    public Collection<Reservaties> getReservatiesCollection() {
        return reservatiesCollection;
    }

    public void setReservatiesCollection(Collection<Reservaties> reservatiesCollection) {
        this.reservatiesCollection = reservatiesCollection;
    }

    public Groepen getGroepen() {
        return groepen;
    }

    public void setGroepen(Groepen groepen) {
        this.groepen = groepen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gebruikers)) {
            return false;
        }
        Gebruikers other = (Gebruikers) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Gebruikers[ login=" + login + " ]";
    }
    
}
