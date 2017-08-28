package br.com.objective;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import br.com.objective.controller.TokenFilter;

@SpringBootApplication
public class PontoApplication {

	@Bean
	public FilterRegistrationBean filterJwt() {
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/pontos/*");

		return frb;
	}

	public static void main(String[] args) {
		SpringApplication.run(PontoApplication.class, args);
	}

}
