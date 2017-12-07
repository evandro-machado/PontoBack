package br.com.objective;

import org.springframework.boot.web.servlet.FilterRegistrationBean;

import br.com.objective.controller.TokenFilter;

//@SpringBootApplication
public class PontoApplication {
	int a = 8;
	
	
//	@Bean
	public FilterRegistrationBean filterJwt() {
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/pontos/*");
		long l = 154;
		System.out.println(l);
		return frb;
	}
	
	

	public PontoApplication() {
		System.out.println("rodou 3");
	}



	public static void main(String[] args) {
//		PontoApplication pa = new PontoApplication();
//		PontoApplication pa1 = new PontoApplication();
//		System.out.println(pa.a);
//		SpringApplication.run(PontoApplication.class, args);
	}
//	{
//		a =0;
//		System.out.println("Teste");
//		teste();
//	}

	static{
		System.out.println("rodou 1");
	}
	
	{
		System.out.println("rodou 2");
	}
	
	public void teste(){
		System.out.println("Alo");
	}
}
