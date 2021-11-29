package com.leopompeu.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.leopompeu.crm.model.Enfermeiros;
import com.leopompeu.crm.repository.EnfermeirosRepository;


//Controlador dos Enfermeiros
@Controller
public class enfermeirosController {
	
	//Declarando Repositório
	@Autowired
	private EnfermeirosRepository enfermeirosRepository;

	//Chamada da página "cadastra enfermeiro"
	@RequestMapping(value="/cadastraEnfermeiro", method=RequestMethod.GET)
	public String form(){
		return "/cadastraEnfermeiro";
	}
	
	//Aplicando os valores de cadastro no banco de dados
	@RequestMapping(value="/cadastraEnfermeiro", method=RequestMethod.POST)
	public String form(Enfermeiros enfermeiros){
		
		enfermeirosRepository.save(enfermeiros);
		return "redirect:/consultaEnfermeiros";
	}
	
	//Model And View dos Enfermeiros
	@RequestMapping("/consultaEnfermeiros")
	public ModelAndView listaEnfermeiros() {
		ModelAndView mv = new ModelAndView("consultaEnfermeiros");
		Iterable<Enfermeiros> enfermeiros = enfermeirosRepository.findAll();
		mv.addObject("enfermeiros", enfermeiros);
		return mv;
	}
	

}
