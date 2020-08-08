package com.minimum.contrroller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TestController {


	@ApiOperation(value = "", response = Iterable.class)
	@PostMapping("/User")
	public ResponseEntity<ColorResponse> save(@Valid @RequestBody ColorUser request) {
		ColorResponse result = new ColorResponse();
		try {

			if (request.getUsername().equals("nyasha") && request.getPassword().equals("nyasha")) {
				result.setSuccessed(true);
				result.setMessage("Success");
			} else
				result.setSuccessed(false);
			return ResponseEntity.ok().body(result);
		} catch (Exception exception) {
			result.setMessage(exception.getMessage());
			return new ResponseEntity<ColorResponse>(result, HttpStatus.BAD_GATEWAY);
		}
	}

}

class ColorUser {

	private String username;
	private String password;

	public ColorUser() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

class ColorResponse {

	private boolean successed;
	private String message;

	public boolean isSuccessed() {
		return successed;
	}

	public void setSuccessed(boolean successed) {
		this.successed = successed;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
