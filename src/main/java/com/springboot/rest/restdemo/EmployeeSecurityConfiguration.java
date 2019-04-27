package com.springboot.rest.restdemo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springboot.rest.restdemo.crypto.CryptoPasswordEncoder;

@Configuration
@EnableWebSecurity
/*@ComponentScan("com.springboot.rest.restdemo")*/
public class EmployeeSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	private EmployeeAuthenticationSuccessHandler successHandler;
	@Autowired
	AuthProvider authProvider;
	

	// Enable jdbc authentication
	/*@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}*/

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new CryptoPasswordEncoder();
	}
	
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
				.antMatchers("/getEmployees").hasAnyRole("USER", "ADMIN")
				.antMatchers("/addNewEmployee").hasAnyRole("ADMIN")
				.anyRequest().authenticated()
				.and().formLogin().successHandler(successHandler)
				.loginPage("/showlogin").permitAll()
				.and().logout().permitAll();
		http.csrf().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr)
    throws Exception {
		/*authenticationMgr.inMemoryAuthentication().withUser("admin").password("admin").authoristies("ROLE_USER").and()
	 		.withUser("javainuse").password("javainuse").authorities("ROLE_USER","ROLE_ADMIN");*/
		
		authenticationMgr.jdbcAuthentication().dataSource(dataSource)
        .authoritiesByUsernameQuery("select username, authority from authorities where USERNAME=?")
        .usersByUsernameQuery("select username, password, 1 as enabled  from users where USERNAME=?").passwordEncoder(passwordEncoder()); 
		
		/*authenticationMgr.authenticationProvider(authProvider);*/
		/*.jdbcAuthentication().dataSource(dataSource) 
        .authoritiesByUsernameQuery("select username, authority from authorities where USERNAME=?")
        .usersByUsernameQuery("select username, password, 1 as enabled  from users where USERNAME=?").passwordEncoder(passwordEncoder());*/
		
		
	 }

}