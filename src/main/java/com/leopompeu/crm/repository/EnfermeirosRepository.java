package com.leopompeu.crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leopompeu.crm.model.Enfermeiros;

//Repositorios dos enfermeiros
@Repository
public interface EnfermeirosRepository extends JpaRepository<Enfermeiros, String> {
	
	Optional<Enfermeiros> findByUser(String user);
}
