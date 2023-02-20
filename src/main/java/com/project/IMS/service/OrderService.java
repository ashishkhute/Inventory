package com.project.IMS.service;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.IMS.entity.Item;
import com.project.IMS.entity.Order;
import com.project.IMS.repository.OrderRepository;

@Service
public class OrderService {
	
    @Autowired
	private OrderRepository orderRepository;
	
    @Autowired
    private ItemService itemService;
	
	public Order placeOrder(Order order)
	{
		Item item=itemService.getItemById(order.getItemCode());
		
		
		//@TODO: validation required for check the available quantity it greater than order quantity
		
		try {
			if(item.getAvailableQuantity()>=order.getQuantity())
			{
			item.setAvailableQuantity(item.getAvailableQuantity()-order.getQuantity());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		itemService.updateItem(item);
		return orderRepository.save(order);
	}
	
	
	 public Map<String,Long> getNameAndCode()
	 {
		  return itemService.getAllItems().stream().collect(Collectors.toMap(value->value.getItemName(), value->value.getItemCode()));
	 }
	 
	

}
