package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import daos.ChaveDAO;
import models.Chave;

@Controller
public class ChaveController {
	
	@RequestMapping("chave/formSaida")
	public String formSaida(){
		System.out.println("Acessando formulario de Chave saída.");
		return "chave/formSaida";
	}
	@RequestMapping("chave/formDevolucao")
	public String formDevolucao(){
		System.out.println("Acessando formulario de Chave devolução.");
		return "chave/formDevolucao";
	}
	
	@RequestMapping(value="chaves", method=RequestMethod.POST)
	public String gravarSaida(Chave chave){
		System.out.println("Acessando o metodo de gravar Empréstimo da chave!");
		
		System.out.println("Nome: " + chave.getNome());
		System.out.println("Matricula: " + chave.getMatricula());
		
		String data = "dd/MM/yyyy";
		String hora = "h:mm - a";
		String dataFormatada, horaFormatada;
		Date agora = new Date();
		SimpleDateFormat formata = new SimpleDateFormat(data);
		dataFormatada = formata.format(agora);
		formata = new SimpleDateFormat(hora);
		horaFormatada = formata.format(agora);
		chave.setDataSaida("Data: "+dataFormatada+" hora:"+horaFormatada);
		
		System.out.println("Data do Empréstimo " + chave.getDataSaida());
		
		
		ChaveDAO dao = new ChaveDAO();
		dao.inserirSaida(chave);
		
		return "redirect:chaves";
	}
	
	@RequestMapping(value="chaves/devolver", method=RequestMethod.POST)
	public ModelAndView gravarEntregue(Chave c){
		System.out.println("Acessando o metodo de devolução da chave!");
		
		System.out.println("Nome: " + c.getNomeEntregue());
		System.out.println("Matricula: " + c.getMatriculaEntregue());
		System.out.println("Data do Empréstimo " + c.getDataEntregue());
		
		String data = "dd/MM/yyyy";
		String hora = "h:mm - a";
		String dataFormatada, horaFormatada;
		Date agora = new Date();;
		SimpleDateFormat formata = new SimpleDateFormat(data);
		dataFormatada = formata.format(agora);
		formata = new SimpleDateFormat(hora);
		horaFormatada = formata.format(agora);
		c.setDataEntregue("Data: "+dataFormatada+" hora:"+horaFormatada);
		
		System.out.println("Data de entrega " + c.getDataEntregue());
		
		ChaveDAO dao = new ChaveDAO();
		dao.inserirEntrega(c);
		
		return listar();
	}
	
	@RequestMapping(value="chaves", method=RequestMethod.GET)
	public ModelAndView listar(){
		ChaveDAO dao = new ChaveDAO();
		List<Chave> chaves = dao.getLista();
		
		ModelAndView modelAndView = new ModelAndView("chave/listar");
		modelAndView.addObject("chaves",chaves);
		
		return modelAndView;
	}
	
	@RequestMapping("chaves/remover")
	public ModelAndView remover(Chave c){
		ChaveDAO dao = new ChaveDAO();
		dao.remover(c);
		
		return new ModelAndView("home");
	}
		
	@RequestMapping("chaves/devolver")
	public ModelAndView devolver(Chave chave){
		ChaveDAO dao = new ChaveDAO();
		chave = dao.getById(chave.getId());
		
		ModelAndView modelAndView = new ModelAndView("chave/formDevolucao");
		modelAndView.addObject("chaves", chave);
		
		return modelAndView;
	}
}