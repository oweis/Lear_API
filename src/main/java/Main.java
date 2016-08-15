import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.oweis.Lear_ClientAPI.model.Family;
import org.oweis.Lear_ClientAPI.model.Wire;


public class Main {

	Wire wire;
	List<Wire> wires;

	Client client = ClientBuilder.newClient();
	WebTarget baseTarget = client.target("http://localhost:8080/Lear_API/webapi/");
	WebTarget entityTarget = baseTarget.path("{entityName}");
	WebTarget functionTarget = entityTarget.path("{functionName}");
	WebTarget attributTarget = functionTarget.path("{attributName}");
	WebTarget valueTarget = attributTarget.path("{attributValue}");
	WebTarget attributTarget2 = valueTarget.path("{attributName2}");
	WebTarget valueTarget2 = attributTarget2.path("{attributValue2}");
	
	public List<Wire> getFamily(String namePassByUser){
		wires = entityTarget.
				resolveTemplate("entityName","wires").
				request(MediaType.APPLICATION_JSON).
				get(List<Wire>);
		
	
		return null;
	}
	
	public Main() {}
		public static void main(String[] arg){
		WireService wireService = new WireService();
		ArrayList<Wire> wires = null;
		wires = wireService.getAllWire();
		//wires = wireService.getAllWiresByIdFamily(1);
		for(Wire wire : wires) System.out.println(wire.getNameWire());
		}
	}
