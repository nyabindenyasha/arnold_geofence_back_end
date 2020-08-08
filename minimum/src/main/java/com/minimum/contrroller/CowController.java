package com.minimum.contrroller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.minimum.local.ActionResult;
import com.minimum.local.CoordinateResponse;
import com.minimum.model.Cow;
import com.minimum.service.CowService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/cow")
public class CowController {

	@Autowired
	CowService cowService;

	@ApiOperation(value = "", response = Iterable.class)
	@PostMapping()
	public ResponseEntity<ActionResult> save(@Valid @RequestBody Cow cow) {
		ActionResult result = new ActionResult();
		try {
			cow.setTimestamp(LocalDateTime.now());
			cowService.save(cow);
			result.setMessage("Success");
			return ResponseEntity.ok().body(result);
		} catch (Exception exception) {
			result.setMessage(exception.getMessage());
			return new ResponseEntity<ActionResult>(result, HttpStatus.BAD_GATEWAY);
		}
	}

	@ApiOperation(value = "", response = Iterable.class)
	@GetMapping()
	public ResponseEntity<Iterable<Cow>> findAll() {
		try {
			List<Cow> cows = cowService.findAll();
			for (Cow x : cows) {
				x.setTimeLabel(x.getTimestamp().getHour() + ":" + x.getTimestamp().getMinute() + ":"
						+ x.getTimestamp().getSecond());
				x.setDateTime(convertToDateViaInstant(x.getTimestamp()));
			}
			return ResponseEntity.ok().body(cows);
		} catch (Exception exception) {
			Iterable<Cow> iterable = null;
			return new ResponseEntity<Iterable<Cow>>(iterable, HttpStatus.BAD_GATEWAY);
		}
	}

	@ApiOperation(value = "", response = Iterable.class)
	@GetMapping("getPath/{id}")
	public ResponseEntity<CoordinateResponse> findPath(@PathVariable int id) {
		try {
			List<Cow> cowsList = cowService.findAll();
			Cow source = cowsList.get(id - 2);
			Cow dest = cowsList.get(id - 1);
			CoordinateResponse coordinateResponse = new CoordinateResponse();
			coordinateResponse.setSourceLat(source.getLat());
			coordinateResponse.setSourceLong(source.getLng());
			coordinateResponse.setDestLat(dest.getLat());
			coordinateResponse.setDestLong(dest.getLng());
			return ResponseEntity.ok().body(coordinateResponse);
		} catch (Exception exception) {
			return new ResponseEntity<CoordinateResponse>(new CoordinateResponse(), HttpStatus.BAD_GATEWAY);
		}
	}

	@ApiOperation(value = "", response = Iterable.class)
	@GetMapping("{id}")
	public ResponseEntity<Cow> findOne(@PathVariable int id) {
		Cow cow = cowService.findOne(id);
		if (cow == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(cow);
	}

	@ApiOperation(value = "", response = Iterable.class)
	@PutMapping("/{id}")
	public ResponseEntity<ActionResult> update(@PathVariable int id, @Valid @RequestBody Cow cow) {
		ActionResult result = new ActionResult();
		try {
			if (id != cow.getId()) {
				result.setMessage("Invalid request.");
				return new ResponseEntity<ActionResult>(result, HttpStatus.BAD_REQUEST);
			}
			cowService.save(cow);
			result.setMessage("Success");
			return ResponseEntity.ok().body(result);
		} catch (Exception exception) {
			result.setMessage(exception.getMessage());
			return new ResponseEntity<ActionResult>(result, HttpStatus.BAD_GATEWAY);
		}
	}

	@ApiOperation(value = "", response = Iterable.class)
	@DeleteMapping("{id}")
	public ResponseEntity<ActionResult> delete(@PathVariable int id) {
		ActionResult result = new ActionResult();
		if (cowService.findOne(id) != null) {
			cowService.delete(id);
			result.setMessage("Success");
			return ResponseEntity.ok().body(result);
		}
		result.setMessage("Cannot delete the Cow");
		return new ResponseEntity<ActionResult>(result, HttpStatus.BAD_REQUEST);
	}
	
	private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
		return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
	}

}
