package com.minimum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minimum.repo.TestTableRepo;
import com.minimum.model.TestTable;


@Service
public class TestTableService {

	@Autowired
	private TestTableRepo testTableRepository;

	public List<TestTable> findAll() {
		return (List<TestTable>) testTableRepository.findAll();
	}

	public TestTable findOne(int id) {
		return testTableRepository.findOne(id);
	}

	public TestTable saveR(TestTable testTable) {
		return testTableRepository.save(testTable);
	}

	public void save(TestTable b) {
		testTableRepository.save(b);
	}

	public void delete(int id) {
		testTableRepository.delete(id);
	}

}
