package com.jeduce.stcf.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jeduce.stcf.app.auth.handler.LoginSuccesHandler;
import com.jeduce.stcf.app.models.service.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private LoginSuccesHandler successHandler;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/test","/","/css/**","/js/**","/images/**","/listar/**").permitAll()
		//.antMatchers("/configuracion/**").hasAnyRole("USER")
		.anyRequest().authenticated()
		.and()
		.formLogin()
				.successHandler(successHandler)
				.loginPage("/login")
			.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");
	}

	@Autowired
	public void configurerGloal(AuthenticationManagerBuilder build) throws Exception
	{
		
		build.userDetailsService(userDetailsService)
		
		.passwordEncoder(passwordEncoder);
		
		//.usersByUsernameQuery("select VUSUARIO_NOM,VPASSWORD_COD,enabled from DOC_USUARIO where VUSUARIO_NOM=?")
		//.authoritiesByUsernameQuery("select u.VUSUARIO_NOM,a.authority from DOC_ROLE a inner join DOC_USUARIO u on (user_id=u.id) where u.VUSUARIO_NOM=?");
		
		//PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	      //  UserBuilder users = User.builder().passwordEncoder(encoder::encode);
	}
}
