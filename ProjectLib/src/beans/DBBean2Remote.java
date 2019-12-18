/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Remote;
import java.util.*;
import java.math.*;
/**
 *
 * @author r0614393
 */
@Remote
public interface DBBean2Remote {
    public Object getGebruiker(String l);
    public List getMomenten();
    public List getMachines();
    public Object getMachineMid(int m);
    public List getMomentenMachine(Object mid);
    public List getVrijMomentenMachine(Object mid);
    public List getResMomentenMachine(Object mid);
    public boolean isFree(Object moid);
    public void MomentToevoegen(String strt,int mid ,String date);
    public void reserveer(int m, int g);
    public void MachineToevoegen(int login, String naam,String info,String msnr,String aprs,String hprs);
    public void MachineAanpassen(Object mid,String naam,String info,String msnr,String aprs,String hprs);
    public List getReservaties(int m);
    public void deleteMachine(Object mid);
    public void deleteMoment(Object moid);
}
