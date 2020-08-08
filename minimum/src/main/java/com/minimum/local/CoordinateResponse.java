package com.minimum.local;

public class CoordinateResponse {

	private double SourceLat;
	private double SourceLong;
	private double DestLat;
	private double DestLong;

	public double getSourceLat() {
		return SourceLat;
	}

	public void setSourceLat(double sourceLat) {
		SourceLat = sourceLat;
	}

	public double getSourceLong() {
		return SourceLong;
	}

	public void setSourceLong(double sourceLong) {
		SourceLong = sourceLong;
	}

	public double getDestLat() {
		return DestLat;
	}

	public void setDestLat(double destLat) {
		DestLat = destLat;
	}

	public double getDestLong() {
		return DestLong;
	}

	public void setDestLong(double destLong) {
		DestLong = destLong;
	}

}
