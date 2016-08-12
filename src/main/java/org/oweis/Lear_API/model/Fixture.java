package org.oweis.Lear_API.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Fixture {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int idFamily;
	private String name;
	private String drawing;
	
	public Fixture() {
		
	}
	
	public Fixture(int id,int idFamily, String name, String drawing) {
		this.id = id;
		this.idFamily = idFamily;
		this.name = name;
		this.drawing = drawing;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDrawing() {
		return drawing;
	}

	public void setDrawing(String drawing) {
		this.drawing = drawing;
	}

}
