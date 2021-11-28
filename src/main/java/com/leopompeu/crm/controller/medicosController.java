package com.leopompeu.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.leopompeu.crm.model.Medicos;
import com.leopompeu.crm.repository.MedicosRepository;

//Controlador dos Médicos
@Controller
public class medicosController {
	
	//Declarando Repositório
	@Autowired
	private MedicosRepository medicoRepository;

	//Chamada da página "cadastra medico"
	@RequestMapping(value="/cadastraMedico", method=RequestMethod.GET)
	public String form(){
		return "/cadastraMedico";
	}
	
	//Aplicando os valores de cadastro no banco de dados
	@RequestMapping(value="/cadastraMedico", method=RequestMethod.POST)
	public String form(Medicos medicos){
		
		medicoRepository.save(medicos);
		return "redirect:/consultaMedicos";
	}
	
	//Model And View dos Médicos
	@RequestMapping("/consultaMedicos")
	public ModelAndView listaMedicos() {
		ModelAndView mv = new ModelAndView("consultaMedicos");
		Iterable<Medicos> medicos = medicoRepository.findAll();
		mv.addObject("medicos", medicos);
		return mv;
	}

}
