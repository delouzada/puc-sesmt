/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.controller;

import br.com.puc.sesmt.dao.FuncionarioStatusDao;
import br.com.puc.sesmt.modelo.FuncionarioStatus;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Louzada
 */
@ManagedBean(name = "mbFStatus")
@RequestScoped
public class FuncionarioStatusController {

    private FuncionarioStatus fs;
    private List<SelectItem> listaStatus;

    /**
     * Creates a new instance of FuncionarioStatusController
     */
    public FuncionarioStatusController() {
        fs = new FuncionarioStatus();
    }

    public FuncionarioStatus getFs() {
        return fs;
    }

    public void setFs(FuncionarioStatus fs) {
        this.fs = fs;
    }

    public List<SelectItem> getListaStatus() {
        listaStatus = new ArrayList<SelectItem>();
        try {

            for (FuncionarioStatus status : new FuncionarioStatusDao().findAll()) {
                listaStatus.add(new SelectItem(status.getIdStatus(), status.getStatus()));
            }
        } catch (Exception e) {

            e.getMessage();

        }


        return listaStatus;
    }

    public void setListaStatus(List<SelectItem> listaStatus) {
        this.listaStatus = listaStatus;
    }
}
