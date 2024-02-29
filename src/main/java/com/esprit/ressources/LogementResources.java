package com.esprit.ressources;

import java.util.ArrayList;
import java.util.List;



import com.esprit.busniss.LogementBusiness;
import com.esprit.entities.Logement;
import com.esprit.entities.RendezVous;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("logement")

public class LogementResources {
	private static LogementBusiness LB=new LogementBusiness();
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

	@Path("delete/{id}")
	@DELETE
	public  Response rmRDV(@PathParam(value = "id") int id){
		if(LB.deletelogement(id)){
			return Response.status(Response.Status.FOUND).entity("logement supprime").build();
		}
		return Response.status(Response.Status.NOT_FOUND).entity("echec not found").build();
	}

	@Path("update/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateRdv(@PathParam(value = "id") int id , Logement R){
		if(LB.updatelogement(id,R)){
			return Response.status(Response.Status.OK).entity("logement modifier").header("Access-Control-Allow-Origin","*").build();
		}
		return Response.status(Response.Status.NOT_FOUND).entity("error update").build();
	}

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ajoutlogement(Logement R){
		if(LB.addlogement(R)){
			return  Response.status(Response.Status.CREATED).entity("add success").header("Access-Control-Allow-Origin","*").build();
		}
		return Response.status(Response.Status.NOT_FOUND).entity(LB.getLogements()).build();
	}
	
	
	
	
	
	

	
}
