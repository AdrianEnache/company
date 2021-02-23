package com.sda.company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
//@EnableWebSecurity - anotarea care ne specifica clasa ne configueaza securitatea
@EnableWebSecurity
public class SecutiryConfig extends WebSecurityConfigurerAdapter {

    //autentificare in memorie cu datele de user si parola -realizeaza partea de autentificare in memorie
    //pentru a rula metoda trebuie atribui la users roluri si parolele trebuie criptate
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("admin").roles("ADMIN","USER")
                .password(passwordEncoder().encode("1234"))
                .and().withUser("user").roles("USER")
                .password(passwordEncoder().encode("1234"));
    }
    //Authorization
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //acesta este setup ul pt nici un fel de securitate(permite orice)
        /*
        httpSecurity
                .authorizeRequests()//pentru orice request permit all si foloseste http basic(basic auth-user si pass)
                .anyRequest()
                .permitAll()
                .and()
                .httpBasic(); */


        //acest setup ne va permite sa securizam
        //todo de setat securitatea de reluat discutia cand revenim
        //todo de configurat in postman toate requesturile cu autentificare altfel nu o sa mearga o sa dea Forbidden
        //todo de oferit privilegii la admin sau user pentru Employee


        httpSecurity
                    .authorizeRequests(authorizeRequests ->
                            authorizeRequests
                    .antMatchers("/api/v1/company/*").hasRole("ADMIN")
                    .antMatchers("/api/v1/employee/*").hasAnyRole("ADMIN","USER")
                    .anyRequest().authenticated())
        .httpBasic();


        //by default blockeaza orice request facut de un browser web-aici dezactivam acesta securitate
        //cors - cross origin resources sharing
        //csrf - cross site request forgery
        //csrf - cors -impiedica comunicarea dintre micro serviciul de spring si oricare browser web
        httpSecurity
                .csrf()
                .disable()
                .cors()
                .disable();
    }
    //ne va crypta parola, sa ii atribuim anotarea @Bean
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
