/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.dao;

import br.com.puc.sesmt.Interface.DaoGeneric;
import br.com.puc.sesmt.modelo.Itens;

/**
 *
 * @author Louzada
 */
public class ItensDao extends DaoGeneric<Itens> {

    public ItensDao() {
        super(new Itens());
    }

   
}
