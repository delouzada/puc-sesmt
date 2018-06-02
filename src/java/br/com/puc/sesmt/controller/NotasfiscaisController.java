/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.controller;

import br.com.puc.sesmt.dao.NotasfiscaisDao;
import br.com.puc.sesmt.modelo.Compras;
import br.com.puc.sesmt.modelo.Notasfiscais;

/**
 *
 * @author Louzada
 */
public class NotasfiscaisController {

    /**
     * Creates a new instance of NotasfiscaisController
     */
    
    
    private Notasfiscais notasfiscais;
    private NotasfiscaisDao dao;
   // private Compras compras;
    public NotasfiscaisController() {
     //   compras = new Compras();
        notasfiscais = new Notasfiscais();
        dao = new NotasfiscaisDao();
    }

    
    
     public String cadastrar(){
    
        
     return null;   
    }
    
    
    public String listar(){
    
        return null;
    
    }
    
    public String excluir(){
    
        return null;
    
    }
    
   
     public String Atualizar(){
    
        return null;
    
    }
    
    
    
    public Notasfiscais getNotasfiscais() {
        return notasfiscais;
    }

    public void setNotasfiscais(Notasfiscais notasfiscais) {
        this.notasfiscais = notasfiscais;
    }

}
