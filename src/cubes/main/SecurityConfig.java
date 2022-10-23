package cubes.main;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource myDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//UserBuilder users = User.withDefaultPasswordEncoder();
		
		//auth.inMemoryAuthentication()
		//.withUser(users.username("marko").password("m123").roles("admin"))
		//.withUser(users.username("petar").password("p123").roles("employee"));
		
		auth.jdbcAuthentication().dataSource(myDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		//KOD ZA WEB APP PROJEKAT
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/administration/category-list").hasRole("admin")
		.antMatchers("/administration/category-form").hasRole("admin")
		.antMatchers("/administration/tag-form").hasRole("admin")
		.antMatchers("/administration/tag-list").hasRole("admin")
		.antMatchers("/administration/employee-list").hasRole("admin")
		.antMatchers("/administration/employee-form").hasRole("admin")
		.antMatchers("/administration/user-list").hasRole("admin")
		.antMatchers("/administration/**").hasAnyRole("employee,admin")
		.and().formLogin()
		.loginPage("/loginPage")
		.loginProcessingUrl("/authenticateTheUser").permitAll();
		//OSIM OVOG DELA
		//privremeno resenje za disable security
		//http.cors().and().csrf().disable();
		
		
		//KOD ZA REST API PROJEKAT
		//http.authorizeRequests()
		//.antMatchers(HttpMethod.POST, "/api/categories").hasAnyRole("employee, admin")
		//.antMatchers(HttpMethod.DELETE, "/api/categories/**").hasAnyRole("employee, admin")
		//.antMatchers(HttpMethod.PUT, "/api/categories").hasAnyRole("employee, admin")
		//.and().httpBasic()
		//.and().csrf().disable()
		//.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
