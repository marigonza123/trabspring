package com.leopompeu.crm.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;
import lombok.Getter;

//Declarando as variaveis da classe Paciente
@Data
@Getter
@Entity
public class Paciente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@CPF
	@Column(unique=true)
	private String cpf;
	
	private String peso;
	
	private String altura;
	
	private String nasc;
	
	private String telefone;
	
	private String email;
	
	@NotBlank
	private String UF;

}
