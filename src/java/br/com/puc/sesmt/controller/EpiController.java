/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.controller;

import br.com.puc.sesmt.dao.EpiDao;
import br.com.puc.sesmt.modelo.Epi;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author Louzada
 */
@ManagedBean(name = "MBepi")
@SessionScoped
public class EpiController {

    /**
     * Creates a new instance of EpiController
     */
    private Epi epi;
    private EpiDao dao;
    private List<SelectItem> origem;
    private List<SelectItem> listaEpis;
    private DataModel listaEpi;
    private Epi[] epiSelecionados;

    public EpiController() {
        epi = new Epi();
        dao = new EpiDao();
    }

    public DataModel getListaEpi() {
        try {
            List<Epi> lista = new EpiDao().findAll();

            listaEpi = new ListDataModel(lista);
        } catch (Exception ex) {
            Logger.getLogger(EpiController.class.getName()).log(Level.SEVERE, null, ex);
        }


        return listaEpi;
    }

    public void setListaEpi(DataModel listaEpi) {
        this.listaEpi = listaEpi;
    }

    public String preparaAlterar() {

        epi = (Epi) (listaEpi.getRowData());

        return "altera-epi";

    }

    public String preparaRemove() {

        epi = (Epi) (listaEpi.getRowData());

        return "remove-epi";

    }

    public String cadastrar() {


        FacesContext fc = FacesContext.getCurrentInstance();

        try {


            dao.save(epi);
            fc.addMessage("form1", new FacesMessage("Gravado com sucesso"));

        } catch (Exception ex) {
            Logger.getLogger(EpiController.class.getName()).log(Level.SEVERE, null, ex);
        }



        return null;
    }

    public String excluir() {

        FacesContext fc = FacesContext.getCurrentInstance();

        try {


            dao.delete(epi);
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Removido", "Removido com sucesso"));

        } catch (Exception e) {

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro: ", "" + e.getMessage()));


        }




        return "lista-fornecedor";

    }

    public String alteraEpi() {

        FacesContext fc = FacesContext.getCurrentInstance();

        try {

            dao.update(epi);

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração ", "Alterado com sucesso"));


        } catch (Exception e) {

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro: ", "" + e.getMessage()));

        }

        return "lista-fornecedor";



    }

    public List<SelectItem> getOrigem() {
        
        
        try {

            origem = new ArrayList<SelectItem>();
            for (Epi epis : new EpiDao().findAll()) {
                origem.add(new SelectItem(epis.getCodepi(), epis.getOrigemepi()));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        
        
        return origem;
    }

    public void setOrigem(List<SelectItem> origem) {
        this.origem = origem;
    }

    public List<SelectItem> getListaEpis() {

        try {

            listaEpis = new ArrayList<SelectItem>();
            for (Epi epis : new EpiDao().findAll()) {
                listaEpis.add(new SelectItem(epis.getCodepi(), epis.getNomeepi()));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return listaEpis;
    }

    public void setListaEpis(List<SelectItem> listaEpis) {
        this.listaEpis = listaEpis;
    }

    public Epi getEpi() {
        return epi;
    }

    public void setEpi(Epi epi) {
        this.epi = epi;
    }

    public Epi[] getEpiSelecionados() {
        return epiSelecionados;
    }

    public void setEpiSelecionados(Epi[] epiSelecionados) {
        this.epiSelecionados = epiSelecionados;
    }
    
    
    
}
