package br.ufc.sippa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrincipalController {
	@RequestMapping(path="/")
	public String index(){
		return "index";
	}
	@RequestMapping(path="/usuario")
	public String usuario(){
		return "usuario";
	}
	@RequestMapping(path="/adm")
	public String adm(){
		return "adm";
	}
	@RequestMapping(path="/disciplinas")
	public String disciplinas(){
		return "disciplinas";
	}
}
