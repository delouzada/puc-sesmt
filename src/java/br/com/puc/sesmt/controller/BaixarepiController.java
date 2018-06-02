/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.controller;

import br.com.puc.sesmt.dao.BaixarepiDao;
import br.com.puc.sesmt.modelo.Baixarepi;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Louzada
 */
public class BaixarepiController {

    /**
     * Creates a new instance of BaixarepiController
     */
    
   private Baixarepi baixarepi;
   
   private BaixarepiDao dao;
    
    public BaixarepiController() {
    baixarepi = new Baixarepi();
    dao = new BaixarepiDao();
    
    }
    
    
     public String cadastrar(){
        try {
            dao.save(baixarepi);
        } catch (Exception ex) {
            Logger.getLogger(BaixarepiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return null;   
    }
    
    
    public String lista(){
        try {
            List<Baixarepi> findAll = dao.findAll();
        } catch (Exception ex) {
            Logger.getLogger(BaixarepiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }
    
    public String exclui(){
        try {
            dao.delete(baixarepi);
        } catch (Exception ex) {
            Logger.getLogger(BaixarepiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }
    
   
     public String atualiza(){
    
        return null;
    
    }

     public String buscar(){
     
         return null;
     }
     
    public Baixarepi getBaixarepi() {
        return baixarepi;
    }

    public void setBaixarepi(Baixarepi baixarepi) {
        this.baixarepi = baixarepi;
    }
     
    
    public void getTestaGit(){
    
    String t = "testa git";
        
    }
     
}
