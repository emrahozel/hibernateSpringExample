package com.envanter.context.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity(debug = false)
public class WebApplicationSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Security policy: login page.
		http.formLogin() //
				.loginPage("/public/login.xhtml") //
				.loginProcessingUrl("/public/login.xhtml") //
				.defaultSuccessUrl("/protected/home.xhtml") //
				.failureUrl("/public/login.xhtml?source=loginError") //
				.permitAll();

		// Security policy: public available paths
		http.authorizeRequests() //
				.antMatchers("/").permitAll() //
				.antMatchers("/index.html").permitAll() //
				.antMatchers("/public/**", "/resources/**", "/javax.faces.resource/**").permitAll();

		// Security policy: protecting all remaining paths.
		http.authorizeRequests() //
				.anyRequest().authenticated();

		// Logout handling.
		http.logout() //
				.logoutUrl("/logout") //
				.logoutSuccessUrl("/public/login.xhtml?source=logout") //
				.permitAll();

		/*
		 * Security policy: disabling CSRF protection. We must use it, but for
		 * now, I prefer to disable it to prevent more configuration overloads.
		 */
		http.csrf().disable();
		//sslli (https) gitmek icin
		//http.requiresChannel().anyRequest().requiresSecure();
	}

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication() //
		//		.withUser("admin") //
		//		.password("password") //
		//		.roles("ADMIN");
		auth
				.jdbcAuthentication()
				.dataSource(dataSource)
				.passwordEncoder(passwordEncoder())
				.usersByUsernameQuery("SELECT username, password, CASE enabled WHEN 1 THEN 'true' ELSE 'false' END 'enabled' \n" +
						"     FROM user \n" +
						"     WHERE username=?;")
				.authoritiesByUsernameQuery("SELECT u.username, r.role FROM user u, role r WHERE u.username = r.username AND u.username=?;");
	}
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

}