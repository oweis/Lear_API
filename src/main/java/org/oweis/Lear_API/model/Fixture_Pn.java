package org.oweis.Lear_API.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fixture_Pn {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String fixtureName;
	private String voieName;

	public Fixture_Pn() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFixtureName() {
		return fixtureName;
	}

	public void setFixtureName(String fixtureName) {
		this.fixtureName = fixtureName;
	}

	public String getVoieName() {
		return voieName;
	}

	public void setVoieName(String voieName) {
		this.voieName = voieName;
	}

	public Fixture_Pn(int id, String fixtureName, String voieName) {
		super();
		this.id = id;
		this.fixtureName = fixtureName;
		this.voieName = voieName;
	}

	
}
