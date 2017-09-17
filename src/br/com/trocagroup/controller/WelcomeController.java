package br.com.trocagroup.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/welcome")
public class WelcomeController {
 @RequestMapping(value = "/home", method = RequestMethod.GET)
 public ModelAndView boasVindas(@RequestParam(value = "nome", required = false, defaultValue = "Deia") String nome) {

 ModelAndView modelAndView = new ModelAndView("home");
 modelAndView.addObject("mensagem", "Olá " + nome);

 return modelAndView;
 }

}