package br.ufc.sippa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.sippa.model.Disciplina;
import br.ufc.sippa.service.DisciplinaService;
import br.ufc.sippa.service.UsuarioService;

@Controller
@RequestMapping(path="/disciplina/")
public class DisciplinaController {
	
	@Autowired
	DisciplinaService service;
	
	@Autowired
	UsuarioService serviceUser;
	
	@RequestMapping(path="/listar")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("listarDisciplinas");
		model.addObject("disciplinas", service.findAll());
		return model;
	}
	
	@RequestMapping(path="/cadastrar")
	public String cadastrarDisciplina(){
		return "cadastrarDisciplina";
	}
	
	@RequestMapping(path={"/cadastrar"}, method=RequestMethod.POST)
	public String cadastrar_post(Disciplina disciplina, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()){
			attributes.addAttribute("erro",result.getAllErrors().get(0));
			return "redirect:/usuario/cadastrar";
		}
		service.save(disciplina);
		attributes.addFlashAttribute("mensagemSucesso", "Disciplina cadastrado com sucesso!");
		return "redirect:/disciplina/listar";
	}
	

	@RequestMapping(path="/remover/{id}")
	public String removerDisciplina(@PathVariable("id") Integer id, RedirectAttributes attributes){
		service.delete(id);
		if(service.findOne(id)==null){
			attributes.addFlashAttribute("mensagemSucesso", "Usuário removido com sucesso!");
		}
		return "redirect:/disciplina/listar";
	}
	
}
