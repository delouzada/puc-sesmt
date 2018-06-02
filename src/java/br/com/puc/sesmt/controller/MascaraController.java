/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Louzada
 */
@ManagedBean(name="mask")
@RequestScoped
public class MascaraController {

    
    private String telefone;
    
    private String email;
    
    private String data;
    
    private String valor;
    
    private String cnpj;

    
    
    
    
    /**
     * Creates a new instance of MascaraController
     */
    public MascaraController() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    
}
