package br.ufc.sippa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.sippa.model.Presenca;
import br.ufc.sippa.model.Usuario;
import br.ufc.sippa.service.PresencaService;


@Controller
@RequestMapping(path="/presenca/")
public class PresencaController {
	
	@Autowired
	PresencaService service;
	
	@RequestMapping(path="/")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("presencas");
		List<Presenca> presencas = service.getTodasPresencas();
		
		model.addObject("presencas",presencas);
		
		return model;
	}
	
	@RequestMapping(path="/{id}")
	public String detalhesConta(){
		return "detalhes-presenca";
	}
	
	@RequestMapping(path="/salvar", method=RequestMethod.POST)
	public String salvarPresenca(@RequestParam Usuario aluno,@RequestParam boolean status){
		
		service.salvarPresenca(aluno, status);
		
		return "redirect:/presenca/";
	}
}
