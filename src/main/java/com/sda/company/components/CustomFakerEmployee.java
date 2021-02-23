package com.sda.company.components;

import com.github.javafaker.Faker;
import com.sda.company.models.Company;
import com.sda.company.models.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//component - anotarea care ne modifica clasa intr-un component , @ComponentScan il gaseste - se va adauga in AppCOnfig
// este injectata prin constructor si folosita in metodele noastre api

public class CustomFakerEmployee {


    public List<Employee> createDummyCompanyList() {
        Faker faker = new Faker();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            Employee employee = new Employee();
            employee.setFirstName(faker.name().firstName());
            employee.setLastName(faker.name().lastName());
            employee.setAddress(faker.address().fullAddress());
            employee.setPhoneNumber(faker.phoneNumber().cellPhone());
            employee.setPersonalNumericCode(faker.number().randomNumber(11, true));
            employee.setEmail(faker.bothify("?????##gmail.com"));
//            company.setEmail(faker.internet().emailAddress());

            employees.add(employee);
        }
        return employees;
    }
}
