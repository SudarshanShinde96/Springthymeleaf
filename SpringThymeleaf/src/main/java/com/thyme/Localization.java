package com.thyme;

import java.util.Locale;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SuppressWarnings("deprecation")
@Configuration
public class Localization extends WebMvcConfigurerAdapter {
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver sessionLocaleResolver=new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lInterceptor=new LocaleChangeInterceptor();
		lInterceptor.setParamName("language");
		return lInterceptor;
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(localeChangeInterceptor());
	}

}
