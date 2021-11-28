package com.leopompeu.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.leopompeu.crm.repository.EnfermeirosRepository;

@EnableJpaRepositories(basePackageClasses = EnfermeirosRepository.class)
@SpringBootApplication
public class ProcessoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessoApiApplication.class, args);
	}

}
