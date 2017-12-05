package br.com.trocagroup.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.trocagroup.model.Item;

public class ItemDAOImpl implements ItemDAO {
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public void save(Item item) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(item);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Item item) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(item);
		tx.commit();
		session.close();
	}

	@Override
	public List<Item> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Item> getByUser(int user) {
		String query = "from Item i WHERE i.codigoDono=:user";
		Session session = this.sessionFactory.openSession();
		List<Item> Itens = session.createQuery(query)
				.setParameter("user", user).list();
		System.out.println("queeeeeeeeeeeeeeeeeeeeeery");
		System.out.println(Itens);
		session.close();
		return Itens;
	}

	@Override
	public List<Item> getItensParaEmprestimo(int user) {
		String query = "from Item i WHERE i.codigoDono!=:user and i.emprestadoPara = 0";
		Session session = this.sessionFactory.openSession();
		List<Item> Itens = session.createQuery(query)
				.setParameter("user", user).list();
		System.out.println("queeeeeeeeeeeeeeeeeeeeeery");
		System.out.println(Itens);
		session.close();
		return Itens;
	}

	@Override
	public List<Item> getItensAloquei(int user) {
		String query = "from Item i WHERE i.emprestadoPara=:user";
		Session session = this.sessionFactory.openSession();
		List<Item> Itens = session.createQuery(query)
				.setParameter("user", user).list();
		System.out.println("queeeeeeeeeeeeeeeeeeeeeery");
		System.out.println(Itens);
		session.close();
		return Itens;
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Person> list() {
//		Session session = this.sessionFactory.openSession();
//		List<Person> personList = session.createQuery("from Person").list();
//		session.close();
//		return personList;
//	}

}
