package com.example.spring_hiber_jpa.repositories;

import com.example.spring_hiber_jpa.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Modifying(flushAutomatically = true)
    @Query("update Company c set c.companyName = :newName where c.id = :id")
    void renameCompany(@Param("id") Long id, @Param("newName") String newName);
}
