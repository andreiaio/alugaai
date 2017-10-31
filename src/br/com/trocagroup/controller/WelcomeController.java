package br.com.trocagroup.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.trocagroup.dao.UserDAO;
import br.com.trocagroup.dao.UserDAOImpl;
import br.com.trocagroup.model.User;
@Controller
@RequestMapping("/welcome")
public class WelcomeController {
private UserDAO userDAO;

@Autowired(required=true)
@Qualifier(value="userDAO")
public void setPersonService(UserDAO dao){
	this.userDAO = dao;
}
	
 @RequestMapping(value = "/home", method = RequestMethod.GET)
 public ModelAndView boasVindas(@RequestParam(value = "nome", required = false, defaultValue = "Andreia Kaori") String nome) {

 ModelAndView modelAndView = new ModelAndView("home");
 modelAndView.addObject("mensagem", "Seja bem vinda, " + nome);

 return modelAndView;
 }

 @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
 public ModelAndView cadastro() {

 ModelAndView modelAndView = new ModelAndView("cadastro");

 return modelAndView;
 }
 
 @RequestMapping(value = "/login", method = RequestMethod.GET)
 public ModelAndView login() {

 ModelAndView modelAndView = new ModelAndView("login");

 return modelAndView;
 }
 
 @RequestMapping(value="/performLogin", method=RequestMethod.POST)
 public ModelAndView login(@ModelAttribute("userForm") User user,RedirectAttributes redirectAttributes) {
	 String nextPage = "home";
	 String message = "";
	 
	 User loggedUser = null;
	 
	 if(user != null){
		 try{
		   loggedUser = userDAO.login(user.getEmail(), user.getPassword());
		 }
		 catch(Exception e){
			 //throw e;
		 }
	 }
	 
	 System.out.println(loggedUser);
	 
	 if(loggedUser==null){
		 nextPage = "login";
		 message+="Email ou senha inválido(s)";
	 }
	 else{
		 message = loggedUser.getName().split(" ")[0];
	 }
	 
	 return new ModelAndView(nextPage,"message", message);
 }
 
 @RequestMapping(value="/createaccount", method=RequestMethod.POST)
 public ModelAndView createAccount(@ModelAttribute("userForm") User user) {
	 String nextPage = "home";
	 String message = "";
	 
	 if(!user.isNameValid()){
		 nextPage = "cadastro";
		 message+="Nome inválido;<br/>";
	 }
	 
	 if(!user.isEmailValid()){
		 nextPage = "cadastro";
		 message+="Email inválido;<br/> ";
	 }
	 
	 if(!user.isPasswordValid()){
		 nextPage = "cadastro";
		 message+="Senha inválida;<br/> ";
	 }
	 
	 if(!user.isCPFValid()){
		 nextPage = "cadastro";
		 message+="CPF inválido;<br/> ";
	 }
	 
	 if(message.isEmpty()){
		 message = user.getName().split(" ")[0];
		 this.userDAO.save(user);
	 }
	 	 	 
	 return new ModelAndView(nextPage,"message",message);
 }
 
 
  
}