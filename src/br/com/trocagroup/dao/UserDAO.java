package br.com.trocagroup.dao;

import br.com.trocagroup.model.User;

public interface UserDAO {

	public User login(String email, String password);
	public void save(User pessoa);
	
}