package com.leopompeu.crm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.inMemoryAuthentication()
        .withUser("admin").password("admin").authorities("ADMIN")
        .and()
        .withUser("medico").password("medicosenha").authorities("MEDICO");
        
	} 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable().authorizeRequests().antMatchers("/").access("hasAnyAuthority('ENFERMEIRO','MEDICO','ADMIN')")
	        .antMatchers("/cadastraMedico").access("hasAuthority('ADMIN')")
	        .antMatchers("/consultaMedicos").access("hasAuthority('ADMIN')")
	        .antMatchers("/consultaEnfermeiros").access("hasAnyAuthority('ADMIN','MEDICO')")
	        .antMatchers("/cadastraEnfermeiro").access("hasAnyAuthority('ADMIN','MEDICO')")
	        .antMatchers(HttpMethod.POST, "/cadastraEnfermeiro").permitAll()
	        .antMatchers(HttpMethod.POST, "/cadastraPaciente").permitAll()
	        .antMatchers(HttpMethod.POST, "/cadastraMedico").permitAll()
	        .and().formLogin().loginPage("/login").permitAll()
	        .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        .logoutSuccessUrl("/login").permitAll()
	        .and()
	        .httpBasic();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance(); }
}
