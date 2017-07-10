package br.ufc.sippa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoutingController {
	
//	@Autowired
//	private UsuarioService userSvc;
	
	@RequestMapping(value = {"/","/login"},  method = { RequestMethod.GET, RequestMethod.POST })
	public String login(){
		return "/login";
	}
//	sessão, ta com bug
//	@RequestMapping(value = "/login",  method = { RequestMethod.GET, RequestMethod.POST })
//	public String login(HttpServletRequest request, HttpSession session){
//		String login = request.getUserPrincipal().getName();
//		//Buscar usuario pelo login
//		Usuario usr = userSvc.findByLogin(login);
//		if (usr == null)
//			//Tratar se tiver nulo
//
//		session.setAttribute("user_logged", usr);
//		return "/login";
//	}

	@RequestMapping(value={"/home"})
	public String home(){
		return "tabs/index";
	}
	
	@RequestMapping(path="/usuario")
	public String usuario(){
		return "usuario/";
	}

	
	@RequestMapping(path="/disciplinas")
	public String disciplinas(){
		return "disciplinas";
	}

	
}
