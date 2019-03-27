package com.jennifer.dojos.services;

import org.springframework.stereotype.Service;

import com.jennifer.dojos.models.Ninja;
import com.jennifer.dojos.repositories.NinjaRepo;

@Service
public class NinjaService {
	private final NinjaRepo nr;
	
	public NinjaService(NinjaRepo nr) {
		this.nr = nr;
	}
	
	public Ninja createNinja(Ninja ninja) {
		return nr.save(ninja);
	}
}
