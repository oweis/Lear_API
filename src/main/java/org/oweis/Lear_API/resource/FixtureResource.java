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
	public List<Fixture> getAllFixture(){
		return fixtureService.getAllFixture();
	}
	

	@GET
	@Path("/{fixtureName}")
	public Fixture getFixture(@PathParam("fixtureName") String fixtureName){
	return fixtureService.getFixture(fixtureName);
	}
	
	@POST
	public Fixture addFixture(Fixture fixture){
		return fixtureService.addFixture(fixture);
	}
	
	@PUT 
	@Path("/{fixtureName}")
	public Fixture updateFixture(@PathParam("fixtureName") String fixtureName,Fixture fixture){
	//	fixture.setFixtureName(fixtureName);
		return fixtureService.updateFixture(fixture);
	}
	
	@DELETE 
	@Path("/{fixtureName}")
	public void removeFixture(@PathParam("fixtureName") String fixtureName){
		 fixtureService.removeFixture(fixtureName);
	}

	}
	

