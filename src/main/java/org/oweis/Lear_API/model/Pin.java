package org.oweis.Lear_API.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int idFamily;
	private int idFixture;
	private String namePin;

	public Pin() {
	}

	public Pin(int id, int idFamily, int idFixture, String namePin) {
		this.id = id;
		this.idFamily = idFamily;
		this.idFixture = idFixture;
		this.namePin = namePin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdFamily() {
		return idFamily;
	}

	public void setIdFamily(int idFamily) {
		this.idFamily = idFamily;
	}
	
	public int getIdFixture() {
		return idFixture;
	}

	public void setIdFixture(int idFixture) {
		this.idFixture = idFixture;
	}

	public String getNamePin() {
		return namePin;
	}

	public void setNamePin(String namePin) {
		this.namePin = namePin;
	}

}
