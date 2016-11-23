package org.oweis.Lear_API.resource;

import java.util.List;

import org.oweis.Lear_API.model.Splice;
import org.oweis.Lear_API.service.SpliceService;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/splices")
//@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SpliceResource {
	private SpliceService spliceService = new SpliceService();
	
	@GET
	public List<Splice> getAllSplice(){
		return spliceService.getAllSplice();
	}
	
	@GET
	@Path("/search/idFamily/{idFamily}")
	public List<Splice> getAllSpliceByIdFamily(@PathParam("idFamily") int idFamily){
		return spliceService.getAllSpliceByIdFamily(idFamily);
	}

	@GET
	@Path("/search/idFamily/{idFamily}/idCable/{idCable}")
	public List<Splice> getAllSplicesByIdCable(@PathParam("idFamily") int idFamily,@PathParam("idCable") int idCable){
		return  spliceService.getAllSplicesByIdCable(idFamily,idCable);
	}
	
	@GET
	@Path("/search/idFamily/{idFamily}/nameSplice/{nameSplice}")
	public Splice getSpliceByNameSplice(@PathParam("idFamily") int idFamily,@PathParam("nameSplice") String nameSplice){
	return spliceService.getSpliceByNameSplice(idFamily,nameSplice);
	}
	
	@GET
	@Path("/search/idSplice/{idSplice}")
	public Splice getSplice(@PathParam("idSplice") int idSplice){
	return spliceService.getSplice(idSplice);
	}
	
	@POST
	public Splice addSplice(Splice splice){
		return spliceService.addSplice(splice);
	}
	
	@PUT 
	@Path("/{spliceName}")
	public Splice updateSplice(@PathParam("spliceName") String spliceName,Splice splice){
	//	splice.setSpliceName(spliceName);
		return spliceService.updateSplice(splice);
	}
	
	@DELETE 
	@Path("/delete")
	public void removeAllSplices(){
		 spliceService.removeAllSplices();
	}
	
	@DELETE 
	@Path("/delete/idFamily/{idFamily}")
	public void removeAllSplicesByIdFamily(@PathParam("idFamily") int idFamily){
		 spliceService.removeAllSplicesByIdFamily(idFamily);
	}
	
	@DELETE 
	public void removeSplice(Splice splice){
		 spliceService.removeSplice(splice);
	}
	
	@DELETE 
	@Path("/delete/idSplice/{idSplice}")
	public void removeSplice(@PathParam("idSplice") int idSplice){
		 spliceService.removeSplice(idSplice);
	}
	

	@DELETE
	@Path("/delete/idFamily/{idFamily}/nameSplice/{nameSplice}")
	public void removeSplice(@PathParam("idFamily") int idFamily,@PathParam("nameSplice") String nameSplice){
		 spliceService.removeSplice(idFamily,nameSplice);
	}
}