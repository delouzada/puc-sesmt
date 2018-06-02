/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.dao;

import br.com.puc.sesmt.Interface.DaoGeneric;
import br.com.puc.sesmt.modelo.Possuirisco;

/**
 *
 * @author Louzada
 */
public class PossuiriscoDao extends DaoGeneric<Possuirisco> {

    public PossuiriscoDao() {
        super(new Possuirisco());
    }
    
}
