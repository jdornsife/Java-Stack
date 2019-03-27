package com.jennifer.dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jennifer.dojos.models.Dojo;
import com.jennifer.dojos.repositories.DojoRepo;

@Service
public class DojoService {
	private final DojoRepo dr;
	
	
	public DojoService(DojoRepo dr) {
		this.dr = dr;
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dr.save(dojo);
	}
	
	public List<Dojo> findAllDojos(){
		return dr.findAll();
	}
	public Dojo findDojo(Long dojoId) {
		Optional<Dojo> optionalDojo = dr.findById(dojoId);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
			return null;
		}
	}
}
