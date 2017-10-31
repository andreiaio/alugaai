package br.com.trocagroup.dao;


import java.util.List;

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
		String query = "from User u WHERE u.email=:email and u.password=:password";
		System.out.println("queeeeeeeeeeeeeeeery:   "+ query);
		Session session = this.sessionFactory.openSession();
		User user = (User) session.createQuery(query)
				.setParameter("email", email)
				.setParameter("password", password)
				.uniqueResult();
		return user;
	}

	@Override
	public void update(User p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
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
