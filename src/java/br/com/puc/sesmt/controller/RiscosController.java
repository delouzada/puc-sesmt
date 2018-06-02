/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.controller;

import br.com.puc.sesmt.dao.RiscosDao;
import br.com.puc.sesmt.modelo.Epi;
import br.com.puc.sesmt.modelo.Riscos;
import br.com.puc.sesmt.modelo.Tiporisco;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Louzada
 */
public class RiscosController {

    private Riscos risco;
    private RiscosDao dao;
    private DataModel riscos;
    private Epi epi;
    private Tiporisco tiporisco;

    public RiscosController() {
        risco = new Riscos();
        dao = new RiscosDao();
    }

    public Riscos getRisco() {
        return risco;
    }

    public void setRisco(Riscos risco) {
        this.risco = risco;
    }

    public DataModel getRiscos() {
        try {
            List<Riscos> lista = new RiscosDao().findAll();

            riscos = new ListDataModel(lista);

        } catch (Exception ex) {
            Logger.getLogger(RiscosController.class.getName()).log(Level.SEVERE, null, ex);
        }



        return riscos;
    }

    public String cadastraEpi() {

        FacesContext fc = FacesContext.getCurrentInstance();

        try {

            Boolean fdao = dao.ValidaRisco(risco.getEfeitosaude());

            if (fdao == false) {

                risco.setEpi(epi);
                risco.setTiporisco(tiporisco);
                System.out.println("risco" + risco.toString());


            }

        } catch (Exception e) {
            e.getMessage();
        }


        return null;
    }

    public void setRiscos(DataModel riscos) {
        this.riscos = riscos;
    }

    public Epi getEpi() {
        return epi;
    }

    public void setEpi(Epi epi) {
        this.epi = epi;
    }

    public Tiporisco getTiporisco() {
        return tiporisco;
    }

    public void setTiporisco(Tiporisco tiporisco) {
        this.tiporisco = tiporisco;
    }
    
    
    
    
    
}
