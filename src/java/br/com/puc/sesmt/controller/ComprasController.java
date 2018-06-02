/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.controller;

import br.com.puc.sesmt.dao.ComprasDao;
import br.com.puc.sesmt.modelo.Compras;
import br.com.puc.sesmt.modelo.Fornecedor;

/**
 *
 * @author Louzada
 */
public class ComprasController {

    
    private Compras compras;
    private ComprasDao dao;
    
    /**
     * Creates a new instance of ComprasController
     */
    public ComprasController() {
    compras = new Compras();
    dao = new ComprasDao();
    
    }
    
    
    
     public String cadastrar(){
    
        
     return null;   
    }
    
    
    public String lista(){
    
        return null;
    
    }
    
    public String exclui(){
    
        return null;
    
    }
    
   
     public String atualiza(){
    
        return null;
    
    }

     public String buscar(){
     
         return null;
     }

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }

     
}
