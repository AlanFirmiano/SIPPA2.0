package br.ufc.sippa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.sippa.model.Usuario;
import br.ufc.sippa.service.UsuarioService;

@Controller
@RequestMapping(path="/usuario/")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	@RequestMapping(path="/")
	public String index(){
		return "usuario";
	}
	@RequestMapping(path="/alunos")
	public ModelAndView alunos(){
		ModelAndView model = new ModelAndView("alunos");
		List<Usuario> alunos = service.getTodosUsuarios();
		
		model.addObject("alunos",alunos);
		
		return model;
	}
	@RequestMapping(path="/{id}")
	public String detalhesConta(){
		return "detalhes-conta";
	}
	
	@RequestMapping(path="/alunos/remover/{id}")
	public String removerConta(@PathVariable("id") Integer id){
		service.removerConta(id);
		return "redirect:/usuario/alunos";
	}
	@RequestMapping(path="/cadastrarAluno")
	public String cadastrarAluno(){
		return "cadastrarAluno";
	}
	@RequestMapping(path="/salvar", method=RequestMethod.POST)
	public String salvarUsuario(@RequestParam String login,@RequestParam String nome,@RequestParam String senha){
		service.salvarUsuario(login, nome, senha);
		
		return "redirect:/usuario/alunos";
	}
}
