/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.student.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "INSCRIPCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscripcion.findAll", query = "SELECT i FROM Inscripcion i"),
    @NamedQuery(name = "Inscripcion.findByCodigoinscripcion", query = "SELECT i FROM Inscripcion i WHERE i.codigoinscripcion = :codigoinscripcion")})
public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOINSCRIPCION")
    private Integer codigoinscripcion;
    @JoinColumn(name = "CODIGOCURSO", referencedColumnName = "CODIGOCURSO")
    @ManyToOne
    private Curso codigocurso;
    @JoinColumn(name = "STUDENTID", referencedColumnName = "STUDENTID")
    @ManyToOne
    private Student studentid;

    public Inscripcion() {
    }

    public Inscripcion(Integer codigoinscripcion, Curso codigocurso, Student studentid) {
        this.codigoinscripcion = codigoinscripcion;
        this.codigocurso = codigocurso;
        this.studentid = studentid;
    }

    public Inscripcion(Integer codigoinscripcion) {
        this.codigoinscripcion = codigoinscripcion;
    }

    public Integer getCodigoinscripcion() {
        return codigoinscripcion;
    }

    public void setCodigoinscripcion(Integer codigoinscripcion) {
        this.codigoinscripcion = codigoinscripcion;
    }

    public Curso getCodigocurso() {
        return codigocurso;
    }

    public void setCodigocurso(Curso codigocurso) {
        this.codigocurso = codigocurso;
    }

    public Student getStudentid() {
        return studentid;
    }

    public void setStudentid(Student studentid) {
        this.studentid = studentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoinscripcion != null ? codigoinscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscripcion)) {
            return false;
        }
        Inscripcion other = (Inscripcion) object;
        if ((this.codigoinscripcion == null && other.codigoinscripcion != null) || (this.codigoinscripcion != null && !this.codigoinscripcion.equals(other.codigoinscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.arquitectura.student.entity.Inscripcion[ codigoinscripcion=" + codigoinscripcion + " ]";
    }
    
}
