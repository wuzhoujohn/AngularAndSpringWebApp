package com.johnwu.bookstorebackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import com.johnwu.bookstorebackend.service.UserSecurityService;

/*tell spring that this is a configuration bean, and enable websecurity*/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	//let spring to inject Environment bean into this class
	@Autowired
	private Environment env;
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	//return a passwordEncoder to crypt your password
	private BCryptPasswordEncoder passwordEncoder(){
		return SecurityUtility.passwordEncoder();
	}
	
	//define couple of pathes that are publicly available
	private static final String[] PUBLIC_MATCHERS = {
			"/css/**",
			"/js/**",
			"/image/**",
			"/book/**",
			"/user/**"
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//for any urls that match the PUBLIC_MATCHERS, we are gonna permit them to do the request
		//other than these urls, we need to authenticate them
		http.csrf().disable().cors().disable().httpBasic().and().authorizeRequests()
		.antMatchers(PUBLIC_MATCHERS).permitAll().anyRequest().authenticated();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		//let the service know the encoder method
		auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public HttpSessionStrategy httpSessionStrategy(){
		return new HeaderHttpSessionStrategy();
	}
}
