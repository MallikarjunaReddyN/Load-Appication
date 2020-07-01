package com.malli.springhibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paidpackinfo")
public class PaidPacksInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="personname")
	 private String personname;
	@Column(name="no_packs")
	 private int packs;
	@Column(name="paid_cost")
	 private int paidCost;
	@Column(name="username")
	private String username;
	@Column(name="date")
	private String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	public int getPacks() {
		return packs;
	}
	public void setPacks(int packs) {
		this.packs = packs;
	}
	public int getPaidCost() {
		return paidCost;
	}
	public void setPaidCost(int paidCost) {
		this.paidCost = paidCost;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
