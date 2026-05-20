package com.example.demo.entiry;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")

public class User {

	//主キー
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String password;

	private Integer age;

	private Integer gender;

	//コンストラクタ
	public User() {

	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	//ゲッター
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public Integer getAge() {
		return age;
	}

	public Integer getGender() {
		return gender;
	}

}