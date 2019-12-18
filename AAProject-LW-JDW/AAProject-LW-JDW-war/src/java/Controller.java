/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.*;
import java.net.*;
import java.util.*;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.time.YearMonth;

/**
 *
 * @author r0614393
 */
@WebServlet(urlPatterns = {"/ctrl.do"})
public class Controller extends HttpServlet {
    @EJB private DBBean2Remote Bean;
    private YearMonth y;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessie=request.getSession();
               
        if(request.getParameterMap().containsKey("btn")){
            switch (request.getParameter("btn")) {
                case "Logout":
                {
                    sessie.invalidate();
                    response.sendRedirect("ctrl.do" );
                    return;
                }
                case "Overzicht":
                {
                    reloadMachines();
                    RequestDispatcher view = request.getRequestDispatcher ("overzicht.jsp" );
                    view.forward (request,response );
                    break;
                }
                  case "Verwijder":
                {
                    Machines m = (Machines) Bean.getMachineMid(Integer.parseInt(request.getParameter("mid")));
                    Bean.deleteMachine(m);
                    reloadMachines();
                    RequestDispatcher view = request.getRequestDispatcher ("overzicht.jsp" );
                    view.forward (request,response );
                    break;
                }
                 case "Toevoegen":
                {  
                    RequestDispatcher view = request.getRequestDispatcher ("toevoegen.jsp" );
                    view.forward (request,response );
                    break;
                }
                case "Toepassen":
                {
                    
                    int t = Bean.MachineToevoegen((String)sessie.getAttribute("login"), request.getParameter("naam"), request.getParameter("info"), request.getParameter("nr"), request.getParameter("aprs"), request.getParameter("hprs"));
                    reloadMachines();
                    Machines m = (Machines) Bean.getMachineMid(t);  
                    sessie.setAttribute("m",m);
                    RequestDispatcher view = request.getRequestDispatcher ("details.jsp" );
                    view.forward (request,response );
                    break;
                }
                case "Vorige maand":
                {
                    
                    this.y=this.y.minusMonths(1);
                    sessie.setAttribute("date",y);  
                    RequestDispatcher view = request.getRequestDispatcher ("reservaties.jsp" );
                    view.forward (request,response );
                    break;
                }
                case "Volgende maand":
                {
                    this.y=this.y.plusMonths(1);
                    sessie.setAttribute("date",y);  
                    RequestDispatcher view = request.getRequestDispatcher ("reservaties.jsp" );
                    view.forward (request,response );
                    break;
                }
                 case "Moment Toevoegen":
                {
                    
                    Bean.MomentToevoegen( request.getParameter("strt"), sessie.getAttribute("m"),request.getParameter("date"));
                    reloadMachines();
                    RequestDispatcher view = request.getRequestDispatcher ("details.jsp" );
                    view.forward (request,response );
                    break;
                }
                   case "ResMom":
                {
                    Momenten mom = (Momenten) Bean.getMomentenMoid(Integer.parseInt(request.getParameter("moid")));
                    sessie.setAttribute("mom", mom);
                    RequestDispatcher view = request.getRequestDispatcher ("prijs.jsp" );
                    view.forward (request,response );
                    break;
                }
                  case "Akkoord":
                {
                    int m = Integer.parseInt((String)sessie.getAttribute("moid")); 
                    Bean.reserveer(m, (String)sessie.getAttribute("login"));
                    RequestDispatcher view = request.getRequestDispatcher ("overzicht.jsp" );
                    view.forward (request,response );
                    break;
                }
                case "Aanpassen": 
                {
                    Machines m = (Machines) Bean.getMachineMid(Integer.parseInt(request.getParameter("mid")));           
                    Bean.MachineAanpassen(m, request.getParameter("naam"), request.getParameter("info"), request.getParameter("nr"), request.getParameter("aprs"), request.getParameter("hprs"));
                    reloadMachines();
                    m = (Machines) Bean.getMachineMid(Integer.parseInt(request.getParameter("mid")));  
                    sessie.setAttribute("m",m);
                    RequestDispatcher view = request.getRequestDispatcher ("details.jsp" );
                    view.forward (request,response );
                    break;
                }
                case "Edit":
                {
                    Machines m = (Machines) Bean.getMachineMid(Integer.parseInt(request.getParameter("mid")));
                    sessie.setAttribute("m",m);
                    RequestDispatcher view = request.getRequestDispatcher ("edit.jsp" );
                    view.forward (request,response );
                    break;
                }
                case "Details":
                {
                    Machines m = (Machines) Bean.getMachineMid(Integer.parseInt(request.getParameter("mid")));
                    sessie.setAttribute("m",m);
                    RequestDispatcher view = request.getRequestDispatcher ("details.jsp" );
                    view.forward (request,response );
                    break;
                }
                case "Reserveer":
                {   
                    if (request.getParameter("mid")!=null){ 
                           Machines m = (Machines) Bean.getMachineMid(Integer.parseInt(request.getParameter("mid")));
                           sessie.setAttribute("m",m);
                    }
                    Machines ma = (Machines)sessie.getAttribute("m");
                    List<Momenten> momres = new ArrayList<>();
                    List<Momenten> mom = Bean.getMomentenMachine(ma);
                    for(int i=0;i<mom.size();){
                        if(!Bean.isFree(mom.get(i))) {
                            momres.add(mom.get(i));
                            mom.remove(i);
                            
                        } 
                        else{
                            i++;
                        }
                    }
                    sessie.setAttribute("momvrij",mom);
                    sessie.setAttribute("momres",momres);
                    sessie.setAttribute("date",y);                    
                    RequestDispatcher view = request.getRequestDispatcher ("reservaties.jsp" );
                    view.forward (request,response );
                    break;
                }
               default:
                RequestDispatcher view = request.getRequestDispatcher ("overzicht.jsp" );
                    view.forward (request,response );
               }
        }
        if (sessie.getAttribute("type")==null){
            String name = request.getUserPrincipal().getName();
            sessie.setAttribute("login",name);
            sessie.setAttribute("gebruiker",Bean.getGebruiker(name));
            if (request.isUserInRole("Docent")){

                sessie.setAttribute("type","Docent");
                RequestDispatcher view = request.getRequestDispatcher ("overzicht.jsp" );
                view.forward (request,response );
            }
            else if (request.isUserInRole("Student")){
                sessie.setAttribute("type","Student");
                RequestDispatcher view = request.getRequestDispatcher ("overzicht.jsp" );
                view.forward (request,response );
            }
            else{
                sessie.setAttribute("type","Extern");
                RequestDispatcher view = request.getRequestDispatcher ("overzicht.jsp" );
                view.forward (request,response );
            }
            
           }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 
        processRequest(request, response);
    
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
 @Override
    public void init(){
        reloadMachines();
        this.y = YearMonth.now();
        
    }
    public void reloadMachines(){
        List<Machines> ma= Bean.getMachines();
        getServletContext().setAttribute("machines",ma);
    }
}
