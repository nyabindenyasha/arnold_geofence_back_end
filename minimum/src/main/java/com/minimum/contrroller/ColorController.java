package com.minimum.contrroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ColorController {

	@GetMapping("/Color")
	public String getCowParametersFromUno(@RequestParam("color") String color) {
		System.out.println("the color is: " + color);
		return "Y";
	}

}
