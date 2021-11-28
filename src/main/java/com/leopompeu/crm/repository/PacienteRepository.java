package com.leopompeu.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leopompeu.crm.model.Paciente;


//Repositório dos pacientes
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
