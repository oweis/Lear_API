package org.oweis.Lear_ClientAPI.model;

import javax.ws.rs.core.Response;

public interface BaliseState {

	void getValuesForBalise(String attribut,String value);
	public void showValues();
	Response saveBalise();

}
