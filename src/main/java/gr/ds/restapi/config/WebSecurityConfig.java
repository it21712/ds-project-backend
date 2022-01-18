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

    private final String credStringQuery = "select u1.username, u1.passcode, u1.enabled  from (select id, username, passcode, enabled from citizen union select id, username, passcode, enabled from civic_official union select id, username, passcode, enabled from vet union select id, username, passcode, enabled from admin ) as u1 join user_roles on u1.id = user_roles.user_id join role r on r.id=user_roles.role_id where username =?";
    private final String authStringQuery = "select u1.username, name from (select id, username from citizen union select id, username from civic_official union select id, username from vet union select id, username from admin ) as u1 join user_roles on u1.id = user_roles.user_id join role r on r.id=user_roles.role_id where u1.username= ?";

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
