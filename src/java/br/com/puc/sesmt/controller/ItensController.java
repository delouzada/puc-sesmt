/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.controller;

import br.com.puc.sesmt.dao.ItensDao;
import br.com.puc.sesmt.modelo.Itens;

/**
 *
 * @author Louzada
 */
public class ItensController {

    private Itens itens;
    private ItensDao dao;
    
    /**
     * Creates a new instance of ItensController
     */
    
    
    
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
    
    
    
    
    public ItensController() {
    itens = new Itens();
    dao =  new ItensDao();
    }

    public Itens getItens() {
        return itens;
    }

    public void setItens(Itens itens) {
        this.itens = itens;
    }
    
    
    
    
}
