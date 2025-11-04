package com.example.resource;

import com.example.entity.Fabricante;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/fabricantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FabricanteResource {

    @GET
    public List<Fabricante> list() {
        return Fabricante.listAll();
    }

    @GET
    @Path("{id}")
    public Fabricante get(@PathParam("id") Long id) {
        return Fabricante.findById(id);
    }

    @POST
    public Response create(Fabricante obj) {
        obj.persist();
        return Response.status(Response.Status.CREATED).entity(obj).build();
    }

    @PUT
    @Path("{id}")
    public Fabricante update(@PathParam("id") Long id, Fabricante updated) {
        Fabricante existing = Fabricante.findById(id);
        if (existing == null) throw new NotFoundException();
        // simple copy - adjust fields as needed
        existing.persist();
        return existing;
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        Fabricante.deleteById(id);
    }
}
