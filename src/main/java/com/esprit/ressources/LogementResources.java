package com.esprit.ressources;

import java.util.ArrayList;
import java.util.List;



import com.esprit.busniss.LogementBusiness;
import com.esprit.entities.Logement;
import com.esprit.entities.RendezVous;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("logement")

public class LogementResources {
LogementBusiness LB=new LogementBusiness();
@GET
@Path("getAll")

@Produces(MediaType.APPLICATION_JSON)
	public Response GetAll()
	{

		if(LB.getLogements()!=null)
			return Response.status(Response.Status.OK).entity(LB.getLogements()).build();

		else

			return Response.status(Response.Status.NOT_FOUND).entity("liste vide" ).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRvdId(@PathParam(value="id") int id){
		Logement r = LB.getlogementVousById(id);
		return Response.status(Response.Status.OK).entity(r).header("Access-Control-Allow-Origin","*").build();
	}
	
	
	
	
	
	
	
	
	

	
}
