/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.math.*;
import java.text.ParseException;
import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author r0614393
 */
@Stateless
public class DBBean2 implements DBBean2Remote {
@PersistenceContext private EntityManager em;


    public DBBean2(){}

    @Override
    public Object getGebruiker(String l){
    Gebruikers gebr = (Gebruikers) em.createNamedQuery("Gebruikers.findByLogin").setParameter("login",l).getSingleResult();
               return gebr;
    }
     @Override
    public List getMomenten(){
       List mom = em.createNamedQuery("Momenten.findAll").getResultList();
               return mom;
    }
    @Override
   public List getMachines(){
      List ma = em.createNamedQuery("Machines.findAll").getResultList();
              return ma;
   }
   @Override
   public Object getMachineMid(int m){
      BigDecimal mid= new BigDecimal(m);
      Object ma = em.createQuery("SELECT m FROM Machines m WHERE m.mid = :mid").setParameter("mid",mid).getSingleResult();
              return ma;
   }
   @Override
    public List getMomentenMachine(Object mid){
               List mom = em.createQuery("SELECT m FROM Momenten m WHERE m.mid = :mid").setParameter("mid",mid).getResultList();
               return mom;
    }
    @Override
      public List getResMomentenMachine(Object mid){
               List mom = em.createQuery("SELECT m FROM Momenten m,Reservaties r WHERE m.mid = :mid and m.moid =r.moid").setParameter("mid",mid).getResultList();
               return mom;
    }
      @Override
      public List getVrijMomentenMachine(Object mid){
               List mom = em.createQuery("SELECT m FROM Momenten m WHERE m.mid = :mid and m.moid not in(SELECT moid FROM Reservaties r").setParameter("mid",mid).getResultList();
               return mom;
    }
     @Override
    public boolean isFree(Object moid){
           Reservaties res = (Reservaties) em.createQuery("SELECT r FROM Reservaties r WHERE r.moid = :moid").setParameter("moid",moid).getSingleResult();
           return (res==null) ;
    }
    @Override
    public void reserveer(int m, int g){
        int nr;
        try{
        BigDecimal res;
        res =(BigDecimal) em.createQuery("SELECT max(r.rid) FROM Reservaties r").getSingleResult();
        
        nr= res.intValue();
        }
        catch(Exception e)
        {
            nr=0;
                          }
        Momenten mom= (Momenten) em.createNamedQuery("Momenten.findByMoid").setParameter("moid",new BigDecimal(m)).getSingleResult();
        Gebruikers gebr = (Gebruikers) em.createNamedQuery("Gebruikers.findByLogin").setParameter("login",new BigDecimal(g)).getSingleResult();
        BigDecimal bd= new BigDecimal(nr+1);
        Reservaties Res= new Reservaties(bd);
        Res.setLogin(gebr);
        Res.setMoid(mom);
        em.persist(Res);

    }
    @Override
    public void MomentToevoegen(String strt,int mid ,String date){
        int nr;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try{            
        BigDecimal res;
        res =(BigDecimal) em.createQuery("SELECT max(m.moid) FROM Momenten m").getSingleResult();
        
        nr= res.intValue();
        }
        catch(Exception e)
        {
            nr=0;
                          }
        BigDecimal bd= new BigDecimal(nr+1);
        Momenten mom= new Momenten(bd);
        mom.setStrt(new BigInteger(strt));
        try {
            Date d = df.parse (date);
            mom.setDatum(d);
        } catch (ParseException ex) {
            Logger.getLogger(DBBean2.class.getName()).log(Level.SEVERE, null, ex);
        }
        em.persist(mom);

    }
    @Override
    public void MachineToevoegen(int login, String naam,String info,String msnr,String aprs,String hprs){
        int nr;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try{            
        BigDecimal res;
        res =(BigDecimal) em.createQuery("SELECT max(m.mid) FROM Machines m").getSingleResult();
        
        nr= res.intValue();
        }
        catch(Exception e)
        {
            nr=0;
                          }
        BigDecimal bd= new BigDecimal(nr+1);
        Machines mach= new Machines(bd);
        String opl = (String) em.createQuery("SELECT g.opl FROM Gebruikers g WHERE g.login = :login").setParameter("login",new BigDecimal(login)).getSingleResult();
        mach.setMopl(opl);
        mach.setMnaam(naam);
        mach.setMinfo(info);
        mach.setMsnr(new BigInteger(msnr));
        mach.setAprs(new BigInteger(aprs));
        mach.setHprs(new BigInteger(hprs));
        em.persist(mach);

    }
    @Override
    public void deleteMachine(int mid) {
        Machines r = em.createNamedQuery("Machines.findByMid", Machines.class).setParameter("mid", new BigDecimal(mid)).getSingleResult();
        em.remove(r);
    }
     public void deleteMoment(int moid) {
        Momenten r = em.createNamedQuery("Momenten.findByMoid", Momenten.class).setParameter("moid", new BigDecimal(moid)).getSingleResult();
        em.remove(r);
    }
    @Override
     public List getReservaties(int m){
	
         List<Reservaties> res= em.createQuery("SELECT r FROM Reservaties r, Momenten m WHERE m.mid =:mid and m.moid=r.moid").setParameter("mid",new BigDecimal(m)).getResultList();
         return res;
     }
}

