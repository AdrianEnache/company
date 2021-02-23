package com.sda.company.components;

import com.github.javafaker.Faker;
import com.sda.company.models.Company;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//component - anotarea care ne modifica clasa intr-un component , @ComponentScan il gaseste - se va adauga in AppCOnfig
// este injectata prin constructor si folosita in metodele noastre api
@Component
public class CustomFakerCompany {


    public List<Company> createDummyCompanyList() {
        Faker faker = new Faker();
        List<Company> companies = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            Company company = new Company();
            company.setName(faker.company().name());
            company.setAddress(faker.address().fullAddress());
            company.setPhoneNumber(faker.phoneNumber().phoneNumber());
            company.setRegistrationNumber(faker.number().randomNumber(11, true));
            company.setEmail(faker.bothify("?????##gmail.com"));
//            company.setEmail(faker.internet().emailAddress());

            companies.add(company);
        }
        return companies;
    }
}
