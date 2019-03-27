package com.jennifer.dojos.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jennifer.dojos.models.Ninja;
import com.jennifer.dojos.services.DojoService;
import com.jennifer.dojos.services.NinjaService;

@Controller
public class NinjasController {
	private final DojoService ds;
	private final NinjaService ns;
	
	public NinjasController(DojoService ds, NinjaService ns) {
		this.ds = ds;
		this.ns = ns;
	}
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		model.addAttribute("allDojos", ds.findAllDojos());
		return"/ninjas/new.jsp";
	}
	public NinjaService getNs() {
		return ns;
	}
	@PostMapping("/ninjas")
	public String create(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result) {
		if(result.hasErrors()){
			return "/ninjas/new.jsp";
		}else {
			Ninja createdNinja = ns.createNinja(ninja);
			return "redirect:/dojos/" + createdNinja.getDojo().getId();
		}
	}
}
