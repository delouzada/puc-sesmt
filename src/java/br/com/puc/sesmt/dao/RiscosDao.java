/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.dao;

import br.com.puc.sesmt.Interface.DaoGeneric;
import br.com.puc.sesmt.factory.ConnectionFactory;
import br.com.puc.sesmt.modelo.Riscos;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Louzada
 */
public class RiscosDao extends DaoGeneric<Riscos> {

    public RiscosDao() {
        super( new Riscos());
    }

   
    public Boolean ValidaRisco(String efeitosaude){
    boolean retorno = false;
    
   Session session = ConnectionFactory.getSessionFactory().openSession();

        List lista = session.createCriteria(Riscos.class)
                .add(Restrictions.like("efeitosaude", efeitosaude)).list();
        if (!lista.isEmpty()) {

            retorno = true;
        }

    
    
    
    return retorno;
    }
    
    
}
