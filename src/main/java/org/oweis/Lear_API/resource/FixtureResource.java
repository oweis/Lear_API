package org.oweis.Lear_API.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.oweis.Lear_API.model.Fixture;
import org.oweis.Lear_API.model.Wire;
import org.oweis.Lear_API.service.FixtureService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Path("/fixtures")
@Produces(MediaType.APPLICATION_JSON)
public class FixtureResource {
	private FixtureService fixtureService = new FixtureService();
	
	@GET
	public List<Fixture> getAllFixtures(){
		return fixtureService.getAllFixtures();
	}

	@GET
	@Path("/search/idFamily/{idFamily}")
	public List<Fixture> getAllFixturesByIdFamily(@PathParam("idFamily") int idFamily){
	return fixtureService.getAllFixturesByIdFamily(idFamily);
	}

	@GET
	@Path("/search/hard/idFamily/{idFamily}/idPartNumber/{idPartNumber}")
	public List<Fixture> getHardAllFixturesByIdPartNumber(@PathParam("idFamily") int idFamily,@PathParam("idPartNumber") int idPartNumber){
		return  fixtureService.getHardAllFixturesByIdPartNumber(idFamily,idPartNumber);
	}
	

	@GET
	@Path("/search/idPartNumber/{idPartNumber}")
	public List<Fixture> getAllFixturesByIdPartNumber(@PathParam("idPartNumber") int idPartNumber){
		return fixtureService.getAllFixturesByIdPartNumber(idPartNumber);
	}	
	

	@GET
	@Path("/search/idFixture/{idFixture}")
	public Fixture getFixture(@PathParam("idFixture") int idFixture){
	return fixtureService.getFixture(idFixture);
	}
	
	@GET
	@Path("/search/idFamily/{idFamily}/nameFixture/{nameFixture}")
	public Fixture getFixtureByNameFixture(@PathParam("idFamily") int idFamily,@PathParam("nameFixture") String nameFixture){
	return fixtureService.getFixtureByNameFixture(idFamily,nameFixture);
	}
	
	@POST
	public Fixture addFixture(Fixture fixture){
		return fixtureService.addFixture(fixture);
	}
	
	@DELETE
	public void removeAllFixtures(){
	 fixtureService.removeAllFixtures();
	}
	
	@DELETE
	@Path("/search/idFamily/{idFamily}")
	public void removeAllFixturesByIdFamily(@PathParam("idFamily") int idFamily){
	 fixtureService.removeAllFixturesByIdFamily(idFamily);
	}

	@DELETE 
	@Path("/delete/idFixture/{idFixture}")
	public void removeFixture(@PathParam("idFixture") int idFixture){
		 fixtureService.removeFixture(idFixture);
	}

	@DELETE 
	@Path("/delete/idFamily/{idFamily}/nameFixture/{nameFixture}")
	public void removeFixture(@PathParam("idFamily") int idFamily,@PathParam("nameFixture") String nameFixture){
		 fixtureService.removeFixture(idFamily,nameFixture);
	}
	
	
}