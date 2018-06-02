/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.controller;

import br.com.puc.sesmt.dao.TipoDeRiscoDao;
import br.com.puc.sesmt.modelo.Tiporisco;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Louzada
 */
public class TipoRiscoController {
   
    private Tiporisco tiporisco;
    
    private TipoDeRiscoDao dao;
    
    private DataModel listaTipoRisco;

    public TipoRiscoController() {
    
        dao = new TipoDeRiscoDao();
        tiporisco = new Tiporisco();
    
    }
    
    
    
    
    
       public String cadastrar() {


        FacesContext fc = FacesContext.getCurrentInstance();

        try {


            Boolean fdao = dao.validaTipoRisco(tiporisco.getNometiporisco());



            if (fdao == false) {
                System.out.println(tiporisco.toString());
                
                dao.save(tiporisco);



                fc.addMessage("form1", new FacesMessage("Gravado com sucesso"));
            } else {
                fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Fornecedor", "Fornecedor Já cadastrado"));
            }

        } catch (Exception e) {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aconteceu um erro indesejaval: ", e.getMessage()));
            e.printStackTrace();
        }

        return null;






    }

    public String excluir() {

        FacesContext fc = FacesContext.getCurrentInstance();

        try {


            dao.delete(tiporisco);
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Removido", "Removido com sucesso"));

        } catch (Exception e) {

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro: ", "" + e.getMessage()));


        }


        return "lista-tiporisco";

    }

    public String preparaRemove() {

         tiporisco = (Tiporisco) (listaTipoRisco.getRowData());

        return "remove-tiporisco";
    }

    public DataModel getListaTipoRisco() {




        List<Tiporisco> lista;
        try {
            lista = new TipoDeRiscoDao().findAll();
                    listaTipoRisco = new ListDataModel(lista);

        } catch (Exception ex) {
            Logger.getLogger(TipoRiscoController.class.getName()).log(Level.SEVERE, null, ex);
        }




        return listaTipoRisco;
    }

    public void setListaTipoRisco(DataModel listaTipoRisco) {
        this.listaTipoRisco = listaTipoRisco;
    }

    public String preparaAlterar() {

        tiporisco = (Tiporisco) (listaTipoRisco.getRowData());

        return "alterar-tiporisco";
    }

    public String alterarFornecedor() {

        FacesContext fc = FacesContext.getCurrentInstance();

        try {

            dao.update(tiporisco);

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteracao ", "Alterado com sucesso"));


        } catch (Exception e) {

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Matricula invalida ", "" + e.getMessage()));

        }

        return "lista-fornecedor";

    }

    
    
    
    
    
}
