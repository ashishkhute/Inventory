package com.project.IMS.service;

import java.util.List;

import com.project.IMS.entity.Supplier;

public interface SupplierService {
	    
		public List<Supplier>getSupplier();
		
		public Supplier getSupplier(long supplierId);
		
		public Supplier addSupplier(Supplier supplier);

		public Supplier updateSupplier(Supplier supplier);

		public void deleteSupplier(long supplierId);

		}

	


