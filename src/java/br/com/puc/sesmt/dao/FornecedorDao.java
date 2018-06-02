/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.dao;

import br.com.puc.sesmt.Interface.DaoGeneric;
import br.com.puc.sesmt.factory.ConnectionFactory;
import br.com.puc.sesmt.modelo.Fornecedor;
import br.com.puc.sesmt.modelo.Funcionario;
import br.com.puc.sesmt.modelo.Setor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Louzada
 */
public class FornecedorDao extends DaoGeneric<Fornecedor> {

      private Criteria criteria;
    public FornecedorDao() {
        super(new Fornecedor());
    }
    
    
    
    public boolean validaFornecedor(String cnpj) throws Exception {
        boolean retorno = false;

        Session session = ConnectionFactory.getSessionFactory().openSession();

        List lista = session.createCriteria(Fornecedor.class)
                .add(Restrictions.like("cnpj", cnpj)).list();
        if (!lista.isEmpty()) {

            retorno = true;
        }


        session.close();
        return retorno;


    }


    
    	 @Override
	 public List<Fornecedor> findAll() {
        Session session = ConnectionFactory.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        
      criteria = session.createCriteria(Fornecedor.class);
		
        List<Fornecedor> lista = criteria.list();
		
        
        t.commit();
        session.close();
        return lista;
    }
   
    
    
}
