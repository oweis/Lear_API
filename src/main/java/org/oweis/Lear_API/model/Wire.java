package org.oweis.Lear_API.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Wire {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int idFamily;
	private int idPartNumber;
	private String nameWire;
	private String color;
	private String connector_A;
	private String pin_A;
	private String color_A;
	private String splice_A;
	private String connector_B;
	private String pin_B;
	private String color_B;
	private String splice_B;

	public Wire() {
		// TODO Auto-generated constructor stub
	}
	
		public Wire(int id,int idFamily,int idPartNumber, String nameWire, String color, String connector_A,
			String pin_A, String color_A,String splice_A, String connector_B, String pin_B,
			String color_B,String splice_B) {
		this.id = id;
		this.idFamily = idFamily;
		this.idPartNumber = idPartNumber;
		this.nameWire = nameWire;
		this.color = color;
		this.connector_A = connector_A;
		this.pin_A = pin_A;
		this.color_A = color_A;
		this.splice_A = splice_A;
		this.connector_B = connector_B;
		this.pin_B = pin_B;
		this.color_B = color_B;
		this.splice_B = splice_B;
		}

	public int getIdFamily() {
		return idFamily;
	}

	public void setIdFamily(int idFamily) {
		this.idFamily = idFamily;
	}

	public String getSplice_A() {
		return splice_A;
	}

	public void setSplice_A(String splice_A) {
		this.splice_A = splice_A;
	}

	public String getSplice_B() {
		return splice_B;
	}

	public void setSplice_B(String splice_B) {
		this.splice_B = splice_B;
	}

	public int getIdPartNumber() {
		return idPartNumber;
	}

	public void setIdPartNumber(int idPartNumber) {
		this.idPartNumber = idPartNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameWire() {
		return nameWire;
	}

	public void setNameWire(String nameWire) {
		this.nameWire = nameWire;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getConnector_A() {
		return connector_A;
	}

	public void setConnector_A(String connector_A) {
		this.connector_A = connector_A;
	}

	public String getPin_A() {
		return pin_A;
	}

	public void setPin_A(String pin_A) {
		this.pin_A = pin_A;
	}

	public String getColor_A() {
		return color_A;
	}

	public void setColor_A(String color_A) {
		this.color_A = color_A;
	}

	public String getConnector_B() {
		return connector_B;
	}

	public void setConnector_B(String connector_B) {
		this.connector_B = connector_B;
	}

	public String getPin_B() {
		return pin_B;
	}

	public void setPin_B(String pin_B) {
		this.pin_B = pin_B;
	}

	public String getColor_B() {
		return color_B;
	}

	public void setColor_B(String color_B) {
		this.color_B = color_B;
	}

}
