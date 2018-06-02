package br.com.puc.sesmt.dao;

import br.com.puc.sesmt.Interface.DaoGeneric;
import br.com.puc.sesmt.factory.ConnectionFactory;
import br.com.puc.sesmt.modelo.Funcionario;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class FuncionarioDao extends DaoGeneric<Funcionario> {

    Criteria criteria;

    public FuncionarioDao() {
        super(new Funcionario());
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Funcionario> findAll() {
        Session session = ConnectionFactory.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        criteria = session.createCriteria(Funcionario.class);

        List<Funcionario> lista = criteria.list();


        t.commit();
        return lista;
    }

    public void remove(Funcionario funcionario) {

        Session session = ConnectionFactory.getSessionFactory().openSession();

        Transaction t = session.beginTransaction();

        session.delete(funcionario);

        t.commit();

    }

    @Override
    public void update(Funcionario funcionario) {

        Session session = ConnectionFactory.getSessionFactory().openSession();

        Transaction t = session.beginTransaction();

        System.out.println(funcionario);
        session.update(funcionario);
        t.commit();
        session.close();

    }

    public boolean validaFuncionario(Long matricula) throws Exception {
        boolean retorno = false;

        Session session = ConnectionFactory.getSessionFactory().openSession();

        List lista = session.createCriteria(Funcionario.class).add(Restrictions.like("matricula", matricula)).list();
        if (!lista.isEmpty()) {

            retorno = true;
        }


        session.close();
        return retorno;


    }

    
    
    
    
}
