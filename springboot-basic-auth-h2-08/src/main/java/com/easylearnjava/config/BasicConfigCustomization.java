package com.easylearnjava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BasicConfigCustomization extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder encoder =
			     PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.
			inMemoryAuthentication().
				withUser("ramya").
				password(encoder.encode("newsecret")).
				roles("USER").
				and().
				withUser("admin").
				password("admin").
				roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic().
		and().authorizeRequests().antMatchers("/h2-console/**","/customers/**").permitAll().
		and().csrf().ignoringAntMatchers("/h2-console/**","/customers/**");
		http.headers().frameOptions().disable().
		and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
     
    /* To allow Pre-flight [OPTIONS] request from browser */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}
