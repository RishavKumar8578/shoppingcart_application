package com.jsp.shoppingcart_application.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long mobilenumber;
	private String addresss;
	private double totalprice;
	
	
	
	@OneToMany
	private List<Items> items;



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



	public long getMobilenumber() {
		return mobilenumber;
	}



	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}



	public String getAddresss() {
		return addresss;
	}



	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}



	public double getTotalprice() {
		return totalprice;
	}



	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}



	public List<Items> getItems() {
		return items;
	}



	public void setItems(List<Items> items) {
		this.items = items;
	}



	

}
