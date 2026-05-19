package com.example.demo.entiry;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercice_records")
public class Records {

	//主キー
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "evevt_id")
	private Integer eventId;

	private Date date;

	private Integer Time;

	@Column(name = "burn_calorie")
	private Integer burnCalorie;

	private String memo;

	//コンストラクタ
	public Records() {

	}

	//ゲッター
	public Integer getId() {
		return id;
	}

	public Integer getUserId() {
		return userId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public Date getDate() {
		return date;
	}

	public Integer getTime() {
		return Time;
	}

	public Integer getBurnCalorie() {
		return burnCalorie;
	}

	public String getMemo() {
		return memo;
	}

	//セッター
	public void setId(Integer id) {
		this.id = id;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setTime(Integer time) {
		Time = time;
	}

	public void setBurnCalorie(Integer burnCalorie) {
		this.burnCalorie = burnCalorie;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
