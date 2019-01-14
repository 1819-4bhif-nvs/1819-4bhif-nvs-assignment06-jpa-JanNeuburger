package at.htl.projects.rest;

import at.htl.projects.model.Student;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

@Stateless
@Path("students")
public class StudentEndpoint extends AbstractEndpoint<Student>{

    public StudentEndpoint(){
        super(Student.class);
    }
}