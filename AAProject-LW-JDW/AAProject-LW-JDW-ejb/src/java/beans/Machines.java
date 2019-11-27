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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "MACHINES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Machines.findAll", query = "SELECT m FROM Machines m")
    , @NamedQuery(name = "Machines.findByMid", query = "SELECT m FROM Machines m WHERE m.mid = :mid")
    , @NamedQuery(name = "Machines.findByMnaam", query = "SELECT m FROM Machines m WHERE m.mnaam = :mnaam")
    , @NamedQuery(name = "Machines.findByMinfo", query = "SELECT m FROM Machines m WHERE m.minfo = :minfo")
    , @NamedQuery(name = "Machines.findByMopl", query = "SELECT m FROM Machines m WHERE m.mopl = :mopl")
    , @NamedQuery(name = "Machines.findByMsnr", query = "SELECT m FROM Machines m WHERE m.msnr = :msnr")
    , @NamedQuery(name = "Machines.findByAprs", query = "SELECT m FROM Machines m WHERE m.aprs = :aprs")
    , @NamedQuery(name = "Machines.findByHprs", query = "SELECT m FROM Machines m WHERE m.hprs = :hprs")})
public class Machines implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MID")
    private BigDecimal mid;
    @Size(max = 20)
    @Column(name = "MNAAM")
    private String mnaam;
    @Size(max = 200)
    @Column(name = "MINFO")
    private String minfo;
    @Size(max = 10)
    @Column(name = "MOPL")
    private String mopl;
    @Column(name = "MSNR")
    private BigInteger msnr;
    @Column(name = "APRS")
    private BigInteger aprs;
    @Column(name = "HPRS")
    private BigInteger hprs;
    @OneToMany(mappedBy = "mid")
    private Collection<Momenten> momentenCollection;

    public Machines() {
    }

    public Machines(BigDecimal mid) {
        this.mid = mid;
    }

    public BigDecimal getMid() {
        return mid;
    }

    public void setMid(BigDecimal mid) {
        this.mid = mid;
    }

    public String getMnaam() {
        return mnaam;
    }

    public void setMnaam(String mnaam) {
        this.mnaam = mnaam;
    }

    public String getMinfo() {
        return minfo;
    }

    public void setMinfo(String minfo) {
        this.minfo = minfo;
    }

    public String getMopl() {
        return mopl;
    }

    public void setMopl(String mopl) {
        this.mopl = mopl;
    }

    public BigInteger getMsnr() {
        return msnr;
    }

    public void setMsnr(BigInteger msnr) {
        this.msnr = msnr;
    }

    public BigInteger getAprs() {
        return aprs;
    }

    public void setAprs(BigInteger aprs) {
        this.aprs = aprs;
    }

    public BigInteger getHprs() {
        return hprs;
    }

    public void setHprs(BigInteger hprs) {
        this.hprs = hprs;
    }

    @XmlTransient
    public Collection<Momenten> getMomentenCollection() {
        return momentenCollection;
    }

    public void setMomentenCollection(Collection<Momenten> momentenCollection) {
        this.momentenCollection = momentenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mid != null ? mid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Machines)) {
            return false;
        }
        Machines other = (Machines) object;
        if ((this.mid == null && other.mid != null) || (this.mid != null && !this.mid.equals(other.mid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Machines[ mid=" + mid + " ]";
    }
    
}
