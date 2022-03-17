package com.example.springboot.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Insrance {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@NotNull
	private String name;
	@NotNull
	private String address;
	@NotNull
	private double amount;
	@NotNull
	private String  mobile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Insrance(int id, @NotNull String name, @NotNull String address, @NotNull double amount,
			@NotNull String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.amount = amount;
		this.mobile = mobile;
	}
	public Insrance() {
		super();
	}
	
	
		@Override
	public String toString() {
		return "Insrance [id=" + id + ", name=" + name + ", address=" + address + ", amount=" + amount + ", mobile="
				+ mobile + "]";
	}
	

}
