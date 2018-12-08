package at.htl.projects.rest;

import at.htl.projects.model.Project;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("projects")
public class ProjectEndpoint{
    @PersistenceContext
    EntityManager em;

    @GET
    @Path("{id}")
    public Response getProject(@PathParam("id") long id){
        TypedQuery<Project> query = em.createNamedQuery("Project.findById", Project.class);
        query.setParameter("Id",id);
        Project p = query.getSingleResult();
        if(p != null){
            return Response.ok().entity(p).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("delete/{id}")
    public Response deleteProject(@PathParam("id") long id){
        TypedQuery<Project> query = em.createNamedQuery("Person.findById", Project.class);
        query.setParameter("Id",id);
        Project p = query.getSingleResult();
        if(p != null){
            em.remove(p);
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(Project p){
        em.persist(p);
        return Response.ok().entity(p).build();
    }
}