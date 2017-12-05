package br.com.trocagroup.controller;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.trocagroup.dao.ItemDAO;
import br.com.trocagroup.dao.UserDAO;
import br.com.trocagroup.dao.UserDAOImpl;
import br.com.trocagroup.model.Item;
import br.com.trocagroup.model.User;
@Controller
@RequestMapping("/welcome")
public class WelcomeController {
private UserDAO userDAO;
private ItemDAO itemDAO;

@Autowired(required=true)
@Qualifier(value="userDAO")
public void setPersonService(UserDAO dao){
	this.userDAO = dao;
}

@Autowired(required=true)
@Qualifier(value="itemDAO")
public void setItemService(ItemDAO dao){
	this.itemDAO = dao;
}
	
 @RequestMapping(value = "/home", method = RequestMethod.GET)
 public ModelAndView boasVindas(HttpServletRequest request) {

   User loggedUser = (User)request.getSession().getAttribute("user");
   List<Item> meusItens = itemDAO.getByUser(loggedUser.getId());
   loggedUser.setMeusItens(meusItens);
   
   List<Item> itens = itemDAO.getItensParaEmprestimo(loggedUser.getId());
   loggedUser.setItens(itens);
   
   List<Item> itensQueAloquei = itemDAO.getItensAloquei(loggedUser.getId());
   loggedUser.setItensQueAloquei(itensQueAloquei);
   
   request.getSession().setAttribute("user", loggedUser);
   return new ModelAndView("home");
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
 public ModelAndView login(@ModelAttribute("userForm") User user, HttpServletRequest request) {
	 String nextPage = "home";
	 String message = "";
	 
	 User loggedUser = null;
	 
	 if(user != null){
		 try{
		   loggedUser = userDAO.login(user.getEmail(), user.getPassword());
		   List<Item> meusItens = itemDAO.getByUser(loggedUser.getId());
		   loggedUser.setMeusItens(meusItens);
		   
		   List<Item> itens = itemDAO.getItensParaEmprestimo(loggedUser.getId());
		   loggedUser.setItens(itens);
		   
		   List<Item> itensQueAloquei = itemDAO.getItensAloquei(loggedUser.getId());
		   loggedUser.setItensQueAloquei(itensQueAloquei);
		   
		   request.getSession().setAttribute("user", loggedUser);
		   
		 }
		 catch(Exception e){
			 //throw e;
		 }
	 }
	 
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
 
 @RequestMapping(value="/createitem", method=RequestMethod.POST)
 public String createitem(@ModelAttribute("itemForm") Item item, HttpServletRequest request) {
	User loggedUser = (User)request.getSession().getAttribute("user");
	 
	item.setCodigoDono(loggedUser.getId());
	item.setNomeDono(loggedUser.getName());
	item.setNomeEmprestadoPara("");
	item.setEmprestadoPara(0);
    this.itemDAO.save(item);
	 	 	 
   return "redirect:/welcome/home";
 }
 
 @RequestMapping(value="/alugaritem", method=RequestMethod.POST)
 public String alugarItem(@ModelAttribute("itemForm") Item item, HttpServletRequest request) {
	User loggedUser = (User)request.getSession().getAttribute("user");
	 
	item.setNomeEmprestadoPara(loggedUser.getName());
	item.setEmprestadoPara(loggedUser.getId());
    this.itemDAO.update(item);
	 	 	 
   return "redirect:/welcome/home";
 }
 
 @RequestMapping(value="/devolveritem", method=RequestMethod.POST)
 public String devolverItem(@ModelAttribute("itemForm") Item item, HttpServletRequest request) {
	User loggedUser = (User)request.getSession().getAttribute("user");
	 
	item.setNomeEmprestadoPara("");
	item.setEmprestadoPara(0);
    this.itemDAO.update(item);
	 	 	 
   return "redirect:/welcome/home";
 }
 
 
  
}