package com.appmobilespring.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.appmobilespring.services.DBService;
import com.appmobilespring.services.email.EmailService;
import com.appmobilespring.services.email.MockEmailService;

@Configuration
@Profile("test")
// Essa classe inicia todos os recursos automaticamente para o teste
public class TestConfig {

	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}