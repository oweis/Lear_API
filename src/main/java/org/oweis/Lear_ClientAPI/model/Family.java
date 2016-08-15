package org.oweis.Lear_ClientAPI.model;

import java.util.Date;

import javax.ws.rs.core.Response;

import org.oweis.Lear_ClientAPI.RestAPIClientDesktop;

public class Family implements BaliseState{

	private int id;
	private String namePassByUser;
	private String nameUsedInLear;
	private String nameUsedInClient;
	private String date;
	private String client;
	private String extra;
	private Date date_creation = new Date();

	public Family(){}

	public Family(int id,String namePassByUser, String nameUsedInLear, String nameUsedInClient,
			String date, String client, String extra) {
		this.id = id;
		this.namePassByUser = namePassByUser;
		this.nameUsedInLear = nameUsedInLear;
		this.nameUsedInClient = nameUsedInClient;
		this.date = date;
		this.client = client;
		this.extra = extra;
	}

	public String getNamePassByUser() {
		return namePassByUser;
	}

	public void setNamePassByUser(String namePassByUser) {
		this.namePassByUser = namePassByUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameUsedInLear() {
		return nameUsedInLear;
	}

	public void setNameUsedInLear(String nameUsedInLear) {
		this.nameUsedInLear = nameUsedInLear;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public String getNameUsedInClient() {
		return nameUsedInClient;
	}

	public void setNameUsedInClient(String nameUsedInClient) {
		this.nameUsedInClient = nameUsedInClient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	
	public void getMyName() {
		// TODO Auto-generated method stub	
	}
	
	public void getValuesForBalise(String attribut,String value){
		if(attribut.equals("FAMILY")) nameUsedInLear = value;
		if(attribut.equals("CLIENTFAM")) nameUsedInClient = value;
		if(attribut.equals("DATE")) date = value;
		if(attribut.equals("CLIENT")) client = value;
		if(attribut.equals("EXTRA")) extra = value;
		if(attribut.equals("namePassByUser")) namePassByUser=value;
	}
	
	public void showValues(){
		System.out.println("INFOS FAMILY: ");
		System.out.println("NameUsedInLear : " + nameUsedInLear);
		System.out.println("NameUsedInClient : " + nameUsedInClient);
		System.out.println("Date : " + date);
		System.out.println("Client : " + client);
		System.out.println("Extra : " + extra);
		System.out.println("namePassByUser : " + namePassByUser);
	}
	
	public Response saveBalise() {
		RestAPIClientDesktop racd = new RestAPIClientDesktop();
		return  racd.addFamily(this);

	};
	
}