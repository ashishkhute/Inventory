package com.project.IMS.service;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.IMS.entity.Item;
import com.project.IMS.entity.Purchase;
import com.project.IMS.repository.PurchaseRepository;

@Service
public class PurchaseService {
	
@Autowired
	private PurchaseRepository purchaseRepository;
	
@Autowired
private ItemService itemService;
	
public Purchase placePurchase(Purchase purchase)
	{
		Item item=itemService.getItemById(purchase.getItemCode());
		
		
		//@TODO: validation required for check the available quantity it greater than order quantity
		
		try {
			item.setAvailableQuantity(item.getAvailableQuantity()+ purchase.getQuantity());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		itemService.updateItem(item);
		return purchaseRepository.save(purchase);
	}
	
	
	 public Map<String,Long> getNameCode()
	 {
		  return itemService.getAllItems().stream().collect(Collectors.toMap(value->value.getItemName(), value->value.getItemCode()));
	 }
	 
	

}
