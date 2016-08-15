package org.oweis.Lear_ClientAPI.model;

import javax.ws.rs.core.Response;

import org.oweis.Lear_ClientAPI.RestAPIClientDesktop;

public class Splice implements BaliseState {
	
	private int id;
	private int idFamily;
	private String nameSplice;
	
	public Splice() {

	}

	public Splice(int id,int idFamily, String nameSplice) {
		this.id = id;
		this.idFamily = idFamily;
		this.nameSplice = nameSplice;
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
	public String getNameSplice() {
		return nameSplice;
	}
	public void setNameSplice(String nameSplice) {
		this.nameSplice = nameSplice;
	}

	public void getValuesForBalise(String attribut,String value){
		if(attribut.equals("NAME")) nameSplice = value;
		if(attribut.equals("idFamily")) idFamily = Integer.parseInt(value);
		}

	public Response saveBalise() {
		RestAPIClientDesktop racd = new RestAPIClientDesktop();
		return racd.addSplice(this);
	}

	@Override
	public void showValues() {
		// TODO Auto-generated method stub
		
	};
	
}