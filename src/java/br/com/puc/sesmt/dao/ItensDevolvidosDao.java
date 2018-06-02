/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.dao;

import br.com.puc.sesmt.Interface.DaoGeneric;
import br.com.puc.sesmt.factory.ConnectionFactory;
import br.com.puc.sesmt.modelo.Funcionario;
import br.com.puc.sesmt.modelo.Itensdevolvidos;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Louzada
 */
public class ItensDevolvidosDao extends DaoGeneric<Itensdevolvidos> {

    public ItensDevolvidosDao() {
        super(new Itensdevolvidos());
    }
    
    
    public List<Itensdevolvidos> findByMatricula(Funcionario funcionario) throws Exception {
	
            
            
                Session session;
        
		session = ConnectionFactory.getSessionFactory().openSession();
	
                List lista = session.createCriteria(Itensdevolvidos.class).add(Restrictions.like("funcionario", funcionario)).list();
		session.close();
		
		return lista;
	}
	
    
        
    
        public Integer updateEstoque(Integer quantidade  , Long id) {

        Session session = ConnectionFactory.getSessionFactory().openSession();

        Query query = session.createQuery("update Epi  set QUANTIDADE  = :quantidade where CODEPI  = :id");
        query.setParameter("quantidade", quantidade);
        query.setParameter("id", id);
        Integer result = query.executeUpdate();

        System.out.println("Query" + result);
        
        
        Transaction t = session.beginTransaction();

        
        t.commit();

        
        
        


        return result;
    }

    
        
        public Integer updateAdquirir(Integer quantidade  , Long id) {

        Session session = ConnectionFactory.getSessionFactory().openSession();

        Query query = session.createQuery("update Epi  set QUANTIDADE  = :quantidade where CODEPI  = :id");
        query.setParameter("quantidade", quantidade);
        query.setParameter("id", id);
        Integer result = query.executeUpdate();

        System.out.println("Query" + result);
        
        
        Transaction t = session.beginTransaction();

        
        t.commit();

        
        
        


        return result;
    }

        
    
}
