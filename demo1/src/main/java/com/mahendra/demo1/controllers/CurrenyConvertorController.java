package com.mahendra.demo1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mahendra.demo1.models.Currency;

@Controller
@RequestMapping("/convert")
public class CurrenyConvertorController {

	@GetMapping()
	public String convertToUSD(@RequestParam("amount") float amount, Model model) {
		Currency currency = new Currency(amount / 71.0F ,"USD");
		model.addAttribute("amt_usd",currency.toString());
		return "result";
	}
}
