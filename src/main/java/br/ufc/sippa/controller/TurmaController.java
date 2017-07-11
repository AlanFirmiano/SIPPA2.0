package br.ufc.sippa.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.sippa.model.Disciplina;
import br.ufc.sippa.model.Turma;
import br.ufc.sippa.model.Usuario;
import br.ufc.sippa.service.DisciplinaService;
import br.ufc.sippa.service.TurmaService;
import br.ufc.sippa.service.UsuarioService;

@Controller
@RequestMapping(path="/turma/")
public class TurmaController {
	
	@Autowired
	TurmaService service;
	
	@Autowired
	UsuarioService serviceUser;
	@Autowired
	DisciplinaService serviceDisc;
	
	@RequestMapping(path="/listar")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("listarTurma");
		List<Turma> turmas = service.findAll();
		
		model.addObject("turmas",turmas);
		return model;
	}
	
	@RequestMapping(path="/cadastrar")
	public String cadastrarTurma(Model model){
		model.addAttribute("disciplinas", serviceDisc.findAll());
		model.addAttribute("professores", serviceUser.getUsuarioPorPapel("professor"));
		
		return "cadastrarTurma";
	}
	
	
	@RequestMapping(path="/cadastrar", method=RequestMethod.POST)
	public String alocar(@RequestParam String periodo,@RequestParam Disciplina disciplina, @RequestParam Usuario professor){
		service.save(periodo, disciplina, professor);
		
		return "redirect:/turma/listar";
	}	
	
	@RequestMapping(path="/{id}")
	public ModelAndView locacoes(@PathVariable("id") Integer id){
		ModelAndView model = new ModelAndView("alocarDesalocar");
		Turma turma = service.findOne(id);
		List<Usuario> alunosAll = serviceUser.getUsuarioPorPapel("aluno");
		
		model.addObject("alunosAll", alunosAll);
		model.addObject("turma", turma);
		return model;
	}	
	
	@RequestMapping(path="/{idTurma}/alocarAluno/{idAluno}", method=RequestMethod.GET)
	public String alocarAluno(@PathVariable("idTurma") Integer idTurma, 
			@PathVariable("idAluno") Long idAluno){
		service.alocarAlunos(idTurma, idAluno);
		
		return "redirect:/turma/"+idTurma;
	}
	
	@RequestMapping(path="/{idTurma}/desalocarAluno/{idAluno}", method=RequestMethod.GET)
	public String desalocarAluno(@PathVariable("idTurma") Integer idTurma, 
			@PathVariable("idAluno") Long idAluno){
		
		service.desalocarAlunos(idTurma, idAluno);
		
		return "redirect:/turma/"+idTurma;
	}
	
	@RequestMapping(path="/remover/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes attributes){
		service.delete(id);
		if(service.findOne(id)==null){
			attributes.addFlashAttribute("mensagemSucesso", "Usuário removido com sucesso!");
		}
		return "redirect:/turma/listar";
	}
}
