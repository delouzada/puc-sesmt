/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.controller;

import br.com.puc.sesmt.dao.EpiDao;
import br.com.puc.sesmt.dao.FuncionarioDao;
import br.com.puc.sesmt.dao.ItensAdquiridosDao;
import br.com.puc.sesmt.dao.ItensDevolvidosDao;
import br.com.puc.sesmt.modelo.Epi;
import br.com.puc.sesmt.modelo.Funcionario;
import br.com.puc.sesmt.modelo.FuncionarioStatus;
import br.com.puc.sesmt.modelo.Itensadquiridos;
import br.com.puc.sesmt.modelo.Itensdevolvidos;
import java.util.Date;
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
@SessionScoped
@ManagedBean(name = "Mbadquirir")
public class AdquirirepiController {

    /**
     * Creates a new instance of AdquirirepiController
     */
    private Funcionario funcionario;
    private Funcionario funcionarioexibe;
    private Epi epi;
    private DataModel listaEpi;
    private DataModel listaItensAdquiridos;
    private Itensadquiridos itensadquiridos;
    private Itensdevolvidos itensdevolvidos;
    private DataModel listaItensDevolvidos;
    private FuncionarioStatus funcionariostatus;

    public AdquirirepiController() {


        funcionario = new Funcionario();
        epi = new Epi();
        itensadquiridos = new Itensadquiridos();
        funcionariostatus = new FuncionarioStatus();
        itensdevolvidos = new Itensdevolvidos();
        





    }

    public void buscarMatricula() {

        FacesContext fc = FacesContext.getCurrentInstance();




        try {

            System.out.print(funcionario.getMatricula());

            Funcionario func = new FuncionarioDao().findByCod(funcionario.getMatricula());

            if (funcionario.getMatricula() == func.getMatricula()) {


                System.out.println("Teste");
                fc.getExternalContext().redirect("./adquirir-epi.jsf");

            } else {

                System.out.println("Matricula invalida");
                fc.addMessage("form1", new FacesMessage("" + funcionario.getMatricula()));
            }
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Matricula invalida ", "" + funcionario.getMatricula()));
            System.out.println("matricula nula");
        }


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

    public String adquirirEpi() {

        System.out.println("Funcionario: " + funcionario.getMatricula());

        System.out.println("Epi: " + epi);

        FacesContext fc = FacesContext.getCurrentInstance();


        try {

            Date data = new Date();
            epi = (Epi) listaEpi.getRowData();

            Funcionario funcionarioDao = new FuncionarioDao().findByCod(funcionario.getMatricula());

            funcionario = funcionarioDao;

            System.out.println("Funcionaro: " + funcionario.toString());


            System.out.println("Quantidade Minima Epi: " + epi.getQuantminima());


            System.out.println("Quantidade em estoque: " + epi.getQuantidade());

            System.out.println("8");
                        itensadquiridos.setFuncionario(funcionario);
                        System.out.println("9");
                        itensadquiridos.setEpi(epi);
                        System.out.println("10");
                        itensadquiridos.setDataaquisicao(new Date());

            
            
            
            System.out.println("1");
            if (funcionario.getFuncionarioStatus().getStatus().equalsIgnoreCase("ativo")) {

                System.out.println("2");

                if (!epi.getValidadeca().after(data)) {

                    System.out.println("5");
                    fc.addMessage("form1", new FacesMessage("O C.A " + epi.getCa() + " , " + epi.getNomeepi() + " Está vencido Não possivel adquirir"));

                } else {


                    if (epi.getQuantidade() <= 0 && itensadquiridos.getQuantidade() <= 0 && itensadquiridos.getQuantidade() == epi.getQuantidade() | itensadquiridos.getQuantidade() == null) {
                        fc.addMessage("form1", new FacesMessage("Verifique a quantidade  informada ou se há itens suficiente no estoque "));


                    } else {



                        
                        System.out.println("11");
                        ItensAdquiridosDao dao = new ItensAdquiridosDao();

                        System.out.println("12");



                        dao.save(itensadquiridos);

                        Integer qtd = epi.getQuantidade() - itensadquiridos.getQuantidade();

                        System.out.println("mkjkj" + epi);

                        dao.updateEstoque(qtd, epi.getCodepi());



                        System.out.println("13");
                        fc.addMessage("form1", new FacesMessage("Adquirido" + epi.getNomeepi()));
                        System.out.println("14");
                    }

                }






            } else {

                System.out.println("16");
                fc.addMessage("form1", new FacesMessage("Status: " + funcionario.getFuncionarioStatus().getStatus() + "Não pode adquirir"));
            }
        } catch (Exception e) {

            System.out.println("15");
            e.printStackTrace();
            fc.addMessage("form1", new FacesMessage("" + e.getMessage()));


        }

        return null;

    }

    public String baixaEpi() {


        FacesContext fc = FacesContext.getCurrentInstance();


        try {



            ItensDevolvidosDao devolveDao = new ItensDevolvidosDao();
            ItensAdquiridosDao adquiridosDao = new ItensAdquiridosDao();
            itensadquiridos = (Itensadquiridos) listaItensAdquiridos.getRowData();

            itensdevolvidos.setHistorico(itensadquiridos.getHistorico());
            itensdevolvidos.setQuantidade(itensadquiridos.getQuantidade());
            itensdevolvidos.setDataaquisicao(itensadquiridos.getDataaquisicao());
            itensdevolvidos.setDataDevolucao(new Date());

            itensdevolvidos.setEpi(itensadquiridos.getEpi());
            itensdevolvidos.setFuncionario(itensadquiridos.getFuncionario());


            Integer qtd = itensadquiridos.getQuantidade() + itensadquiridos.getEpi().getQuantidade();

            System.out.println("BaixaEpi: " + qtd);

            System.out.println("baixarEpi" + itensadquiridos.toString());

            devolveDao.updateEstoque(qtd, itensadquiridos.getEpi().getCodepi());



            devolveDao.save(itensdevolvidos);




            adquiridosDao.delete(itensadquiridos);


            System.out.println("QTD: " + qtd);



            fc.addMessage("form1", new FacesMessage("Devolvido " + epi.getNomeepi()));



        } catch (Exception e) {

            e.getMessage();


        }



        return null;
    }

    public Epi getEpi() {
        return epi;
    }

    public void setEpi(Epi epi) {
        this.epi = epi;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Itensadquiridos getItensadquiridos() {
        return itensadquiridos;
    }

    public void setItensadquiridos(Itensadquiridos itensadquiridos) {
        this.itensadquiridos = itensadquiridos;
    }

    public DataModel getListaItensAdquiridos() {
        try {



            List<Itensadquiridos> lista = new ItensAdquiridosDao().findByMatricula(funcionario);

            listaItensAdquiridos = new ListDataModel(lista);
        } catch (Exception ex) {
            Logger.getLogger(AdquirirepiController.class.getName()).log(Level.SEVERE, null, ex);
        }


        return listaItensAdquiridos;
    }

    public void setListaItensAdquiridos(DataModel listaItensAdquiridos) {
        this.listaItensAdquiridos = listaItensAdquiridos;
    }

    public Itensdevolvidos getItensdevolvidos() {
        return itensdevolvidos;
    }

    public void setItensdevolvidos(Itensdevolvidos itensdevolvidos) {
        this.itensdevolvidos = itensdevolvidos;
    }

    public DataModel getListaItensDevolvidos() {
        try {
            List<Itensdevolvidos> lista = new ItensDevolvidosDao().findByMatricula(funcionario);
            listaItensDevolvidos = new ListDataModel(lista);
        } catch (Exception ex) {
            Logger.getLogger(AdquirirepiController.class.getName()).log(Level.SEVERE, null, ex);
        }


        return listaItensDevolvidos;
    }

    public void setListaItensDevolvidos(DataModel listaItensDevolvidos) {
        this.listaItensDevolvidos = listaItensDevolvidos;
    }

    public FuncionarioStatus getFuncionariostatus() {
        return funcionariostatus;
    }

    public void setFuncionariostatus(FuncionarioStatus funcionariostatus) {
        this.funcionariostatus = funcionariostatus;
    }

    public Funcionario getFuncionarioexibe() {
        try {
            funcionarioexibe = new FuncionarioDao().findByCod(funcionario.getMatricula());
        } catch (Exception ex) {
            Logger.getLogger(AdquirirepiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarioexibe;
    }

    public void setFuncionarioexibe(Funcionario funcionarioexibe) {
        this.funcionarioexibe = funcionarioexibe;
    }
}
