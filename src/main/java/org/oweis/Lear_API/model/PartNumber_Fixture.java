package org.oweis.Lear_API.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PartNumber_Fixture {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		int id;
		int idPartNumber;
		int idFixture;
		
	public PartNumber_Fixture(){
		
	}

	public PartNumber_Fixture(int idPartNumber,int idFixture) {
			this.idPartNumber = idPartNumber;
			this.idFixture = idFixture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPartNumber() {
		return idPartNumber;
	}

	public void setIdPartNumber(int idPartNumber) {
		this.idPartNumber = idPartNumber;
	}

	public int getIdFixture() {
		return idFixture;
	}

	public void setIdFixture(int idFixture) {
		this.idFixture = idFixture;
	}

}
