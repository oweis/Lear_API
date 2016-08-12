	package org.oweis.Lear_API.resource;

import java.util.List;

import org.oweis.Lear_API.model.Fixture_Pn;
import org.oweis.Lear_API.service.Fixture_PnService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/fixture_Pns")
//@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_JSON)
public class Fixture_PnResource {
	private Fixture_PnService fixture_PnService = new Fixture_PnService();
	
	/*@GET 
	public Fixture_Pn getLastFixture_Pn(){
		return fixture_PnService.getLastFixture_Pn();
	}*/
	
	@GET
	public List<Fixture_Pn> getAllFixture_Pn(){
		return fixture_PnService.getAllFixture_Pn();
	}
	
	@POST
	public Fixture_Pn addFixture_Pn(Fixture_Pn fixture_Pn){
		return fixture_PnService.addFixture_Pn(fixture_Pn);
	}
	
	@GET
	@Path("/{fixture_PnName}")
	public Fixture_Pn getFixture_Pn(@PathParam("fixture_PnName") String fixture_PnName){
	return fixture_PnService.getFixture_Pn(fixture_PnName);
	}
	
	@PUT 
	@Path("/{fixture_PnName}")
	public Fixture_Pn updateFixture_Pn(@PathParam("fixture_PnName") String fixture_PnName,Fixture_Pn fixture_Pn){
	//	fixture_Pn.setFixture_PnName(fixture_PnName);
		return fixture_PnService.updateFixture_Pn(fixture_Pn);
	}
	
	@DELETE 
	@Path("/{fixture_PnName}")
	public void removeFixture_Pn(@PathParam("fixture_PnName") String fixture_PnName){
		 fixture_PnService.removeFixture_Pn(fixture_PnName);
	}

}
	