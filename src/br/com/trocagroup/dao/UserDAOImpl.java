package br.com.trocagroup.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.trocagroup.model.User;

public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public void save(User user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(user);
		tx.commit();
		session.close();
	}

	@Override
	public User login(String email, String password) {
		String query = String.format("from User WHERE email=%s and password=%s", email,password);
		Session session = this.sessionFactory.openSession();
		User user = (User) session.createQuery(query).uniqueResult();
		return user;
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
