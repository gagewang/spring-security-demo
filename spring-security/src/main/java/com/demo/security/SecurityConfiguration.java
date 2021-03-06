package com.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
         super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
    	try {
    		http
            .authorizeRequests()
                .antMatchers("/get","/","/login_page.html").permitAll()
                 .antMatchers("/admin/**").authenticated().and()
                 .formLogin().loginPage("/login").permitAll().and()
                 //.exceptionHandling().authenticationEntryPoint( new MacLoginUrlAuthenticationEntryPoint())
                ;
    	}catch (Exception e) {
    		System.out.println(e.getMessage());
		}
    	
    }

    @Override
	public void configure(WebSecurity web) throws Exception{
         super.configure(web);
    }
}
