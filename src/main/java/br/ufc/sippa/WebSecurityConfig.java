package br.ufc.sippa;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	DataSource dataSource;
	
	//configuração de login
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("usuario@email.com").password("12345").roles("USER"); 
	  auth.jdbcAuthentication().dataSource(dataSource)
	  .usersByUsernameQuery(
			"select login,senha,1 from usuario where login=?")
	  .authoritiesByUsernameQuery(
			"select us.login, pap.nome from usuario as us,usuario_papel as pap where us.login=? and us.papel_id=pap.id");
	}	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	 http.csrf().disable();
	 http
		 .authorizeRequests()
		 .antMatchers("/materialize/**").permitAll()
		 .antMatchers("/**").authenticated()
         .and()
     .formLogin()
         .loginPage("/login").failureUrl("/login?error").defaultSuccessUrl("/home",true)
         .usernameParameter("username").passwordParameter("password")
         .permitAll()
         .and()
     .logout().logoutSuccessUrl("/login?logout");       
	}
	
}
