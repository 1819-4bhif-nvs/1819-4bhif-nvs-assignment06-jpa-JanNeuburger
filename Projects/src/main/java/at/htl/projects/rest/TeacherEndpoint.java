package at.htl.projects.rest;

import at.htl.projects.model.Teacher;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("teachers")
public class TeacherEndpoint{
    @PersistenceContext
    EntityManager em;

    @GET
    @Path("{id}")
    public Response getTeacher(@PathParam("id") long id){
        TypedQuery<Teacher> query = em.createNamedQuery("Person.findById", Teacher.class);
        query.setParameter("Id",id);
        Teacher t = query.getSingleResult();
        if(t != null){
            return Response.ok().entity(t).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("delete/{id}")
    public Response deleteStudent(@PathParam("id") long id){
        TypedQuery<Teacher> query = em.createNamedQuery("Person.findById", Teacher.class);
        query.setParameter("Id",id);
        Teacher t = query.getSingleResult();
        if(t != null){
            em.remove(t);
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(Teacher t){
        em.persist(t);
        return Response.ok().entity(t).build();
    }
}