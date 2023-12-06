package com.example.spring_hiber_jpa;

import com.example.spring_hiber_jpa.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringHiberJpaApplication implements CommandLineRunner {
    private final CompanyService companyService;

    public static void main(String[] args) {
        SpringApplication.run(SpringHiberJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var company = companyService.getPersonWithCompaniesAndRename(1L);
        System.out.println(company);
    }
}
