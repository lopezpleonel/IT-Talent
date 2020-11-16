package com.it_talent.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it_talent.exceptions.ErrorMessages;
import com.it_talent.model.Phones;
import com.it_talent.model.User;
import com.it_talent.service.UserService;

@RestController
@RequestMapping("/usuarios")
public class UserController {
	
	@Autowired	
	private UserService userService;
	
	@RequestMapping(value = "/Listar", produces = "application/json", method = RequestMethod.GET )
	public List<User> listar() {
		return userService.getAllUsers();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/Agregar", produces = "application/json", method = RequestMethod.POST )
	public ResponseEntity insert(@Valid @RequestBody User user) {
		try {
			if(user.getPhoneList() != null) {
				for(Phones phones : user.getPhoneList()) {
					phones.setUser(user);
				}
			}
			userService.saveUser(user);
			
			return new ResponseEntity(user.toString(), HttpStatus.CREATED);
			
		} catch (DataIntegrityViolationException  e) {
			String message = "";
			if(e.getMessage().contains("PUBLIC.USER(EMAIL)")) {
				message= "Correo ya registrado";
			} else if (e.getMessage().contains("PUBLIC.PHONES(NUMBER)")) {
				message= "Número telefónico ya registrado";
			} else {
				message= e.getMessage();
			}
			ErrorMessages errorMessages = new ErrorMessages(message);
			return new ResponseEntity(errorMessages, HttpStatus.CONFLICT);
		}

	}

}
