/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.arquitectura.student.entity.Inscripcion;
import co.edu.unipiloto.arquitectura.student.session.CursoFacadeLocal;
import co.edu.unipiloto.arquitectura.student.session.InscripcionFacadeLocal;
import co.edu.unipiloto.arquitectura.student.session.StudentFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "InscripcionServlet", urlPatterns = {"/InscripcionServlet"})
public class InscripcionServlet extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;
    
    @EJB
    private CursoFacadeLocal cursoFacade;

    @EJB
    private InscripcionFacadeLocal inscripcionFacade;
    
    
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
        response.setContentType("text/html;charset=UTF-8");
        
        String action=request.getParameter("action");
        
        String codigoInscripcionStr=request.getParameter("codigoInscripcion");
        Integer codigoInscripcion = new Integer(codigoInscripcionStr);
        
        if (action.equals("Add")) {
            String studentIdStr=request.getParameter("studentId");
            Integer studentId = new Integer(studentIdStr);
            String codigoCursoStr=request.getParameter("codigoCurso");
            Integer codigoCurso = new Integer(codigoCursoStr);
            Inscripcion inscripcion = new Inscripcion(codigoInscripcion,cursoFacade.find(codigoCurso),studentFacade.find(studentId));
            
            
            inscripcionFacade.create(inscripcion);
            
            request.setAttribute("allInscripciones", inscripcionFacade.findAll());
            request.setAttribute("allCursos", cursoFacade.findAll());
            request.setAttribute("allStudents", studentFacade.findAll());
            request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
        } else if(action.equals("Edit")){
            String studentIdStr=request.getParameter("studentId");
            Integer studentId = new Integer(studentIdStr);
            String codigoCursoStr=request.getParameter("codigoCurso");
            Integer codigoCurso = new Integer(codigoCursoStr);
            Inscripcion inscripcion = new Inscripcion(codigoInscripcion,cursoFacade.find(codigoCurso),studentFacade.find(studentId));
            
            inscripcionFacade.edit(inscripcion);
            
            request.setAttribute("allInscripciones", inscripcionFacade.findAll());
            request.setAttribute("allCursos", cursoFacade.findAll());
            request.setAttribute("allStudents", studentFacade.findAll());
            request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
        } else if(action.equals("Delete")){
            String studentIdStr=request.getParameter("studentId");
            Integer studentId = new Integer(studentIdStr);
            String codigoCursoStr=request.getParameter("codigoCurso");
            Integer codigoCurso = new Integer(codigoCursoStr);
            Inscripcion inscripcion = new Inscripcion(codigoInscripcion,cursoFacade.find(codigoCurso),studentFacade.find(studentId));
            
            inscripcionFacade.remove(inscripcion);
            
            request.setAttribute("allInscripciones", inscripcionFacade.findAll());
            request.setAttribute("allCursos", cursoFacade.findAll());
            request.setAttribute("allStudents", studentFacade.findAll());
            request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
        } else if(action.equals("Search")){
            List inscripciones=new ArrayList();
            inscripciones.add(inscripcionFacade.find(codigoInscripcion));
            
            request.setAttribute("allInscripcion", inscripciones);
            request.setAttribute("allCursos", cursoFacade.findAll());
            request.setAttribute("allStudents", studentFacade.findAll());
            request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
        }
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet InscripcionServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet InscripcionServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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

}
