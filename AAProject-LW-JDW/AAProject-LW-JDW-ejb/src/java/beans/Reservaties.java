/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author r0614941
 */
@Entity
@Table(name = "RESERVATIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservaties.findAll", query = "SELECT r FROM Reservaties r")
    , @NamedQuery(name = "Reservaties.findByRid", query = "SELECT r FROM Reservaties r WHERE r.rid = :rid")})
public class Reservaties implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RID")
    private BigDecimal rid;
    @JoinTable(name = "RESMOM", joinColumns = {
        @JoinColumn(name = "RID", referencedColumnName = "RID")}, inverseJoinColumns = {
        @JoinColumn(name = "MOID", referencedColumnName = "MOID")})
    @ManyToMany
    private Collection<Momenten> momentenCollection;
    @JoinColumn(name = "LOGIN", referencedColumnName = "LOGIN")
    @ManyToOne
    private Gebruikers login;
    @JoinColumn(name = "MID", referencedColumnName = "MID")
    @ManyToOne
    private Machines mid;

    public Reservaties() {
    }

    public Reservaties(BigDecimal rid) {
        this.rid = rid;
    }

    public BigDecimal getRid() {
        return rid;
    }

    public void setRid(BigDecimal rid) {
        this.rid = rid;
    }

    @XmlTransient
    public Collection<Momenten> getMomentenCollection() {
        return momentenCollection;
    }

    public void setMomentenCollection(Collection<Momenten> momentenCollection) {
        this.momentenCollection = momentenCollection;
    }

    public Gebruikers getLogin() {
        return login;
    }

    public void setLogin(Gebruikers login) {
        this.login = login;
    }

    public Machines getMid() {
        return mid;
    }

    public void setMid(Machines mid) {
        this.mid = mid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rid != null ? rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservaties)) {
            return false;
        }
        Reservaties other = (Reservaties) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Reservaties[ rid=" + rid + " ]";
    }
    
}
