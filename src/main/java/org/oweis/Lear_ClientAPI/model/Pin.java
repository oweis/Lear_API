package org.oweis.Lear_ClientAPI.model;

import javax.ws.rs.core.Response;

import org.oweis.Lear_ClientAPI.RestAPIClientDesktop;

public class Pin implements BaliseState {

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


	@Override
	public void getValuesForBalise(String attribut, String value) {
		// TODO Auto-generated method stub
		if(attribut.equals("idFamily")) idFamily = Integer.parseInt(value);
		if(attribut.equals("idFixture")) idFixture = Integer.parseInt(value);
		else {
		namePin = value;
		RestAPIClientDesktop racd = new RestAPIClientDesktop();
		racd.addPin(this);
		}
	}


	@Override
	public Response saveBalise() {
	Response response = null;
	return response;
	}

	@Override
	public void showValues() {
		// TODO Auto-generated method stub
		
	}

}
