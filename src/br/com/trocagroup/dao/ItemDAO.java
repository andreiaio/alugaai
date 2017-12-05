package br.com.trocagroup.dao;

import java.util.List;
import br.com.trocagroup.model.Item;;


public interface ItemDAO {

	public void save(Item item);
	public void update(Item p);
	public List<Item> list();
	public Item getById(int id);
	public List<Item> getByUser(int user);
	public List<Item> getItensParaEmprestimo(int user);
	public List<Item> getItensAloquei(int user);
	public void delete(int id);	
}