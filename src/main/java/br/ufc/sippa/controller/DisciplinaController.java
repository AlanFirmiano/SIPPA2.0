package br.ufc.sippa.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.sippa.model.Disciplina;
import br.ufc.sippa.model.Usuario;
import br.ufc.sippa.service.DisciplinaService;

@Controller
@RequestMapping(path="/disciplinas/")
public class DisciplinaController {
	
	@Autowired
	DisciplinaService service;
	
	@RequestMapping(path="/lista")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("disciplinas");
		List<Disciplina> disciplinas = service.getTodasDisciplinas();
		
		model.addObject("disciplinas",disciplinas);
		
		return model;
	}
	
	@RequestMapping(path="/{id}")
	public String detalhesDisciplina(){
		return "detalhes-disciplina";
	}
	@RequestMapping(path="/cadastrarDisciplina")
	public String cadastrarDisciplina(){
		return "cadastrarDisciplina";
	}
	@RequestMapping(path="/salvar", method=RequestMethod.POST)
	public String salvarDisciplina(@RequestParam String codigo,@RequestParam String nome,
			@RequestParam String periodo/*, @RequestParam Usuario professor*/){
		
		service.salvarDisciplina(codigo, nome, periodo/*, professor*/);
		
		return "redirect:/disciplinas/lista";
	}
	@RequestMapping(path="/lista/remover/{id}")
	public String removerDisciplina(@PathVariable("id") Integer id){
		service.removerDisciplina(id);
		return "redirect:/disciplinas/lista";
	}
}
