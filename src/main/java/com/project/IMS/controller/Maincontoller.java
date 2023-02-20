package com.project.IMS.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Maincontoller{
	
	
	@GetMapping("/order_sell")
	public String orderhome() {
		return "order_sell";
	}
	@GetMapping("/purchase_item")
	public String purchasehome() {
		return "purchase_item";
	}


	@GetMapping("/steel")
	public String steelhome() {
		return "steel";
	}
	@GetMapping("/pipes")
	public String pipeshome() {
		return "pipes";
	}
	@GetMapping("/floortiles")
	public String floortileshome() {
		return "floortiles";
	}
	@GetMapping("/concrete")
	public String concretehome() {
		return "concrete";
	}
	@GetMapping("/cable")
	public String cablehome() {
		return "cable";
	}
	@GetMapping("/bricksandblocks")
	public String bricksandblockshome() {
		return "bricksandblocks";
	}
	@GetMapping("/aboutus")
	public String aboutushome() {
		return "aboutus";
	}
	@GetMapping("/aboutProject")
	public String aboutProjecthome() {
		return "aboutProject";
	}
	@GetMapping("/contact")
	public String contacthome() {
		return "contact";
	}
	
}
