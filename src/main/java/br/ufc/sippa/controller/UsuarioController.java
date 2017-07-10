package br.ufc.sippa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(path="/listar", method=RequestMethod.GET)
	public ModelAndView todos(@RequestParam String tipo){
		ModelAndView model = new ModelAndView("listarUsuarios");
		switch (tipo) {
		case "aluno":
			model.addObject("usuarios", service.getAlunos());
			break;
		case "professor":
			model.addObject("usuarios", service.getProfessores());
			break;
		case "administrador":
			model.addObject("usuarios", service.getAdministradores());
			break;
		case "todos":
			
		default:
			model.addObject("usuarios", service.getTodosUsuarios());
			break;
		}
		
		return model;
	}
		
	@RequestMapping(path="/remover/{id}")
	public String removerConta(@PathVariable("id") Integer id){
		String tipo = service.getUsuarioById(id).getTipo();
		service.removerUsuario(id);
		return "redirect:/usuario/listar?tipo=".concat(tipo);
	}
	@RequestMapping(path="/cadastrarAluno")
	public String cadastrarAluno(){
		return "cadastrarAluno";
	}
	@RequestMapping(path="/salvar", method=RequestMethod.POST)
	public String salvarUsuario(@RequestParam String login, @RequestParam String nome, @RequestParam String senha, @RequestParam String tipo){
		service.salvarUsuario(login, nome, senha, tipo);
		
		return "redirect:/usuario/alunos";
	}
}
