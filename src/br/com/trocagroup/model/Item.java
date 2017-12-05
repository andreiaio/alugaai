package br.com.trocagroup.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.trocagroup.util.Utils;


@Entity
@Table(name="tb_objeto")
public class Item {
	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	
	private String nome;
	
	private String descricao;
	
	@Column(name="nome_dono")
	private String nomeDono;
	
	@Column(name="codigo_dono")
	private int codigoDono;
	
	@Column(name="codigo_emprestado_para")
	private int emprestadoPara;
	
	@Column(name="nome_emprestado_para")
	private String nomeEmprestadoPara;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeDono() {
		return nomeDono;
	}

	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}

	public int getCodigoDono() {
		return codigoDono;
	}

	public void setCodigoDono(int codigoDono) {
		this.codigoDono = codigoDono;
	}

	public int getEmprestadoPara() {
		return emprestadoPara;
	}

	public void setEmprestadoPara(int emprestadoPara) {
		this.emprestadoPara = emprestadoPara;
	}

	public String getNomeEmprestadoPara() {
		return nomeEmprestadoPara;
	}

	public void setNomeEmprestadoPara(String nomeEmprestadoPara) {
		this.nomeEmprestadoPara = nomeEmprestadoPara;
	}
	
	
	

}


