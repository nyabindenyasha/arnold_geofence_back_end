package com.minimum.local;

public class Sms {
	
	private String receiverNumber;
	private String smsBody;
	
	public Sms() {
	}
	
	public Sms(String receiverNumber, String smsBody) {
		super();
		this.receiverNumber = receiverNumber;
		this.smsBody = smsBody;
	}
	
	public String getReceiverNumber() {
		return receiverNumber;
	}
	public void setReceiverNumber(String receiverNumber) {
		this.receiverNumber = receiverNumber;
	}
	public String getSmsBody() {
		return smsBody;
	}
	public void setSmsBody(String smsBody) {
		this.smsBody = smsBody;
	}

	@Override
	public String toString() {
		return "Sms [receiverNumber=" + receiverNumber + ", smsBody=" + smsBody + "]";
	}
	
}
