package br.com.trocagroup.dao;

import java.util.List;

import br.com.trocagroup.model.User;

public interface UserDAO {

	public void save(User user);
	public void update(User p);
	public List<User> list();
	public User getById(int id);
	public void delete(int id);
	public User login(String email, String Password);
	
}