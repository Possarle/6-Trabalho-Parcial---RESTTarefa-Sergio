package com.example.resource;

import com.example.entity.Cliente;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @GET
    public List<Cliente> list() {
        return Cliente.listAll();
    }

    @GET
    @Path("{id}")
    public Cliente get(@PathParam("id") Long id) {
        return Cliente.findById(id);
    }

    @POST
    public Response create(Cliente obj) {
        obj.persist();
        return Response.status(Response.Status.CREATED).entity(obj).build();
    }

    @PUT
    @Path("{id}")
    public Cliente update(@PathParam("id") Long id, Cliente updated) {
        Cliente existing = Cliente.findById(id);
        if (existing == null) throw new NotFoundException();
        // simple copy - adjust fields as needed
        existing.persist();
        return existing;
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        Cliente.deleteById(id);
    }
}
