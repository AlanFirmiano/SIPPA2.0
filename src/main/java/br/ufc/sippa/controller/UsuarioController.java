package br.ufc.sippa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.sippa.model.Usuario;
import br.ufc.sippa.service.UsuarioService;

@Controller
@RequestMapping(path="/usuario/")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	private void getListUsuario(ModelAndView model, String tipo){
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
	}
	
	@RequestMapping(path="/")
	public String index(){
		return "redirect:/usuario/listar?tipo=todos";
	}
	
	@RequestMapping(path="/listar", method=RequestMethod.GET)
	public ModelAndView todos(@RequestParam String tipo){
		ModelAndView model = new ModelAndView("listarUsuarios");
		getListUsuario(model, tipo);
		return model;
	}
		
	@RequestMapping(path="/remover/{id}")
	public String removerConta(@PathVariable("id") Integer id, RedirectAttributes attributes){
		service.delete(id);
		if(service.findOne(id)==null){
			attributes.addFlashAttribute("mensagemSucesso", "Usuário removido com sucesso!");
		}
		return "redirect:/usuario";
	}
	
	@RequestMapping(value={"/cadastrar"}, method=RequestMethod.GET)
	public String cadastrar(Model model){
		Usuario user= new Usuario();
		model.addAttribute("usuario", user);
		return "cadastrarUsuario";
	}
	@RequestMapping(value={"/cadastrar"}, method=RequestMethod.POST)
	public String create_account_post(Usuario usuario, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()){
			attributes.addAttribute("erro",result.getAllErrors().get(0));
			return "redirect:/usuario/cadastrar";
		}
		service.save(usuario);
		attributes.addFlashAttribute("mensagemSucesso", "Usuário cadastrado com sucesso!");
		return "redirect:/usuario";
	}
	
}
