<%-- 
    Document   : studentInfo
    Created on : 6/09/2024, 07:52:13 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <b name="error">${error}</b>
        <h1>Student Information</h1>
        <form action="./StudentServlet" method="POST"> 
            <table>
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" name="studentId" value="${student.studentid}" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstName" value="${student.firstname}" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName" value="${student.lastname}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="yearLevel" value="${student.yearlevel}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
                <c:forEach items="${allStudents}" var="stud">
                <tr>
                    <td>${stud.studentid}</td>
                    <td>${stud.firstname}</td>
                    <td>${stud.lastname}</td>
                    <td>${stud.yearlevel}</td>
                </tr>
            </c:forEach> 
        </table>
        <br>
        <h1>Informacion del curso</h1>
        <form action="./CursoServlet" method="POST"> 
            <table>
                <tr>
                    <td>codigo de curso</td>
                    <td><input type="text" name="codigoCurso" value="${curso.codigocurso}" /></td>
                </tr>
                <tr>
                    <td>nombre del curso</td>
                    <td><input type="text" name="nombreCurso" value="${curso.nombrecurso}" /></td>
                </tr>
                <tr>
                    <td>numero de creditos</td>
                    <td><input type="text" name="creditos" value="${curso.creditos}" /></td>
                </tr>
                <tr>
                    <td>semestre</td>
                    <td><input type="text" name="semestre" value="${curso.semestre}" /></td>
                </tr>
                <tr>
                    <td>Estudiantes admitidos</td>
                    <td><input type="text" name="estudiantesAdmiditos" value="${curso.estudiantesadmitidos}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Codigo de curso</th>
            <th>Nombre del curso</th>
            <th>Numero de creditos</th>
            <th>Semestre</th>
            <th>Estudiantes admitidos</th>
                <c:forEach items="${allCursos}" var="curs">
                <tr>
                    <td>${curs.codigocurso}</td>
                    <td>${curs.nombrecurso}</td>
                    <td>${curs.creditos}</td>
                    <td>${curs.semestre}</td>
                    <td>${curs.estudiantesadmitidos}</td>
                </tr>
            </c:forEach> 
        </table>
        <br>
        <h1>Inscripciones</h1>
        <form action="./InscripcionServlet" method="POST"> 
            <table>
                <tr>
                    <td>Codigo de inscripcion</td>
                    <td><input type="text" name="codigoInscripcion" value="${inscripcion.codigoinscripcion}" /></td>
                </tr>
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" name="studentId" value="${inscripcion.studentid}" /></td>
                </tr>
                <tr>
                    <td>Codigo de curso</td>
                    <td><input type="text" name="codigoCurso" value="${inscripcion.codigocurso}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Codigo Inscipcion</th>
            <th>student</th>
            <th>curso</th>
                <c:forEach items="${allInscripciones}" var="insc">
                <tr>
                    <td>${insc.codigoinscripcion}</td>
                    <td>${insc.studentid}</td>
                    <td>${insc.codigocurso}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
