package br.com.caelum.tarefas.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;


@Controller
public class TarefasController {	
	
	private JdbcTarefaDao dao;	
	
	@RequestMapping("novaTarefa")
	public String form() {		
		return "tarefa/formulario";
	}	
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) throws SQLException {

			if(result.hasFieldErrors("descricao")) {
				return "tarefa/formulario";
			}		
			if(result.hasErrors()) {
				return "tarefa/formulario";
			}			
			dao = new JdbcTarefaDao();			
			dao.adiciona(tarefa);
			return "redirect:listaTarefas";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Long id) throws SQLException {
		dao = new JdbcTarefaDao();			
		dao.remove(id);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostrar(Long id, Model model) throws SQLException {
		dao = new JdbcTarefaDao();
		Tarefa tarefa = new Tarefa();
		tarefa = dao.mostra(id);
		model.addAttribute("tarefa", tarefa);		
		return "tarefa/mostra-tarefa";				
	}	
	
	@RequestMapping("alteraTarefa")
	public String altera(@Valid Tarefa tarefa, BindingResult result) throws SQLException {
		
		if(result.hasFieldErrors("descricao")) {
			return "tarefa/mostra-tarefa";
		}		
		if(result.hasErrors()) {
			return "tarefa/mostra-tarefa";	
		}		
		
	    dao = new JdbcTarefaDao();
	    dao.altera(tarefa);
		return "redirect:listaTarefas";

	}	
	
	@RequestMapping("listaTarefas")
	public String lista(Model model) throws SQLException {
		
		dao = new JdbcTarefaDao();
		List<Tarefa> lista = dao.lista();
		model.addAttribute("lista", lista);		
		return "tarefa/lista-tarefa";
	}	
	
	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, Model model) throws SQLException {
		dao = new JdbcTarefaDao();
		dao.finalizaTarefa(id);		
		model.addAttribute("tarefa", dao.buscaTarefa(id));
		
		return "tarefa/finalizada";
		
	}
	
	
	
}
