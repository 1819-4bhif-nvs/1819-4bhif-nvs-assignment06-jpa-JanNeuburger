package at.htl.projects.rest;

import at.htl.projects.model.Person;
import at.htl.projects.model.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("students")
public class StudentEndpoint{
    @PersistenceContext
    EntityManager em;

    @GET
    @Path("{id}")
    public Response getStudent(@PathParam("id") long id){
        TypedQuery<Person> query = em.createNamedQuery("Person.findById", Person.class);
        query.setParameter("Id",id);
        Student s = (Student)query.getSingleResult();
        if(s != null){
            return Response.ok().entity(s).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("delete/{id}")
    public Response deleteStudent(@PathParam("id") long id){
        TypedQuery<Person> query = em.createNamedQuery("Person.findById", Person.class);
        query.setParameter("Id",id);
        Student s = (Student)query.getSingleResult();
        if(s != null){
            em.remove(s);
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(Student s){
        em.persist(s);
        return Response.ok().entity(s).build();
    }
}