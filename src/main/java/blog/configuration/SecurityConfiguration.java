package blog.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter 
{
	@Autowired
	DataSource dataSource;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
        http
        	.authorizeRequests()
        		.antMatchers(HttpMethod.GET, "/", "/users/register", "/css/styles.css", "/js/blog-scripts.js" ).permitAll()
                .antMatchers(HttpMethod.POST, "/users/register", "/users/login").permitAll()
                .and()
            .logout().permitAll();
    }
    
  /*  @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception 
    {
    	auth.
    	auth.jdbcAuthentication().dataSource(dataSource)
    	.usersByUsernameQuery("select * from users where username=?");
    } */

  /*  @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception 
    {
        auth.jdbcAuthentication().dataSource(dataSource).withUser(getUserQuery());
    }*/    
}