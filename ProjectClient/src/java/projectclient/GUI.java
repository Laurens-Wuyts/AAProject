/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectclient;

import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import beans.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.naming.*;
import javax.ejb.*;
/**
 *
 * @author r0614393
 */
public class GUI extends JFrame implements ActionListener {
    private final JLabel lbl;
    private final DBBean2Remote db;
    private final Container pane;
    private final JList comp;
    private final List<Integer> pcId;
    
    public GUI() throws NamingException {
        //pr = pbean;
        db = (DBBean2Remote)(new InitialContext().lookup(DBBean2Remote.class.getName()));
        pane = getContentPane();
        FlowLayout layout = new FlowLayout();
        //pane.setLayout(layout);
        
        List<Object[]> pc = db.getMachinesNaam();
        List<String> pcNaam = new ArrayList();
        pcId = new ArrayList();
        for(Object[] obj : pc) {
            pcNaam.add(((String)obj[0]));
            pcId.add((((BigDecimal)obj[1]).intValue()));
        }
        
        lbl = new JLabel("Selecteer computer:");
        comp = new JList(pcNaam.toArray());
        JButton b = new JButton("Print");//creating instance of JButton  
        b.addActionListener(this);
        
        pane.add(lbl, BorderLayout.NORTH);
        pane.add(comp, BorderLayout.CENTER);
        pane.add(b, BorderLayout.SOUTH);//adding button in JFrame  

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setSize(400, 100);
        pack();
        setTitle("Overzicht");
        setVisible(true);//making the frame visible 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        List<Object[]> res = db.getResLoginMid(pcId.get(comp.getSelectedIndex()));
        System.out.println("===============================================================");
        for(Object[] obj : res) {
            Object[] mom = db.getMomRid(((BigDecimal)obj[0]).intValue());
            
            System.out.println("" + ((BigDecimal)obj[0]).toString() + " - " + (String)obj[1] + " - " + ((Date)mom[0]).toString() + " - " + ((BigInteger)mom[1]).toString() + "u");
        }
        System.out.println("===============================================================");
    } 
}
