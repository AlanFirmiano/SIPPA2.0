package br.ufc.sippa.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.sippa.model.Turma;
import br.ufc.sippa.model.Usuario;
import br.ufc.sippa.service.TurmaService;
import br.ufc.sippa.service.UsuarioService;

@Controller
@RequestMapping(path="/turmas/")
public class TurmaController {
	
	@Autowired
	TurmaService service;
	
	@Autowired
	UsuarioService serviceUser;
	
	@RequestMapping(path="/lista")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("turma");
		List<Turma> turma = service.getTodasTurmas();
		
		model.addObject("turma",turma);
		
		return model;
	}
	
	@RequestMapping(path="/alunos")
	public ModelAndView alunos(){
		ModelAndView model = new ModelAndView("alunos");
		List<Usuario> alunos = serviceUser.getTodosUsuarios();
		
		model.addObject("alunos",alunos);
		
		return model;
	}
	
	
	@RequestMapping(path="/cadastrarTurma")
	public String cadastrarTurma(){
		return "cadastrarTurma";
	}
	
	@RequestMapping(path="/lista/alocar")
	public String alocar(){
		return "alocar";
	}
	@RequestMapping(path="/salvar", method=RequestMethod.POST)
	public String alocar(@RequestParam String codigo,@RequestParam String nome){
		
		service.salvarTurma(codigo, nome);
		
		return "redirect:/turma/lista";
	}
	@RequestMapping(path="/alocar/{idTurma}/alocarAluno", method=RequestMethod.POST)
	public String alocarAluno(@PathVariable("idTurma") Integer idTurma, 
			@PathVariable("idAluno") Long idAluno){
		
		service.alocarAluno(idTurma, idAluno);
		
		return "redirect:/turma/lista/alocar/"+idTurma;
	}
//	@RequestMapping(path="/salvar", method=RequestMethod.POST)
//	public String salvarTurma(@RequestParam String codigo,@RequestParam String nome,
//			@RequestParam String periodo/*, @RequestParam Usuario professor*/){
//		
//		service.salvarTurma(codigo, nome, periodo/*, professor*/);
//		
//		return "redirect:/turma/lista";
//	}
	
	@RequestMapping(path="/lista/remover/{id}")
	public String removerTurma(@PathVariable("id") Integer id){
		service.removerTurma(id);
		return "redirect:/turma/lista";
	}
}
