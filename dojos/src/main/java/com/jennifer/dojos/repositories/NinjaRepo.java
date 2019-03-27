package com.jennifer.dojos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jennifer.dojos.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long> {

}
