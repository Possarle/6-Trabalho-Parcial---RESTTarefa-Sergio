package com.example.resource;

import com.example.entity.Venda;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/vendas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VendaResource {

    @GET
    public List<Venda> list() {
        return Venda.listAll();
    }

    @GET
    @Path("{id}")
    public Venda get(@PathParam("id") Long id) {
        return Venda.findById(id);
    }

    @POST
    public Response create(Venda obj) {
        obj.persist();
        return Response.status(Response.Status.CREATED).entity(obj).build();
    }

    @PUT
    @Path("{id}")
    public Venda update(@PathParam("id") Long id, Venda updated) {
        Venda existing = Venda.findById(id);
        if (existing == null) throw new NotFoundException();
        // simple copy - adjust fields as needed
        existing.persist();
        return existing;
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        Venda.deleteById(id);
    }
}
