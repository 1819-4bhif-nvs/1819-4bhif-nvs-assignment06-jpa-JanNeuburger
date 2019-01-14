package at.htl.projects.rest;

import at.htl.projects.model.Teacher;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

@Stateless
@Path("teachers")
public class TeacherEndpoint extends AbstractEndpoint<Teacher>{

    public TeacherEndpoint(){
        super(Teacher.class);
    }
}