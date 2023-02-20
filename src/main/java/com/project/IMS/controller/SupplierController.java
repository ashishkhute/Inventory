package com.project.IMS.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.IMS.entity.Supplier;
import com.project.IMS.service.SupplierService;

@RestController

public class SupplierController {
   
    @Autowired
	private SupplierService supplierService;
	
	@GetMapping("/Supplier")
   public List<Supplier>getSupplier()
   {
	 return this.supplierService.getSupplier();  
   }
	
	@GetMapping("/Supplier/{supplierId}")
	public Supplier getSupplier(@PathVariable String supplierId) 
	{
		return this.supplierService.getSupplier(Long.parseLong(supplierId));
	}
	
	@PostMapping("/Supplier")
	public Supplier addSupplier(@RequestBody Supplier supplier)
	{
		return this.supplierService.addSupplier(supplier);
	}
	
	@PutMapping("/Supplier")
	public Supplier updateSupplier(@RequestBody Supplier supplier) 
	{
		return this.supplierService.updateSupplier(supplier);
	}
	
	@DeleteMapping("/Supplier/{supplierId}")
	public ResponseEntity<HttpStatus> deleteSupplier(@PathVariable String supplierId)
	{
		try {
			this.supplierService.deleteSupplier(Long.parseLong(supplierId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    }
