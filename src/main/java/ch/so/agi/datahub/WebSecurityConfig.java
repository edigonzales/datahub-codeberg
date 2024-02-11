package ch.so.agi.datahub;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class WebSecurityConfig {
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        http.authorizeHttpRequests((authorize) -> authorize
//                .requestMatchers("/ping").permitAll()
//                );

        http
        .securityMatcher("/api/jobs/**") // Sonst wird der Filter auf alle Requests angewendet.
        .csrf(csrf -> csrf.disable()) // Für non-browser i.O. (?)
        .authorizeHttpRequests((authorize) -> authorize
                //.requestMatchers("/ping").permitAll()
                .requestMatchers("/api/jobs/**").authenticated()
        )
        .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
        .httpBasic(Customizer.withDefaults());
        //.formLogin(Customizer.withDefaults());

      return http.build();
    }
    
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
        .ldapAuthentication()
            .userDnPatterns("uid={0},ou=people") // Specifies the patterns used to search for user Distinguished Names (DNs) during authentication.
            .groupSearchBase("ou=people") // Specifies the base DN (Distinguished Name) under which the search for LDAP groups will be performed.
            .contextSource()
                //.ldif("classpath:test-server.ldif")
                .root("dc=springframework,dc=org");
    }
}
