package com.itsone.igm.auth;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**/*");
		web.ignoring().antMatchers("/favicon.ico", "/resources/**", "/error");
		web.ignoring().antMatchers("/**/*.html");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers("/", "/home/**", "/common/**", "/upload/**", "/igm/d/**", "/igm/u/**", "/igm/cm/**", "/igm/as/**", "/igm/gi/**").permitAll()
				.anyRequest().authenticated()
			.and()
			.httpBasic();
	}
	
}
