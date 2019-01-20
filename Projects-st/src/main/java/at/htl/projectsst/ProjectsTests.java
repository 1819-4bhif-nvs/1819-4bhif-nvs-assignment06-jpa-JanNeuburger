package at.htl.projectsst;

import org.junit.Before;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class ProjectsTests {

    private Client client;
    private WebTarget tut;

    @Before
    public void initClient(){
        this.client = ClientBuilder.newClient();
        this.tut = client.target("http://localhost:8080/projects/api");
    }

    @Test
    public void t01_setup(){
        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add()
    }
}
