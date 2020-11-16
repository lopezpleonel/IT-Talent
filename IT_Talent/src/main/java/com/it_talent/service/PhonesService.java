package com.it_talent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it_talent.dao.PhonesRepository;
import com.it_talent.model.Phones;

@Service
public class PhonesService {

	@Autowired
	PhonesRepository phonesRepository;
	
	public List<Phones> getAllPhones() {
		return (List<Phones>) this.phonesRepository.findAll();
	}
	
}
