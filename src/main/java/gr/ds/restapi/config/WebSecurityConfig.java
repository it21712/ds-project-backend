package gr.ds.restapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    private String credStringQuery = "select u.username, u.passcode, u.enabled from user u where u.username = ?";
    private String authStringQuery = "select u.username, r.name from user u join user_roles ur on u.user_id = ur.user_id join role r on ur.role_id = r.id where username = ?";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery(credStringQuery)
                .authoritiesByUsernameQuery(authStringQuery);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic().and().authorizeRequests()
                .antMatchers("/api").hasRole("ADMIN")
                .antMatchers("/citizen/**").hasRole("USER")
                .and()
                .exceptionHandling().accessDeniedPage("/welcome/error")
                .and().csrf().disable().headers().frameOptions().disable()
                .and().formLogin().permitAll().defaultSuccessUrl("/home")
                .and().logout().permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
        web.ignoring().antMatchers("/");
    }
}
