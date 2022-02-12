package gr.ds.restapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    private String credStringQuery = "select u.username, u.passcode, u.enabled from user u where u.username = ?";
    private String authStringQuery = "select u.username, r.name from user u join user_roles ur on u.user_id = ur.user_id join role r on ur.role_id = r.id where username = ?";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select u.username, u.passcode, u.enabled from user u where u.username = ?")
                .authoritiesByUsernameQuery("select u.username, r.name from user u join role r on u.user_id = r.user_id where username = ?");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.cors();

        httpSecurity.httpBasic().and().authorizeRequests()
                .antMatchers("/api/**").hasRole("ADMIN")
                .antMatchers("/citizen/**").hasRole("CITIZEN")
                .and()
                .exceptionHandling().accessDeniedPage("/welcome/error")
                .and().csrf().disable().headers().frameOptions().disable()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll().deleteCookies("JSESSIONID").invalidateHttpSession(true)/*.clearAuthentication(true).deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)*/;

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
        web.ignoring().antMatchers("/");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // Don't do this in production, use a proper list  of allowed origins
        config.setAllowedOriginPatterns(Collections.singletonList("http://localhost:3000"));
        config.setAllowedHeaders(Arrays.asList("Authorization","Origin", "Content-Type", "Accept", "X-Custom-Header", "X-Requested-With"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }


}
