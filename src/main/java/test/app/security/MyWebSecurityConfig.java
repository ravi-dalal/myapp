package test.app.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("user")
		  .password("{noop}password")
		  .authorities("user")
		  .and()
		.withUser("admin")
		  .password("{noop}admin")
		  .authorities("user", "admin")
		  .and()
		.withUser("test")
		   .password("{noop}test")
		   .authorities("test");;
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http         
        .headers()
         .frameOptions().sameOrigin()
         .and()
           .authorizeRequests()
           .antMatchers("/error").authenticated()
           .antMatchers("/api/**").hasAuthority("admin")
           .antMatchers("/**").hasAnyAuthority("admin", "user")
           .and()
           .formLogin().permitAll()
           .and().logout().logoutSuccessUrl("/login");
    }

}
