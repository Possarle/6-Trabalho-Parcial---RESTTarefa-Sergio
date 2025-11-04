package com.example.resource;

import com.example.entity.ItemVenda;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/itensvenda")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemVendaResource {

    @GET
    public List<ItemVenda> list() {
        return ItemVenda.listAll();
    }

    @GET
    @Path("{id}")
    public ItemVenda get(@PathParam("id") Long id) {
        return ItemVenda.findById(id);
    }

    @POST
    public Response create(ItemVenda obj) {
        obj.persist();
        return Response.status(Response.Status.CREATED).entity(obj).build();
    }

    @PUT
    @Path("{id}")
    public ItemVenda update(@PathParam("id") Long id, ItemVenda updated) {
        ItemVenda existing = ItemVenda.findById(id);
        if (existing == null) throw new NotFoundException();
        // simple copy - adjust fields as needed
        existing.persist();
        return existing;
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        ItemVenda.deleteById(id);
    }
}
