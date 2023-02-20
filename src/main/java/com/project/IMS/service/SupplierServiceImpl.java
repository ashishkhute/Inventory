package com.project.IMS.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.IMS.entity.Supplier;
import com.project.IMS.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	public List<Supplier> getSupplier() {
	
		return supplierRepository.findAll();
	}

	@Override
	public Supplier getSupplier(long supplierId) {
		Optional <Supplier> optional = supplierRepository.findById(supplierId);
		Supplier supplier = null;
		if(optional.isPresent()) {
			supplier = optional.get();
		}
		else {
			throw new RuntimeException("Supplier not found for id::"+supplierId);
		}
		return supplier;
	}

	@Override
	public Supplier addSupplier(Supplier supplier) {
		
		supplierRepository.save(supplier);
	    return supplier;
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		
		supplierRepository.save(supplier);
	    return supplier;
	}

	@Override
	public void deleteSupplier(long supplierId) {
		this.supplierRepository.deleteById(supplierId);
		
	}

}
