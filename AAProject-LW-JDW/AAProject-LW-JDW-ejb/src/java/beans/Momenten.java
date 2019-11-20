/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author r0614941
 */
@Entity
@Table(name = "MOMENTEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Momenten.findAll", query = "SELECT m FROM Momenten m")
    , @NamedQuery(name = "Momenten.findByMoid", query = "SELECT m FROM Momenten m WHERE m.moid = :moid")
    , @NamedQuery(name = "Momenten.findByStrt", query = "SELECT m FROM Momenten m WHERE m.strt = :strt")
    , @NamedQuery(name = "Momenten.findByDatum", query = "SELECT m FROM Momenten m WHERE m.datum = :datum")})
public class Momenten implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOID")
    private BigDecimal moid;
    @Column(name = "STRT")
    private BigInteger strt;
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @ManyToMany(mappedBy = "momentenCollection")
    private Collection<Reservaties> reservatiesCollection;
    @JoinColumn(name = "MID", referencedColumnName = "MID")
    @ManyToOne
    private Machines mid;

    public Momenten() {
    }

    public Momenten(BigDecimal moid) {
        this.moid = moid;
    }

    public BigDecimal getMoid() {
        return moid;
    }

    public void setMoid(BigDecimal moid) {
        this.moid = moid;
    }

    public BigInteger getStrt() {
        return strt;
    }

    public void setStrt(BigInteger strt) {
        this.strt = strt;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @XmlTransient
    public Collection<Reservaties> getReservatiesCollection() {
        return reservatiesCollection;
    }

    public void setReservatiesCollection(Collection<Reservaties> reservatiesCollection) {
        this.reservatiesCollection = reservatiesCollection;
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
        hash += (moid != null ? moid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Momenten)) {
            return false;
        }
        Momenten other = (Momenten) object;
        if ((this.moid == null && other.moid != null) || (this.moid != null && !this.moid.equals(other.moid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Momenten[ moid=" + moid + " ]";
    }
    
}
