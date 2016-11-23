package org.oweis.Lear_API.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Connector {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int idFamily;
	private String nameConnector;

	
	public Connector() {
		
	}
	
	public Connector(int id,int idFamily, String nameConnector) {
		this.id = id;
		this.idFamily = idFamily;
		this.nameConnector = nameConnector;
	
	}
	
	public int getIdFamily() {
		return idFamily;
	}

	public void setIdFamily(int idFamily) {
		this.idFamily = idFamily;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameConnector() {
		return nameConnector;
	}

	public void setNameConnector(String nameConnector) {
		this.nameConnector = nameConnector;
	}

}
