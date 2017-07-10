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
import br.ufc.sippa.service.UsuarioService;

@Controller
@RequestMapping(path="/disciplinas/")
public class DisciplinaController {
	
	@Autowired
	DisciplinaService service;
	
	@Autowired
	UsuarioService serviceUser;
	
	@RequestMapping(path="/lista")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("disciplinas");
		List<Disciplina> disciplinas = service.getTodasDisciplinas();
		
		model.addObject("disciplinas",disciplinas);
		
		return model;
	}
	@RequestMapping(path="/alunos")
	public ModelAndView alunos(){
		ModelAndView model = new ModelAndView("alunos");
		List<Usuario> alunos = serviceUser.getTodosUsuarios();
		
		model.addObject("alunos",alunos);
		
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
	
	@RequestMapping(path="/lista/alocar")
	public String alocar(){
		return "alocar";
	}
	@RequestMapping(path="/alocar/salvar", method=RequestMethod.POST)
	public String alocar(@RequestParam String codigo,@RequestParam String nome,
			@RequestParam String periodo){
		
		service.salvarDisciplina(codigo, nome, periodo);
		
		return "redirect:/disciplinas/lista/alocar";
	}
	@RequestMapping(path="/alocar/{idDisciplina}/alocarAluno", method=RequestMethod.POST)
	public String alocarAluno(@PathVariable("idDisciplina") Integer idDisciplina, 
			@PathVariable("idAluno") Long idAluno){
		
		service.alocarAluno(idDisciplina, idAluno);
		
		return "redirect:/disciplinas/lista/alocar/"+idDisciplina;
	}
//	@RequestMapping(path="/salvar", method=RequestMethod.POST)
//	public String salvarDisciplina(@RequestParam String codigo,@RequestParam String nome,
//			@RequestParam String periodo/*, @RequestParam Usuario professor*/){
//		
//		service.salvarDisciplina(codigo, nome, periodo/*, professor*/);
//		
//		return "redirect:/disciplinas/lista";
//	}
	
	@RequestMapping(path="/lista/remover/{id}")
	public String removerDisciplina(@PathVariable("id") Integer id){
		service.removerDisciplina(id);
		return "redirect:/disciplinas/lista";
	}
}
