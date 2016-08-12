package org.oweis.Lear_API.resource;

import java.util.List;

import org.oweis.Lear_API.model.Fixture;
import org.oweis.Lear_API.service.FixtureService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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