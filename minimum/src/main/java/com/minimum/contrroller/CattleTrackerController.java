package com.minimum.contrroller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minimum.local.ActionResult;
import com.minimum.local.CowParameters;
import com.minimum.model.Cow;
import com.minimum.service.CowService;

@RestController
@CrossOrigin
@RequestMapping("/cattle")
public class CattleTrackerController {

	@Autowired
	CowService cowService;

//	private boolean smsAwaitingToBeSent = false;
//	private Sms smsToBeSent;
	private CowParameters cowParameters;

//	@GetMapping("/sms")
//	public Sms sendToAndroid1() {
//		System.out.println("get 1 P");
//		System.out.println(smsToBeSent);
//		System.out.println("xx");
//		if (smsAwaitingToBeSent && smsToBeSent != null) {
//			Sms sms = new Sms();
//			sms.setReceiverNumber(smsToBeSent.getReceiverNumber());
//			sms.setSmsBody(smsToBeSent.getSmsBody());
//			smsAwaitingToBeSent = false;
//			smsToBeSent = null;
//			return sms;
//		} else
//			return null;
//	}

//	String setSMSs() {
//		smsToBeSent = new Sms("263774337030",
//				"Current location is: https://maps.google.com/?q=" + cowParameters.getLat() + ","
//						+ cowParameters.getLng() + ". Heart rate is " + cowParameters.getHeartrate()
//						+ " bpm and temperature is " + cowParameters.getTemp() + " degrees celcius");
//		smsAwaitingToBeSent = true;
//		return "Y";
//	}

	@GetMapping("/querry/cowParameters")
	public String getCowParametersFromUno(@RequestParam("lat") double lat, @RequestParam("lng") double lng,
			@RequestParam("temp") double temp, @RequestParam("heartrate") int heartrate) {
		cowParameters = new CowParameters(lat, lng, temp, heartrate);
		System.out.println(cowParameters);
		Cow cow = new Cow();
		cow.setLat(lat);
		cow.setLng(lng);
		cow.setTemp(temp);
		cow.setHeartrate(heartrate);
		cow.setTimestamp(LocalDateTime.now());
		cowService.save(cow);
		SmsController.setSMSs(cowParameters);
		return "Y";
	}

	@GetMapping("/cowParameters")
	public CowParameters getCowParameters() {
		System.out.println("Get CowParameters: ");
		return cowParameters;
	}

	@GetMapping("/cowOutOfRange")
	public ResponseEntity<ActionResult> cowOutOfRange() {
		ActionResult result = new ActionResult();
		System.out.println("cowOutOfRange: ");
//		String msg = "The cow is now out of range. Current location is: https://maps.google.com/?q=" + cowParameters.getLat()  +  ","	+ cowParameters.getLng();
		SmsController.setSMSsInterrupt("The cow is now out of range. Current location is: https://maps.google.com/?q="
				+ cowParameters.getLat() + "," + cowParameters.getLng());
		result.setMessage("Success");
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/chartdata")
	public void getChartdata() {

	}

}
