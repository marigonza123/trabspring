package com.leopompeu.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;


//Declarando variaveis da classe Médicos
@Data
@Entity
public class Medicos {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@CPF
	@Column(unique=true)
	private String cpf;
	
	private String email;
	
	private String telefone;

	private boolean ativo = true;
	
	private String role = "MEDICO";

}