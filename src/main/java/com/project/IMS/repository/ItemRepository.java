package com.project.IMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.IMS.entity.Item;

public interface ItemRepository extends JpaRepository< Item , Long >{


}
