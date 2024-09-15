/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.arquitectura.student.entity.Curso;
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
@WebServlet(name = "CursoServlet", urlPatterns = {"/CursoServlet"})
public class CursoServlet extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;

    @EJB
    private InscripcionFacadeLocal inscripcionFacade;

    @EJB
    private CursoFacadeLocal cursoFacade;


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

        String action = request.getParameter("action");
        try {
            String codStr = request.getParameter("codigoCurso");
            Integer cod = new Integer(codStr);

            if (action.equals("Add")) {
                String nombreCurso = request.getParameter("nombreCurso");
                String creditosStr = request.getParameter("creditos");
                Integer creditos = new Integer(creditosStr);
                String semestreStr = request.getParameter("semestre");
                Integer semestre = new Integer(semestreStr);
                String estudiantesAdmitidosStr = request.getParameter("estudiantesAdmiditos");
                Integer estudiantesAdmiditos = new Integer(estudiantesAdmitidosStr);
                Curso curso = new Curso(cod, nombreCurso, creditos, semestre, estudiantesAdmiditos);

                cursoFacade.create(curso);

                request.setAttribute("allCursos", cursoFacade.findAll());
                request.setAttribute("allStudents", studentFacade.findAll());
                request.setAttribute("allInscripciones", inscripcionFacade.findAll());
                request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
            } else if (action.equals("Edit")) {
                String nombreCurso = request.getParameter("nombreCurso");
                String creditosStr = request.getParameter("creditos");
                Integer creditos = new Integer(creditosStr);
                String semestreStr = request.getParameter("semestre");
                Integer semestre = new Integer(semestreStr);
                String estudiantesAdmitidosStr = request.getParameter("estudiantesAdmiditos");
                Integer estudiantesAdmiditos = new Integer(estudiantesAdmitidosStr);
                Curso curso = new Curso(cod, nombreCurso, creditos, semestre, estudiantesAdmiditos);

                cursoFacade.edit(curso);

                request.setAttribute("allCursos", cursoFacade.findAll());
                request.setAttribute("allStudents", studentFacade.findAll());
                request.setAttribute("allInscripciones", inscripcionFacade.findAll());
                request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
            } else if (action.equals("Delete")) {
                String nombreCurso = request.getParameter("nombreCurso");
                String creditosStr = request.getParameter("creditos");
                Integer creditos = new Integer(creditosStr);
                String semestreStr = request.getParameter("semestre");
                Integer semestre = new Integer(semestreStr);
                String estudiantesAdmitidosStr = request.getParameter("estudiantesAdmiditos");
                Integer estudiantesAdmiditos = new Integer(estudiantesAdmitidosStr);
                Curso curso = new Curso(cod, nombreCurso, creditos, semestre, estudiantesAdmiditos);

                cursoFacade.remove(curso);

                request.setAttribute("allCursos", cursoFacade.findAll());
                request.setAttribute("allStudents", studentFacade.findAll());
                request.setAttribute("allInscripciones", inscripcionFacade.findAll());
                request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
            } else if (action.equals("Search")) {
                List cursos = new ArrayList();
                cursos.add(cursoFacade.find(cod));

                request.setAttribute("allCursos", cursos);
                request.setAttribute("allStudents", studentFacade.findAll());
                request.setAttribute("allInscripciones", inscripcionFacade.findAll());
                request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
            }
        } catch (java.lang.NumberFormatException e) {
            request.setAttribute("error", "Complete y verifique todos los campos, ERROR: " + e.getMessage());
            request.setAttribute("allCursos", cursoFacade.findAll());
            request.setAttribute("allStudents", studentFacade.findAll());
            request.setAttribute("allInscripciones", inscripcionFacade.findAll());
            request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
        } catch (javax.ejb.EJBException e) {
            request.setAttribute("error", "ID o llave principal repetida, verifique los campos, ERROR: " + e.getMessage());
            request.setAttribute("allCursos", cursoFacade.findAll());
            request.setAttribute("allStudents", studentFacade.findAll());
            request.setAttribute("allInscripciones", inscripcionFacade.findAll());
            request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
        }

//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CursoServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CursoServlet at " + request.getContextPath() + "</h1>");
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
