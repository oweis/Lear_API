package org.oweis.Lear_API.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class PartNumber {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int idFamily;
	private String nameUsedInLear;
	private String nameUsedInClient;
	private String level;
	private String date;
	private String extra;
	private Date date_creation = new Date();
	
	
	public PartNumber() {
	
	}
	
	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public PartNumber(int id,int idFamily, String nameUsedInLear, String nameUsedInClient,
			String level, String date, String extra) {
		
		this.id = id;
		this.idFamily = idFamily;
		this.nameUsedInLear = nameUsedInLear;
		this.nameUsedInClient = nameUsedInClient;
		this.level = level;
		this.date = date;
		this.extra = extra;
			}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNameUsedInLear() {
		return nameUsedInLear;
	}


	public void setNameUsedInLear(String nameUsedInLear) {
		this.nameUsedInLear = nameUsedInLear;
	}


	public String getNameUsedInClient() {
		return nameUsedInClient;
	}


	public void setNameUsedInClient(String nameUsedInClient) {
		this.nameUsedInClient = nameUsedInClient;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getExtra() {
		return extra;
	}


	public void setExtra(String extra) {
		this.extra = extra;
	}

	public int getIdFamily() {
		return idFamily;
	}

	public void setIdFamily(int idFamily) {
		this.idFamily = idFamily;
	}
}