/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.dao;

import br.com.puc.sesmt.Interface.DaoGeneric;
import br.com.puc.sesmt.factory.ConnectionFactory;
import br.com.puc.sesmt.modelo.Epi;
import br.com.puc.sesmt.modelo.Setor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Louzada
 */
public class EpiDao extends DaoGeneric<Epi> {

    public EpiDao() {
        super(new Epi());
    }

    public boolean validaepi(Long ca) throws Exception {
        boolean retorno = false;

        Session session = ConnectionFactory.getSessionFactory().openSession();

        List lista = session.createCriteria(Epi.class).add(Restrictions.like("ca", ca)).list();
        if (!lista.isEmpty()) {

            retorno = true;
        }


        session.close();
        return retorno;


    }
}
