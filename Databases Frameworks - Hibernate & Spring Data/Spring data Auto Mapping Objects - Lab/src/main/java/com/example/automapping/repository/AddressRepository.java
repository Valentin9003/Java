package com.example.automapping.repository;

import com.example.automapping.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Employee, Long> {


}
