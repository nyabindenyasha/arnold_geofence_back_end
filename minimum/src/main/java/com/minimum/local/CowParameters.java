package com.minimum.local;

public class CowParameters {

	private double lat;
	private double lng;
	private double temp;
	private int heartrate;

	public CowParameters() {
		super();
	}

	public CowParameters(double lat, double lng, double temp, int heartrate) {
		this.lat = lat;
		this.lng = lng;
		this.temp = temp;
		this.heartrate = heartrate;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public int getHeartrate() {
		return heartrate;
	}

	public void setHeartrate(int heartrate) {
		this.heartrate = heartrate;
	}

	@Override
	public String toString() {
		return "CowParameters [lat=" + lat + ", lng=" + lng + ", temp=" + temp + ", heartrate=" + heartrate + "]";
	}
}
