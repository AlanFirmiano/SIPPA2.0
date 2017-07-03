package br.ufc.sippa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(path="/{id}")
	public String detalhesConta(){
		return "detalhes-conta";
	}
	
	@RequestMapping(path="/salvar", method=RequestMethod.POST)
	public String salvarUsuario(@RequestParam String login,@RequestParam String nome,@RequestParam String senha){
		service.salvarUsuario(login, nome, senha);
		
		return "redirect:/usuario/";
	}
}
