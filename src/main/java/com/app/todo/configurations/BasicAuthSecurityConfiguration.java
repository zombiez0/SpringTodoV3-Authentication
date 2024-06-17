package com.app.todo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class BasicAuthSecurityConfiguration {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery("select email, password, enabled from users where email=?")
                .authoritiesByUsernameQuery("SELECT email, authority FROM authorities WHERE email = ?");
        ;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated())
                .formLogin(login -> login.permitAll())
                .logout(logout -> logout.permitAll())
                .csrf(csrf -> csrf.disable())
        ;

        return http.build();
    }


//    @Bean
//    public UserDetailsService getUserDetailsService() {
//        UserDetails user = User.withUsername("demo")
//                .password("{noop}test")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withUsername("admin")
//                .password("{noop}test")
//                .roles("ADMINISTRATOR")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }

}
