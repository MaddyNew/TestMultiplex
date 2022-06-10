package com.lti.training.apigateway;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("SecurityConfigAPI");
		// in memory authentication for handling users
		
		
		auth.inMemoryAuthentication()
			.withUser("MAdmin").password("{noop}qwerty").roles("ADMIN")
			 .and()
			.withUser("MAdmin_2").password("{noop}asdfgh").roles("ADMIN")
			 .and()
			.withUser("MAdmin_3").password("{noop}zxcvbn").roles("ADMIN");
	}
	
	// core logic constraint
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors() 
		.and()
			.csrf().disable()
			.authorizeRequests() 
				
				.antMatchers("/micro-user/api/user/login**").hasRole("ADMIN")
				.antMatchers("/micro-multiplex/api/multiplex/register").hasRole("ADMIN")
				.antMatchers("/micro-multiplex/api/multiplex/delete**").hasRole("ADMIN")
				.antMatchers("/micro-multiplex/api/multiplex/update**").hasRole("ADMIN")
				.antMatchers("/micro-multiplex/api/multiplex/addScreen**").hasRole("ADMIN")
				.antMatchers("/micro-multiplex/api/multiplex/addAllotment**").hasRole("ADMIN")
			
				.antMatchers("/micro-movie/api/movie/addMovie").hasRole("ADMIN")
				.antMatchers("/micro-movie/api/movie/delete**").hasRole("ADMIN")
				.antMatchers("/micro-movie/api/movie/update**").hasRole("ADMIN")
			.and()
				.httpBasic(); 
		
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
}
