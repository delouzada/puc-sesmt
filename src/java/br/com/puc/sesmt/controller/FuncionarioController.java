/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.controller;

import br.com.puc.sesmt.dao.FuncionarioDao;
import br.com.puc.sesmt.modelo.Departamento;
import br.com.puc.sesmt.modelo.Funcionario;
import br.com.puc.sesmt.modelo.FuncionarioStatus;
import br.com.puc.sesmt.modelo.Setor;
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

/**
 *
 * @author Louzada
 */
@ManagedBean(name = "MbFuncionario")
@SessionScoped
public class FuncionarioController {

    private Funcionario funcionario;
    private Departamento departamento;
    private FuncionarioDao dao;
    private Setor setor;
    private List<Funcionario> funcionarios;
    private DataModel listaFuncionarios;
    private DataModel listaFuncionarioStatus;
    private FuncionarioStatus funcionarioStatus;

    /**
     * Creates a new instance of FuncionarioController
     */
    public FuncionarioController() {

        funcionarios = new ArrayList<Funcionario>();
        
        funcionario = new Funcionario();
        
        funcionarioStatus = new FuncionarioStatus();
        
        departamento = new Departamento();
        
        setor = new Setor();
        
        dao = new FuncionarioDao();

    }

    public String cadastrar() {

        FacesContext fc = FacesContext.getCurrentInstance();

        try {
    
                Boolean funcionariodao = new FuncionarioDao().validaFuncionario(funcionario.getMatricula());
    
            
            if(funcionariodao == false){
            
            if (funcionario.getNome() != null) {


                funcionario.setDepartamento(departamento);

                funcionario.setSetor(setor);

                funcionario.setFuncionarioStatus(funcionarioStatus);

              
                dao.save(funcionario);

                fc.addMessage("form1", new FacesMessage("Gravado com sucesso"));

                
            } else {

                
                fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Preencha os os campos", "Favor conferir os campos preenchidos"));

            }
            
            }else{
                    
                fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Matricula já cadastrada"," " + funcionario.getMatricula()));

            
            }
        } catch (Exception e) {

            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aconteceu um erro indesejaval: ", e.getMessage()));

            e.printStackTrace();
        }

        return null;



    }

    public String Cancelar(){
    
    
        FacesContext fc = FacesContext.getCurrentInstance();

        try {
            
          
    
            fc.getExternalContext().redirect("./lista-funcionario.jsp");
       
        } catch (Exception e) {
       
        }
             return null;
    }
    
    public String removeFuncionario() {



        FacesContext fc = FacesContext.getCurrentInstance();

            
    
        
        try {

            
            System.out.println(funcionario.toString());
            System.out.println(funcionario.getFuncionarioStatus().toString());
        
            //dao.delete(funcionario);

            
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Removido", "Com sucesso!"));
            
            
        } catch (Exception e) {

            e.printStackTrace();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Removido", "Existe um historico de itens devolvidos ou removidos pelo funcionario. Remova-os antes de remover o funcionario "));
            
        }


        return "lista-funcionario";
    }

    public void buscarMatricula() {

        FacesContext fc = FacesContext.getCurrentInstance();




        try {


            Funcionario func = new FuncionarioDao().findByCod(funcionario.getMatricula());
            if (funcionario.getMatricula() == func.getMatricula()) {


                fc.getExternalContext().redirect("./adquirir-epi.jsf");

            } else {

                System.out.println("Matricula invalida");
                fc.addMessage("form1", new FacesMessage("" + funcionario.getMatricula()));
            }
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Matricula invalida ", "" + funcionario.getMatricula()));
            System.out.println("matricula invalida");
        }


    }

    public Funcionario getFuncionario() {

        return funcionario;
    }

    public List<Funcionario> getFuncionarios() {

        try {



            Funcionario func = new FuncionarioDao().findByCod(funcionario.getMatricula());

            funcionario = func;
            funcionarios.add(funcionario);

        } catch (Exception ex) {
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }


        return funcionarios;
    }

    public DataModel getListaFuncionarios() {

        List<Funcionario> lista = new FuncionarioDao().findAll();

        listaFuncionarios = new ListDataModel(lista);

        return listaFuncionarios;
    }

    public DataModel getListaFuncionarioStatus() {


        return listaFuncionarioStatus;

    }

    public void setListaFuncionarioStatus(DataModel listaFuncionarioStatus) {
        this.listaFuncionarioStatus = listaFuncionarioStatus;
    }

    public String prepararAlterarFuncionario() {

        funcionario = (Funcionario) (listaFuncionarios.getRowData());

        return "alterar-funcionario";

    }
    
    public String prepararRemoveFuncionario() {

        
        funcionario = (Funcionario) (listaFuncionarios.getRowData());

        
        return "remove-funcionario";

    }
    
    public String alterarFuncionario() {

        FacesContext fc = FacesContext.getCurrentInstance();

        try {

            dao.update(funcionario);
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado ", "Alterado com sucesso"));


        } catch (Exception e) {


            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Matricula invalida ", "" + e.getMessage()));
        }

        return "lista-funcionario";
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

    public FuncionarioStatus getFuncionarioStatus() {
        return funcionarioStatus;
    }

    public void setFuncionarioStatus(FuncionarioStatus funcionarioStatus) {
        this.funcionarioStatus = funcionarioStatus;
    }

}
