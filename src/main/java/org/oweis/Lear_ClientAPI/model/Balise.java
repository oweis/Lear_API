package org.oweis.Lear_ClientAPI.model;

import javax.ws.rs.core.Response;

import org.oweis.Lear_ClientAPI.RestAPIClientDesktop;
import org.oweis.Lear_ClientAPI.Converter.ReadXmlFile2;

public class Balise {
	
	BaliseState isFamily;
	BaliseState isPartNumber;
	BaliseState isWire;
	BaliseState isFixture;
	BaliseState isPin;
	BaliseState isSplice;
	BaliseState noBalise;
	BaliseState baliseState;
	
	RestAPIClientDesktop racd = new RestAPIClientDesktop();

	public Balise(){
		isFamily = new Family();
		isPartNumber = new PartNumber();
		isWire = new Wire();
		isFixture = new Fixture();
		isPin = new Pin();
		isSplice = new Splice();
		noBalise = new NoBalise();
	}
	
	public void setBaliseState(BaliseState baliseState){
		this.baliseState = baliseState;
	}
		
	public BaliseState getBaliseState() {
		return baliseState;
	}
	
	public void check(String value){ 
		if(value.equals("HEADER")) this.setBaliseState(isFamily);
		else if(value.equals("PARTNUMBER"))  this.setBaliseState(isPartNumber);
		else if(value.equals("WIRE"))  this.setBaliseState(isWire);
		else if(value.equals("FIXTURE"))  this.setBaliseState(isFixture);
		else if(value.equals("SPLICE"))  this.setBaliseState(isSplice);
		else if(value.equals("PIN"))  this.setBaliseState(isPin);
		else this.setBaliseState(noBalise);
	}
	
	public void getValuesForBalise(String attribut,String value) {
		baliseState.getValuesForBalise(attribut,value);
	}

	public Response saveBalise(){
		return baliseState.saveBalise();
	}
	public void showValues(){
		baliseState.showValues();
	}
	
}
