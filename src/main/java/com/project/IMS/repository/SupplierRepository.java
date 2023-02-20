package com.project.IMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.IMS.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long>{

}
