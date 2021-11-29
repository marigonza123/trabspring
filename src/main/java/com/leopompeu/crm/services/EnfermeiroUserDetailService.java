package com.leopompeu.crm.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.leopompeu.crm.model.Enfermeiros;
import com.leopompeu.crm.repository.EnfermeirosRepository;
import com.leopompeu.crm.security.EnfermeiroDetails;

@Service
public class EnfermeiroUserDetailService implements UserDetailsService{

	@Autowired
	EnfermeirosRepository er;
	
	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		Optional<Enfermeiros> enfermeiros = er.findByUser(user);
		
		enfermeiros.orElseThrow(() -> new UsernameNotFoundException("Usuario" + user + "não existente")); 
		
		return enfermeiros.map(EnfermeiroDetails::new).get();
	}

}
