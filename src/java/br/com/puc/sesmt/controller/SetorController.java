/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.controller;

import br.com.puc.sesmt.dao.DepartamentoDao;
import br.com.puc.sesmt.dao.SetorDao;
import br.com.puc.sesmt.modelo.Departamento;
import br.com.puc.sesmt.modelo.Setor;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author Louzada
 */
@ManagedBean(name = "Mbsetor")
@RequestScoped
public class SetorController {

    private Setor setor;
    private Departamento departamento;
    private SetorDao dao;
    private List<SelectItem> listaSetor;
    private DataModel listaSetores;

    /**
     * Creates a new instance of SetorController
     */
    public SetorController() {

        setor = new Setor();
        departamento = new Departamento();
        dao = new SetorDao();
    }

    public String cadastrar() {



        FacesContext fc = FacesContext.getCurrentInstance();
        try {

            
            
            setor.setDepartamento(departamento);



            Boolean valida = new SetorDao().validaSetor(setor.getNomesetor());



             if(setor.getNomesetor() != null){
                
            
           
            

            if (valida == true) {

           
                    fc.addMessage("form1", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Setor já cadastrado",setor.getNomesetor()));
         

            } else {

                dao.save(setor);
                fc.addMessage("form1", new FacesMessage("Gravado com sucesso"));


            }


            
        } else{
            
                
                fc.addMessage("form1", new FacesMessage(FacesMessage.SEVERITY_FATAL,"Campo obrigatório","O campo nome: " + setor.getNomesetor() + "obrigatorio"));
            
            }
            


        } catch (Exception e) {
            System.out.println(setor.getNomesetor());
            fc.addMessage("form1", new FacesMessage(FacesMessage.SEVERITY_ERROR,null,"Houve um erro" + e.getMessage()));
            e.printStackTrace();
        }

        return null;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public List<SelectItem> getListaSetor() {

        try {
            listaSetor = new ArrayList<SelectItem>();
            for (Setor setores : new SetorDao().findAll()) {
                listaSetor.add(new SelectItem(setores.getCodsetor(), setores.getNomesetor()));


            }

        } catch (Exception e) {

            e.getMessage();
            System.out.println("O erro é aqui");

        }




        return listaSetor;
    }

    public DataModel getListaSetores() {
        try {
            List<Setor> lista = new SetorDao().findAll();
            listaSetores = new ListDataModel(lista);
        } catch (Exception ex) {
            Logger.getLogger(SetorController.class.getName()).log(Level.SEVERE, null, ex);
        }


        return listaSetores;

    }

    public String preparaAltera() {

        setor = (Setor) (listaSetores.getRowData());

        return "altera-setor";
    }

    public String preparaRemove() {

        setor = (Setor) (listaSetores.getRowData());
        return "remove-setor";
    }

    public String alteraSetor() {


        FacesContext fc = FacesContext.getCurrentInstance();

        try {

            System.out.println("Departamento: "+departamento.getCoddepto());
          
    
            
            
            
            
            dao.update(setor, departamento);

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteracao ", "Alterado com sucesso"));


        } catch (Exception e) {

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro: ", "" + e.getMessage()));
            e.printStackTrace();

        }

        return "lista-setor";



    }

    public String removeSetor() {



        FacesContext fc = FacesContext.getCurrentInstance();

        try {

            dao.delete(setor);

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Remoção", "remoção realizada com sucesso"));


        } catch (Exception e) {

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro: ", "" + e.getMessage()));

        }

        return "lista-setor";

    }

    public void setListaSetores(DataModel listaSetores) {
        this.listaSetores = listaSetores;
    }



    
    
    
}
