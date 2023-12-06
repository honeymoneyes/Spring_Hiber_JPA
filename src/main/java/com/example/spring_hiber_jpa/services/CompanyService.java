package com.example.spring_hiber_jpa.services;

import com.example.spring_hiber_jpa.entities.Company;
import com.example.spring_hiber_jpa.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final JpaContext jpaContext;
    private final CompanyRepository companyRepository;
    @Transactional
    public Company getPersonWithCompaniesAndRename(Long id) {
        var company = companyRepository.findById(id).orElseThrow();
        printCompanyWithPeople();
        renameCompany(id, "TOYOTA");
        return company;
    }
    @Transactional
    public void printCompanyWithPeople() {
        jpaContext.getEntityManagerByManagedType(Company.class)
                .createNamedQuery("company-with-people", Company.class)
                .getResultList().forEach(company -> {
                    System.out.println("----");
                    System.out.println(company.toString().toUpperCase(Locale.ROOT));
                    company.getUsers().forEach(person -> System.out.println(person.toString().toUpperCase(Locale.ROOT)));
                });
        System.out.println("----");
    }

    @Transactional
    public void renameCompany(Long id, String newName) {
        companyRepository.renameCompany(id, newName);
    }
}
