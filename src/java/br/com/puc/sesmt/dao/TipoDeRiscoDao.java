/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.dao;

import br.com.puc.sesmt.Interface.DaoGeneric;
import br.com.puc.sesmt.factory.ConnectionFactory;
import br.com.puc.sesmt.modelo.Setor;
import br.com.puc.sesmt.modelo.Tiporisco;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Louzada
 */
public class TipoDeRiscoDao extends DaoGeneric<Tiporisco>{

    public TipoDeRiscoDao() {
        super(new Tiporisco());
    }
    
    
    
    public boolean validaTipoRisco(String nometiporisco) throws Exception {
        boolean retorno = false;

        Session session = ConnectionFactory.getSessionFactory().openSession();

        List lista = session.createCriteria(Tiporisco.class).add(Restrictions.like("nometiporisco", nometiporisco)).list();
        if (!lista.isEmpty()) {

            retorno = true;
        }


        session.close();
        return retorno;


    }
     
}
