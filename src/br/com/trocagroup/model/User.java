package br.com.trocagroup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.trocagroup.util.Utils;


@Entity
@Table(name="tb_user")
public class User {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private String celular;
	private String cep;
	private String endereco;
	private String cidade;
	private String bairro;
	private String estado;
	private String cpf;
	
	@Transient
	private List<Item> meusItens;
	
	@Transient
	private List<Item> itens;
	
	@Transient
	private List<Item> itensQueAloquei;
	
	
	
	

	public User(String name, String email, String password, String celular, String cep, String endereco, String cidade,
			String bairro, String estado, String cpf) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.celular = celular;
		this.cep = cep;
		this.endereco = endereco;
		this.cidade = cidade;
		this.bairro = bairro;
		this.estado = estado;
		this.cpf = cpf;
	}

	public User() {
	}



	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public List<Item> getItensQueAloquei() {
		return itensQueAloquei;
	}

	public void setItensQueAloquei(List<Item> itensQueAloquei) {
		this.itensQueAloquei = itensQueAloquei;
	}

	public boolean isEmailValid(){
		return Utils.validate(this.email, Utils.VALID_EMAIL_REGEX);
	}
	
	public boolean isPasswordValid(){
		return !this.password.isEmpty();
	}
	
	
	public boolean isCPFValid(){
		return Utils.validate(this.cpf, Utils.VALID_CPF_REGEX);
	}
	
	public boolean isCEPValid(){
		return Utils.validate(this.cep, Utils.VALID_CEP_REGEX);
	}
	
	public boolean isNameValid(){
		return Utils.validate(this.name, Utils.VALID_FULL_NAME_REGEX);
	}
	
	public boolean isStateValid(){
		
		ArrayList<String> states = new ArrayList() {{
		    add("AC");
		    add("AL");
		    add("AP");
		    add("AM");
		    add("BA");
		    add("CE");
		    add("DF");
		    add("ES");
		    add("GO");
		    add("MA");
		    add("MT");
		    add("MS");
		    add("MG");
		    add("PA");
		    add("PB");
		    add("PR");
		    add("PE");
		    add("PI");
		    add("RJ");
		    add("RN");
		    add("RS");
		    add("RO");
		    add("RR");
		    add("SC");
		    add("SP");
		    add("SE");
		    add("TO");
		}};
		
		return states.contains(this.estado);
	}
	

	public List<Item> getMeusItens() {
		return meusItens;
	}

	public void setMeusItens(List<Item> meusItens) {
		this.meusItens = meusItens;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", celular="
				+ celular + ", cep=" + cep + ", endereco=" + endereco + ", cidade=" + cidade + ", bairro=" + bairro
				+ ", estado=" + estado + ", cpf=" + cpf + "]";
	}
}
