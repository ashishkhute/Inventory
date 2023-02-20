package com.project.IMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.IMS.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
