package com.airline.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.airline.service.AuditorAwareImpl;

@Configuration
@EnableJpaAuditing
public class AuditConfig {

	@Bean
	public AuditorAware<String> auditorAware(){
		return new AuditorAwareImpl();
	}
}
