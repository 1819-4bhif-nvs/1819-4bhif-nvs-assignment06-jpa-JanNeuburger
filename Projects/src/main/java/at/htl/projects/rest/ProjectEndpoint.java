package at.htl.projects.rest;

import at.htl.projects.model.Project;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

@Stateless
@Path("projects")
public class ProjectEndpoint extends AbstractEndpoint<Project>{
    public ProjectEndpoint(){
        super(Project.class);
    }
}