package com.it_talent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it_talent.model.Phones;
import com.it_talent.service.PhonesService;

@RestController
@RequestMapping("/telefonos")
public class PhonesController {
	
	@Autowired
	PhonesService phonesService;
	
	@RequestMapping(value = "/Listar", produces = "application/json", method = RequestMethod.GET )
	public List<Phones> listar() {
		return phonesService.getAllPhones();
	}
	
}
