/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.controller;

import br.com.puc.sesmt.dao.DepartamentoDao;
import br.com.puc.sesmt.modelo.Departamento;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Louzada
 */
@ManagedBean(name = "MbDepartamento")
@RequestScoped
public class DepartamentoController {

    private Departamento departamento;
    private DepartamentoDao dao;
    private List<SelectItem> listaDepartamento;
    private List<Departamento> listar;
    private DataModel listaDepartamentos;

    /**
     * Creates a new instance of DepartamentoController
     */
    public DepartamentoController() {
        departamento = new Departamento();
        dao = new DepartamentoDao();
    }

    public List<SelectItem> getListaDepartamento() {
        try {
            listaDepartamento = new ArrayList<SelectItem>();
            for (Departamento depto : new DepartamentoDao().findAll()) {
                listaDepartamento.add(new SelectItem(depto.getCoddepto(), depto.getNomedepto()));
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return listaDepartamento;
    }

    public void setListaDepartamento(List<SelectItem> listaDepartamento) {
        this.listaDepartamento = listaDepartamento;
    }

    
    public List<Departamento> getListar() {


        try {
            listar = dao.findAll();
        } catch (Exception e) {
            e.getMessage();
        }


        return listar;





    }

    public DataModel getListaDepartamentos() {
        try {
            List<Departamento> lista = new DepartamentoDao().findAll();
            listaDepartamentos = new ListDataModel(lista);



        } catch (Exception ex) {
            Logger.getLogger(DepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaDepartamentos;
    }

    public void setListaDepartamentos(DataModel listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public String preparaAlterar() {

        departamento = (Departamento) (listaDepartamentos.getRowData());

        return "altera-departamento";

    }

    public String preparaRemove() {

        departamento = (Departamento) (listaDepartamentos.getRowData());

        return "remove-departamento";

    }

    public String cadastrar() {

        FacesContext fc = FacesContext.getCurrentInstance();
        try {

            
            if(departamento.getNomedepto() != null){
            
            dao.save(departamento);
                fc.addMessage("form1", new FacesMessage("Gravado com sucesso"));
            }

            else{
            
                fc.addMessage("form1", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Preencha o campo obrigatório", departamento.getNomedepto()));
            }
        
        } catch (Exception e) {
            fc.addMessage("form1", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Houve um erro","Houve um erro" + e.getMessage()));
            e.printStackTrace();
        }

        return null;
    }
    
    public String alteraDepartamento(){
    
      FacesContext fc = FacesContext.getCurrentInstance();

        try {

            
            dao.update(departamento);

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteracao ", "Alterado com sucesso"));


        } catch (Exception e) {

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro: ", "" + e.getMessage()));
            e.printStackTrace();

        }

        return "lista-departamento";

    
    
    }
    
    public String removeDepartamento(){
    
     
      FacesContext fc = FacesContext.getCurrentInstance();

        try {

      
            
            
            
            System.out.println(departamento.toString());
          dao.delete(departamento);

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Remoção ", "Remoção realizada com sucesso"));

           fc.getExternalContext().redirect("./lista-departamento.jsf");

        } catch (Exception e) {

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro ", "" + e.getMessage()));

        }

        return "lista-departamento";

    
    
    }
    
    

 
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
