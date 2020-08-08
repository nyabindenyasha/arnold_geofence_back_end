package com.minimum.contrroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minimum.local.CowParameters;
import com.minimum.local.Sms;

@RestController
@CrossOrigin
@RequestMapping("/sms")
public class SmsController {

	public static boolean smsAwaitingToBeSent = false;
	public static Sms smsToBeSent;
	
	public static boolean smsAwaitingToBeSent2 = false;
	public static Sms smsToBeSent2;

	@GetMapping("/sms1")
	public Sms sendToAndroid1() {
		System.out.println("get 1 P");
		System.out.println(smsToBeSent);
		System.out.println("xx");
		if (smsAwaitingToBeSent && smsToBeSent != null) {
			Sms sms = new Sms();
			sms.setReceiverNumber(smsToBeSent.getReceiverNumber());
			sms.setSmsBody(smsToBeSent.getSmsBody());
			smsAwaitingToBeSent = false;
			smsToBeSent = null;
			return sms;
		} 
		else if(smsAwaitingToBeSent2 && smsToBeSent2 != null) {
			Sms sms = new Sms();
			sms.setReceiverNumber(smsToBeSent2.getReceiverNumber());
			sms.setSmsBody(smsToBeSent2.getSmsBody());
			smsAwaitingToBeSent2 = false;
			smsToBeSent2 = null;
			return sms;
		} 
		else return null;
	}

	static String setSMSs(CowParameters cowParameters) {
		smsToBeSent = new Sms("263774337030",
				"Current location is: https://maps.google.com/?q=" + cowParameters.getLat() + ","
						+ cowParameters.getLng() + ". Heart rate is " + cowParameters.getHeartrate()
						+ " bpm and temperature is " + cowParameters.getTemp() + " degrees celcius");
		
		if(cowParameters.getTemp() < 35 || cowParameters.getTemp() > 40) {
			smsToBeSent2 = new Sms("263774337030", "Expect diseases like anthrax"); 
		}
		
		smsAwaitingToBeSent = true;
		smsAwaitingToBeSent2 = true;
		return "Y";
	}

	
	static String setSMSsInterrupt(String smsBody) {
		smsToBeSent = new Sms("263774337030", smsBody);
		smsAwaitingToBeSent = true;
		return "Y";
	}
	
}






