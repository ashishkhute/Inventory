package com.project.IMS.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.project.IMS.entity.Purchase;
import com.project.IMS.service.ItemService;
import com.project.IMS.service.PurchaseService;

@Controller
public class PurchaseController {
    @Autowired
	private PurchaseService purchaseService;
    
    @Autowired
    private ItemService itemService;
	
	@PostMapping("/purchase")
	public String placePurchase(@ModelAttribute Purchase purchase)
	{ 
		
		purchaseService.placePurchase(purchase);
	return "purchase_item";
	}
	
	@GetMapping("/newpurchase")
	public String newOrder(Model model) {
		model.addAttribute("purchase",new Purchase());
		model.addAttribute("items",itemService.getAllItems());
		return "purchase";
	}
	
	@GetMapping("/purchase/new")
	public String createPurchase(Model model)
	{
		model.addAttribute("purchase",new Purchase());
		Map<String,Long> map=purchaseService.getNameCode();
		model.addAttribute("map",map);
		return "create_purchase";
	}
	
	
}
