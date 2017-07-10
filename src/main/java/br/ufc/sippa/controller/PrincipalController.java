package br.ufc.sippa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrincipalController {
	@RequestMapping(path="/")
	public String index(){
		return "index";
	}
	@RequestMapping(path="/login")
	public String login(){
		return "admin/index";
	}
	@RequestMapping(path="/admin")
	public String admin(){
		return "admin/index";
	}
	@RequestMapping(path="/professor")
	public String professor(){
		return "professor/index";
	}
	@RequestMapping(path="/aluno")
	public String aluno(){
		return "aluno/index";
	}
	@RequestMapping(path="/disciplinas")
	public String disciplinas(){
		return "disciplinas";
	}
}
