package com.minimum.contrroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minimum.local.ActionResult;
import com.minimum.model.TestTable;
import com.minimum.service.TestTableService;

import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin
@RequestMapping("/nyasha")
public class TestTableController {

	@Autowired
	TestTableService testTableService;
	
	@ApiOperation(value = "", response = Iterable.class)
	@PostMapping()
	public ResponseEntity<ActionResult> save(@Valid @RequestBody TestTable testTable) {
		ActionResult result = new ActionResult(); 
		try {
			testTableService.save(testTable);
			result.setMessage("Success");
			return ResponseEntity.ok().body(result);
		}catch(Exception exception) {
			result.setMessage(exception.getMessage());
			return new ResponseEntity<ActionResult>(result, HttpStatus.BAD_GATEWAY);
		}
	}
		
	@GetMapping("/querry")
	public ResponseEntity<ActionResult> saveQuery(@RequestParam("testValue") String testValue) {
		System.out.println(testValue);
		ActionResult result = new ActionResult(); 
		try {
			TestTable testTable = new TestTable();
			testTable.setTestValue(testValue);
			testTableService.save(testTable);
			result.setMessage("Success");
			return ResponseEntity.ok().body(result);
		}catch(Exception exception) {
			result.setMessage(exception.getMessage());
			return new ResponseEntity<ActionResult>(result, HttpStatus.BAD_GATEWAY);
		}
	}
	
	@ApiOperation(value = "", response = Iterable.class)
	@GetMapping()
	public ResponseEntity<Iterable<TestTable>> findAll(){
		try {
			return ResponseEntity.ok().body(testTableService.findAll());
		}catch(Exception exception) {
			Iterable<TestTable> iterable = null;
			return new ResponseEntity<Iterable<TestTable>>(iterable, HttpStatus.BAD_GATEWAY);
		}	
	}
	
	@ApiOperation(value = "", response = Iterable.class)
	@GetMapping("{id}")
	public ResponseEntity<TestTable> findOne(@PathVariable int id) {
		TestTable testTable = testTableService.findOne(id);
			if(testTable == null)return ResponseEntity.notFound().build();
			return ResponseEntity.ok().body(testTable);
	}
	
	@ApiOperation(value = "", response = Iterable.class)
	@PutMapping("/{id}")
	public ResponseEntity<ActionResult> update(@PathVariable int id,@Valid @RequestBody TestTable testTable) {
		ActionResult result = new ActionResult(); 
		try {
			if(id!=testTable.getId()) {
				result.setMessage("Invalid request.");
				return new ResponseEntity<ActionResult>(result, HttpStatus.BAD_REQUEST);	
			}
			testTableService.save(testTable);
			result.setMessage("Success");
			return ResponseEntity.ok().body(result);
		}catch(Exception exception) {
			result.setMessage(exception.getMessage());
			return new ResponseEntity<ActionResult>(result, HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping("/update/querry")
	public ResponseEntity<ActionResult> updateQuery( @RequestParam("testValueId") int testValueId, @RequestParam("testValue") String testValue) {
		System.out.println(testValue);
		ActionResult result = new ActionResult(); 
		try {
			TestTable testTable = testTableService.findOne(testValueId);
			if(testValueId!=testTable.getId()) {
				result.setMessage("Invalid request.");
				return new ResponseEntity<ActionResult>(result, HttpStatus.BAD_REQUEST);	
			}
			testTable.setTestValue(testValue);
			testTableService.save(testTable);
			result.setMessage("Success");
			return ResponseEntity.ok().body(result);
		}catch(Exception exception) {
			result.setMessage(exception.getMessage());
			return new ResponseEntity<ActionResult>(result, HttpStatus.BAD_GATEWAY);
		}
	}
	
	@ApiOperation(value = "", response = Iterable.class)
	@DeleteMapping("{id}")
	public ResponseEntity<ActionResult> delete(@PathVariable int id) {
		ActionResult result = new ActionResult(); 
		if(testTableService.findOne(id)!=null) { 
			testTableService.delete(id);
		result.setMessage("Success");
		return ResponseEntity.ok().body(result);
		}
		result.setMessage("Cannot delete the TestTable");
		return new  ResponseEntity<ActionResult>(result,HttpStatus.BAD_REQUEST);		
	}

}

