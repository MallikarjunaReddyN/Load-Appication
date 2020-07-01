package com.malli.springhibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loadinfo")
public class LoadInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="loadid")
	private int id;
	
	@Column(name="loadname")
	private String loadname;
	
	@Column(name="no_packs")
	private int packs;
	
	@Column(name="load_cost")
	private long loadCost;
	
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

	public String getLoadname() {
		return loadname;
	}

	public void setLoadname(String loadname) {
		this.loadname = loadname;
	}

	public int getPacks() {
		return packs;
	}

	public void setPacks(int packs) {
		this.packs = packs;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getLoadCost() {
		return loadCost;
	}

	public void setLoadCost(long loadCost) {
		this.loadCost = loadCost;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
