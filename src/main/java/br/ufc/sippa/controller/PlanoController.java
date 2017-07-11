package br.ufc.sippa.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.sippa.model.Plano;
import br.ufc.sippa.service.PlanoService;

@Controller
@RequestMapping(path="/plano/")
public class PlanoController {
	@Autowired
	PlanoService service;
	
	@RequestMapping(path="/")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("planos");
		List<Plano> planos = service.getTodosPlanos();
		
		model.addObject("planos",planos);
		
		return model;
	}
	
	@RequestMapping(path="/cadastrar", method=RequestMethod.POST)
	public String salvarPlano(@RequestParam String plano,@RequestParam String diario,@RequestParam Date data){
		
		service.salvarPlano(plano, diario, data);
		
		return "redirect:/plano/";
	}
}
