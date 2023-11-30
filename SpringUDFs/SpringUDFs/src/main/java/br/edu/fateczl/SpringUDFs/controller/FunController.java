package br.edu.fateczl.SpringUDFs.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.fateczl.SpringUDFs.model.Funcionario;
import br.edu.fateczl.SpringUDFs.persistence.FunDao;


@Controller
public class FunController {

	@Autowired
	FunDao fDao;
	int cod;
	float ValorTotal;
	@RequestMapping(name = "funcionario", value = "/funcionario", method = RequestMethod.POST)
	public ModelAndView funcionarios(ModelMap model, @RequestParam Map<String, String> allParams) {
		String codigo = allParams.get("codigo");
		String botao = allParams.get("botao");
		
		
		
		List<Funcionario> funcionarios = new ArrayList<>();
		String erro = "";
		String saida = "";
		
		try {
			cod = Integer.parseInt(codigo);
			if(botao.equalsIgnoreCase("buscar")) {
				ValorTotal = fDao.SomarSalario(cod);
			} else {
				if(botao.equalsIgnoreCase("listar")) {
					funcionarios = fDao.lista();
				}
			  }
			
		} catch(ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
			
		} finally {
			
			model.addAttribute("funcionarios", funcionarios);
			model.addAttribute("ValorTotal", ValorTotal);
			model.addAttribute("erro", erro);
			model.addAttribute("saida", saida);
		}
		
		return new ModelAndView("funcionario");
	}
}
