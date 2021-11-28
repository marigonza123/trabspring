package com.leopompeu.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.leopompeu.crm.model.Paciente;
import com.leopompeu.crm.repository.PacienteRepository;

//Controlador dos Pacientes
@Controller
public class pacienteController {
	
	//Declarando Repositório
	@Autowired
	private PacienteRepository pacienteRepository;

	//Chamada da página "cadastra paciente"
	@RequestMapping(value="/cadastraPaciente", method=RequestMethod.GET)
	public String form(){
		return "/cadastraPaciente";
	}
	
	//Aplicando os valores de cadastro no banco de dados
	@RequestMapping(value="/cadastraPaciente", method=RequestMethod.POST)
	public String form(Paciente paciente){
		
		pacienteRepository.save(paciente);
		return "redirect:/consultarDados";
	}
	
	//Model And View dos Pacientes
	@RequestMapping("/consultarDados")
	public ModelAndView listaPacientes() {
		ModelAndView mv = new ModelAndView("consultarDados");
		Iterable<Paciente> paciente = pacienteRepository.findAll();
		mv.addObject("paciente", paciente);
		return mv;
	}
	
	
}
