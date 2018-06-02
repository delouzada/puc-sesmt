/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.dao;

import br.com.puc.sesmt.Interface.DaoGeneric;
import br.com.puc.sesmt.modelo.FuncionarioStatus;

/**
 *
 * @author Louzada
 */
public class FuncionarioStatusDao extends DaoGeneric<FuncionarioStatus> {

    public FuncionarioStatusDao() {
        super(new FuncionarioStatus());
    }
    
    
    
}
