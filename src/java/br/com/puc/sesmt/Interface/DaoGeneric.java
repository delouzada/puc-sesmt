package br.com.puc.sesmt.Interface;

import br.com.puc.sesmt.factory.ConnectionFactory;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

public abstract class DaoGeneric<E> implements IDaoGeneric<E> {

	
	Session session;
	
	Transaction transaction;
	
	Criteria criteria;
	
	private E entity;

	public DaoGeneric(E entity){
		
		this.entity = entity;
	}
	
	
	
    @Override
	public void save(E obj) throws Exception {
		
		session = ConnectionFactory.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(obj);
		session.flush();
		transaction.commit();
		
                session.close();
		
		
		
	}
	
	
    @Override
	public void delete(E obj) throws Exception {
		
		session = ConnectionFactory.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(obj);
		session.flush();
                transaction.commit();
		session.close();
		
		
	}
	
	
    @Override
	public void update(E obj) throws Exception {
		
		session = ConnectionFactory.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		//session.flush();
                
                
                session.update(obj);
		
                transaction.commit();
		
                session.close();
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E findByCod(Long id) throws Exception {
		
		session = ConnectionFactory.getSessionFactory().openSession();
		
		E classe = (E) session.get(entity.getClass(), id);
		session.close();
		
		return classe;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<E> findAll() throws Exception {
		
		session = ConnectionFactory.getSessionFactory().openSession();
		
		criteria = session.createCriteria(entity.getClass());
		
		List<E> lista = criteria.list();
		session.close();
		
		
		return lista;
	}
	
	
	
	
	
}
