package com.minimum.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cow")
public class Cow implements Serializable {
	
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	private double lat;
	
	private double lng;
	
	private double temp;
	
	private int heartrate;

	@JsonIgnore
	private LocalDateTime timestamp;
	
	@Transient
	private String timeLabel;
	
	@Transient
	private Date dateTime;

	public Cow() {
		super();
	}

	public Cow(int id, double lat, double lng, int temp, int heartrate, LocalDateTime timestamp, String timeLabel) {
		super();
		this.id = id;
		this.lat = lat;
		this.lng = lng;
		this.temp = temp;
		this.heartrate = heartrate;
		this.timestamp = timestamp;
		this.timeLabel = timeLabel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getTimeLabel() {
		return timeLabel;
	}

	public void setTimeLabel(String timeLabel) {
		this.timeLabel = timeLabel;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Cow [id=" + id + ", lat=" + lat + ", lng=" + lng + ", temp=" + temp + ", heartrate=" + heartrate
				+ ", timestamp=" + timestamp + ", timeLabel=" + timeLabel + "]";
	}

}
