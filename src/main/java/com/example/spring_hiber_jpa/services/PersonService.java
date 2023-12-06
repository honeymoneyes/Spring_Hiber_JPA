package com.example.spring_hiber_jpa.services;

import com.example.spring_hiber_jpa.entities.Person;
import com.example.spring_hiber_jpa.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    @Transactional
    public void save(Person person) {
        personRepository.save(person);
    }
}
