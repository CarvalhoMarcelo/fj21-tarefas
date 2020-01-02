package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcLoginDao;
import br.com.caelum.tarefas.modelo.Usuario;

@Controller
public class LoginController {	
	
	JdbcLoginDao dao = new JdbcLoginDao();
	
	@RequestMapping("formLogin")
	public String formulario() {		
		return "login/login-form";		
	}	
	
	@RequestMapping("loginUsuario")
	public String login(@Valid Usuario usuario, BindingResult result, HttpSession session) {

		if(result.hasFieldErrors("usuario")) {
			return "forward:formLogin";
		}		
				
		if(!dao.login(usuario))
			return "forward:formLogin";
		else {
			session.setAttribute("usuarioLogado", usuario);
			return "redirect:listaTarefas";			
		}		
	}

	@RequestMapping("desconectarUsuario")
	public String desconecta(HttpSession session) {
		session.invalidate();
		return "redirect:formLogin";	
	}
}
