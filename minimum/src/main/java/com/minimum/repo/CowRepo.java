package com.minimum.repo;

import org.springframework.data.repository.CrudRepository;

import com.minimum.model.Cow;

public interface CowRepo extends CrudRepository<Cow, Integer>{

}


