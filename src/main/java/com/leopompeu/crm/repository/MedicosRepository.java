package com.leopompeu.crm.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leopompeu.crm.model.Medicos;

//Repositório dos médicos 
@Repository
public interface MedicosRepository extends CrudRepository<Medicos, String> {
	
}