package com.example.resource;

import com.example.entity.Funcionario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/funcionarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FuncionarioResource {

    @GET
    public List<Funcionario> list() {
        return Funcionario.listAll();
    }

    @GET
    @Path("{id}")
    public Funcionario get(@PathParam("id") Long id) {
        return Funcionario.findById(id);
    }

    @POST
    public Response create(Funcionario obj) {
        obj.persist();
        return Response.status(Response.Status.CREATED).entity(obj).build();
    }

    @PUT
    @Path("{id}")
    public Funcionario update(@PathParam("id") Long id, Funcionario updated) {
        Funcionario existing = Funcionario.findById(id);
        if (existing == null) throw new NotFoundException();
        // simple copy - adjust fields as needed
        existing.persist();
        return existing;
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        Funcionario.deleteById(id);
    }
}
