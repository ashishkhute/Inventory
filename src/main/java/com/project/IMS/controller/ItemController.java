package com.project.IMS.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.IMS.entity.Item;
import com.project.IMS.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	// handler method to handle list items and return model and view
	@GetMapping("/items")
	public String listItems(Model model) {
		model.addAttribute("item", itemService.getAllItems());
		return "items";
	}
	
	@GetMapping("/index")
	public String availableItems(Model model) {
		model.addAttribute("item", itemService.getAllItems());
		return "index";
	}
	
	@GetMapping("/items/new")
	public String createItemForm(Model model) {
		
		Item item = new Item();
		model.addAttribute("item", item);
		return "create_item";
		
	}
	
	@PostMapping("/items")
	public String saveItem(@ModelAttribute("item")@Valid Item item,BindingResult result) {
		if (result.hasErrors()) {
			return "create_item";
		}
		itemService.saveItem(item);
		return "redirect:/items";
	}
	
	@GetMapping("/items/edit/{itemCode}")
	public String editItemForm(@PathVariable Long itemCode, Model model) {
		model.addAttribute("item", itemService.getItemById(itemCode));
		return "edit_item";
	}

	@PostMapping("/items/{itemCode}")
	public String updateItem(@PathVariable Long itemCode,
			@ModelAttribute("item") Item item,
			Model model) throws Exception {
		
		// get item from database by id
		Item existingItem = itemService.getItemById(itemCode);
		existingItem.setItemCode(itemCode);
		existingItem.setItemName(item.getItemName());
		existingItem.setDescription(item.getDescription());
		existingItem.setAvailableQuantity(item.getAvailableQuantity());
		existingItem.setReorderLevel(item.getReorderLevel());
		existingItem.setPrice(item.getPrice());
		
		// save updated item object
		itemService.updateItem(existingItem);
		return "redirect:/items";		
	}
	
	// handler method to handle delete item request
	
	@GetMapping("/items/{itemCode}")
	public String deleteItem(@PathVariable Long itemCode) {
		itemService.deleteItemById(itemCode);
		return "redirect:/items";
	}
	
}
