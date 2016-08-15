package org.oweis.Lear_ClientAPI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.oweis.Lear_ClientAPI.model.*;

public class RestAPIClientDesktop {
	
	Family family;
	PartNumber partNumber;
	Fixture fixture;
	Pin pin;
	Wire wire;
	Splice splice;
	
	Client client = ClientBuilder.newClient();
	WebTarget baseTarget = client.target("http://localhost:8080/Lear_API/webapi/");
	WebTarget entityTarget = baseTarget.path("{entityName}");
	WebTarget functionTarget = entityTarget.path("{functionName}");
	WebTarget attributTarget = functionTarget.path("{attributName}");
	WebTarget valueTarget = attributTarget.path("{attributValue}");
	WebTarget attributTarget2 = valueTarget.path("{attributName2}");
	WebTarget valueTarget2 = attributTarget2.path("{attributValue2}");
	
	public RestAPIClientDesktop() {
		
	}
	
	public Family getFamily(String namePassByUser){
		family = valueTarget.
				resolveTemplate("entityName","familys").
				resolveTemplate("functionName", "search").
				resolveTemplate("attributName", "namePassByUser").
				resolveTemplate("attributValue",namePassByUser).
				request(MediaType.APPLICATION_JSON).
				get(Family.class);
	
		return family;
	}
	
	public Boolean isNamePassByUserExist(String namePassByUser){
		int resultat = -1;
		resultat = getFamily(namePassByUser).getId();
		if(resultat == -1) return false;
		else return true;
		}
	
	public Family getFamily(int id){
		family = valueTarget.
				resolveTemplate("entityName","familys").
				resolveTemplate("functionName","search").
				resolveTemplate("attributName","idFamily").
				resolveTemplate("attributValue",id).
				request(MediaType.APPLICATION_JSON).
				get(Family.class);
		return family;
	}
	
	public PartNumber getPartNumber(int idFamily,String nameUsedInLear){
		partNumber = valueTarget2.
				resolveTemplate("entityName","partnumbers").
				resolveTemplate("functionName", "search").
				resolveTemplate("attributName", "idFamily").
				resolveTemplate("attributValue",idFamily).
				resolveTemplate("attributName2","nameUsedInLear").
				resolveTemplate("attributValue2",nameUsedInLear).
				request(MediaType.APPLICATION_JSON).
				get(PartNumber.class);
	
		return partNumber;
	}
	
	public Fixture getFixture(int idFamily,String nameFixture){
		fixture = valueTarget2.
				resolveTemplate("entityName","fixtures").
				resolveTemplate("functionName", "search").
				resolveTemplate("attributName", "idFamily").
				resolveTemplate("attributValue",idFamily).
				resolveTemplate("attributName2","nameFixture").
				resolveTemplate("attributValue2",nameFixture).
				request(MediaType.APPLICATION_JSON).
				get(Fixture.class);
	
		return fixture;
	}
	
	public Response addFamily(Family newFamily){
		return  entityTarget.resolveTemplate("entityName","familys").request().post(Entity.json(newFamily));
	}
	
	public Response addPartNumber(PartNumber newPartNumber){
		return	entityTarget.resolveTemplate("entityName","partnumbers").request().post(Entity.json(newPartNumber));
	}
	
	public Response addWire(Wire newWire){
		return	entityTarget.resolveTemplate("entityName","wires").request().post(Entity.json(newWire));
	}

	public Response addSplice(Splice newSplice){
		return	entityTarget.resolveTemplate("entityName","splices").request().post(Entity.json(newSplice));
	}

	public Response addFixture(Fixture newFixture){
		return	entityTarget.resolveTemplate("entityName","fixtures").request().post(Entity.json(newFixture));
	}
	
	public Response addPin(Pin newPin){
		return	entityTarget.resolveTemplate("entityName","pins").request().post(Entity.json(newPin));
	}


}

