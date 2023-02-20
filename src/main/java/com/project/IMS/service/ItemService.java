package com.project.IMS.service;

import java.util.List;
import com.project.IMS.entity.Item;


public interface ItemService {
	
	List<Item> getAllItems();
	
	Item saveItem(Item item);
	
	Item getItemById(long itemcode);
	
	Item updateItem(Item item);

	void deleteItemById(long itemcode);

}
