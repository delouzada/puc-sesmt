/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Louzada
 */
@Entity
public class FuncionarioStatus implements Serializable {

    private Long idStatus;
    private String status;
    private List<Funcionario> funcionarios;

    public FuncionarioStatus() {
    }

    public FuncionarioStatus(Long idStatus, String status) {
        this.idStatus = idStatus;
        this.status = status;
    }

    public FuncionarioStatus(Long idStatus, String status, List<Funcionario> funcionarios) {
        this.idStatus = idStatus;
        this.status = status;
        this.funcionarios = funcionarios;
    }

    
    

    
   
    
    
    
    @Column(name="STATUS")
    public String getStatus() {

        return status;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CODSTATUS")
    public Long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Long idStatus) {
        this.idStatus = idStatus;
    }

    public void setStatus(String status) {

        this.status = status;

    }


 
    
    @OneToMany(mappedBy = "funcionarioStatus",fetch= FetchType.EAGER)
    @JoinColumn(name="CODFUNCIONARIO")
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "FuncionarioStatus{" + "idStatus=" + idStatus + ", status=" + status + ", funcionarios=" + funcionarios + '}';
    }

    
    
  


    
    
}