/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.controller;

import br.com.puc.sesmt.dao.FornecedorDao;
import br.com.puc.sesmt.modelo.Epi;
import br.com.puc.sesmt.modelo.Fornecedor;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Louzada
 */
@ManagedBean(name = "MbFornecedor")
@SessionScoped
public class FornecedorController {

    private Fornecedor fornecedor;
    private FornecedorDao dao;
    private DataModel listaFornecedor;
    private Epi epi;

    /**
     * Creates a new instance of FornecedorController
     */
    public FornecedorController() {
        fornecedor = new Fornecedor();
        dao = new FornecedorDao();
        epi = new Epi();

    }

    public String cadastrar() {


        FacesContext fc = FacesContext.getCurrentInstance();

        try {

            fornecedor.setEpi(epi);
            dao.save(fornecedor);
            fc.addMessage("form1", new FacesMessage("Gravado com sucesso"));

        } catch (Exception e) {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aconteceu um erro indesejaval: ", e.getMessage()));
            e.printStackTrace();
        }

        return null;

    }

    public String excluir() {

        FacesContext fc = FacesContext.getCurrentInstance();

        try {
            dao.delete(fornecedor);
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Removido", "Removido com sucesso"));

        } catch (Exception e) {

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro: ", "" + e.getMessage()));
        }
        return "lista-fornecedor";
    }

    public String preparaRemove() {

        fornecedor = (Fornecedor) (listaFornecedor.getRowData());

        return "remove-fornecedor";
    }

    public DataModel getListaFornecedor() {

        List<Fornecedor> lista = new FornecedorDao().findAll();

        listaFornecedor = new ListDataModel(lista);

        return listaFornecedor;
    }

    public void setListaFornecedor(DataModel listaFornecedor) {
        this.listaFornecedor = listaFornecedor;
    }

    public String preparaAlterar() {

        fornecedor = (Fornecedor) (listaFornecedor.getRowData());

        return "alterar-fornecedor";
    }

    public String alterarFornecedor() {

        FacesContext fc = FacesContext.getCurrentInstance();

        try {

            dao.update(fornecedor);

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteracao ", "Alterado com sucesso"));


        } catch (Exception e) {

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Matricula invalida ", "" + e.getMessage()));

        }

        return "lista-fornecedor";

    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Epi getEpi() {
        return epi;
    }
}
