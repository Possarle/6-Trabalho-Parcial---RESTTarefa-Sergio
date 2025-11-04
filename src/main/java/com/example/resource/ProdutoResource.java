package com.example.resource;

import com.example.entity.Produto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    public List<Produto> list() {
        return Produto.listAll();
    }

    @GET
    @Path("{id}")
    public Produto get(@PathParam("id") Long id) {
        return Produto.findById(id);
    }

    @POST
    public Response create(Produto obj) {
        obj.persist();
        return Response.status(Response.Status.CREATED).entity(obj).build();
    }

    @PUT
    @Path("{id}")
    public Produto update(@PathParam("id") Long id, Produto updated) {
        Produto existing = Produto.findById(id);
        if (existing == null) throw new NotFoundException();
        // simple copy - adjust fields as needed
        existing.persist();
        return existing;
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        Produto.deleteById(id);
    }
}
