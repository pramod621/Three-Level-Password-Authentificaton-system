package com.example.ThreeLevelPassAuthSystem;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan(basePackages ={"com.example.ThreeLevelPassAuthSystem.*"})
public class MvcConfiguration{
	
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
	    InternalResourceViewResolver resolver= new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/");
	    resolver.setSuffix(".jsp");
	    return resolver;
	}
	/*
	 * @Bean public ViewResolver getViewResolver() { InternalResourceViewResolver
	 * resolver = new InternalResourceViewResolver();
	 * resolver.setPrefix("/WEB-INF/"); resolver.setSuffix(".jsp"); return resolver;
	 * }
	 */
	/*
	 * public void configureDefaultServletHandling( DefaultServletHandlerConfigurer
	 * configurer) { configurer.enable(); }
	 */
}
