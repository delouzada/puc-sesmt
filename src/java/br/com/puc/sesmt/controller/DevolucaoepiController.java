/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.controller;

import br.com.puc.sesmt.dao.DevolucaoepiDao;
import br.com.puc.sesmt.modelo.Devolucaoepi;

/**
 *
 * @author Louzada
 */
public class DevolucaoepiController {

    /**
     * Creates a new instance of DevolucaoepiController
     */
    
    private Devolucaoepi devolucaoepi;
    private DevolucaoepiDao dao;
    
    public DevolucaoepiController() {
        devolucaoepi = new Devolucaoepi();
        dao = new DevolucaoepiDao();
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

    
    
    
    
    
    
    public Devolucaoepi getDevolucaoepi() {
        return devolucaoepi;
    }

    public void setDevolucaoepi(Devolucaoepi devolucaoepi) {
        this.devolucaoepi = devolucaoepi;
    }
    
    
    
    
    
    
    
}
