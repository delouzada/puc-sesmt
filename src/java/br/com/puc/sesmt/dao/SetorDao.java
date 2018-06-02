package br.com.puc.sesmt.dao;

import br.com.puc.sesmt.Interface.DaoGeneric;
import br.com.puc.sesmt.factory.ConnectionFactory;
import br.com.puc.sesmt.modelo.Departamento;
import br.com.puc.sesmt.modelo.Setor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class SetorDao extends DaoGeneric<Setor> {

    Criteria criteria;

    public SetorDao() {
        super(new Setor());
        // TODO Auto-generated constructor stub
    }

    public List<Departamento> findDepartamentos() {
        Session session = ConnectionFactory.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        criteria = session.createCriteria(Departamento.class);

        List<Departamento> lista = criteria.list();


        t.commit();
        session.close();
        return lista;
    }

    public boolean validaSetor(String nomesetor) throws Exception {
        boolean retorno = false;

        Session session = ConnectionFactory.getSessionFactory().openSession();

        List lista = session.createCriteria(Setor.class).add(Restrictions.like("nomesetor", nomesetor)).list();
        if (!lista.isEmpty()) {

            retorno = true;
        }


        session.close();
        return retorno;


    }

    
    public Integer update(Setor setor, Departamento departamento) {

        Session session = ConnectionFactory.getSessionFactory().openSession();





        Query query = session.createQuery("update Setor  set NOMESETOR  = :nomesetor, LOCALSETOR = :localsetor, CODDEPTO = :codepto  where CODSETOR  = :id");
        query.setParameter("id", setor.getCodsetor());

        
        query.setParameter("nomesetor", setor.getNomesetor());

        query.setParameter("localsetor", setor.getLocalsetor());
        query.setParameter("codepto", departamento.getCoddepto());

        Integer result = query.executeUpdate();

        System.out.println("Query" + result);


        Transaction t = session.beginTransaction();


        t.commit();






        return result;
    }
}
