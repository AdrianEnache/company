package com.sda.company.config;

import com.sda.company.components.CustomFakerCompany;
import com.sda.company.components.CustomFakerEmployee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//anotarea care ne scaneaza proiectul pentru a gasi clasele compoenent
//trebuie sa ii oferim un path catre folderul(pachetul) unde gaseste clasa
@ComponentScan("com.sda.company.components")
public class AppConfig {



    //custom @Bean care ne returneqza un CustomFaker - pt a popula baza noastra de date
    //obligatoriu trebuie adnotat @Bean pentru a se putea realiza injectarea mai departe printr-un constructor

    @Bean
    public CustomFakerEmployee customFakerEmployee(){
        return new CustomFakerEmployee();
    }


}
