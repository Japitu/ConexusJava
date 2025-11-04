package br.com.fiap.resource;

import br.com.fiap.bo.DificuldadeBO;
import br.com.fiap.to.DificuldadeTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/dificuldade")

public class DificuldadeResource {
    private DificuldadeBO dificuldadeBO = new DificuldadeBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<DificuldadeTO> resultado = dificuldadeBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save (@Valid DificuldadeTO dificuldade) {
        DificuldadeTO resultado = dificuldadeBO.save(dificuldade);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        DificuldadeTO resultado = dificuldadeBO.findById(id);
        Response.ResponseBuilder response = null;
        if(resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete (@PathParam("id") Long id) {
        Response.ResponseBuilder response = null;
        if (dificuldadeBO.delete(id)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid DificuldadeTO dificuldade, @PathParam("id") Long id) {
        dificuldade.setId(id);
        DificuldadeTO resultado = dificuldadeBO.update(dificuldade);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

}
