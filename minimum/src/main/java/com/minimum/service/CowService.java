package com.minimum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minimum.model.Cow;
import com.minimum.repo.CowRepo;

@Service
public class CowService {

	@Autowired
	private CowRepo cowRepository;

	public List<Cow> findAll() {
		return (List<Cow>) cowRepository.findAll();
	}

	public Cow findOne(int id) {
		return cowRepository.findOne(id);
	}

	public Cow saveR(Cow cow) {
		return cowRepository.save(cow);
	}

	public void save(Cow b) {
		cowRepository.save(b);
	}

	public void delete(int id) {
		cowRepository.delete(id);
	}

}
