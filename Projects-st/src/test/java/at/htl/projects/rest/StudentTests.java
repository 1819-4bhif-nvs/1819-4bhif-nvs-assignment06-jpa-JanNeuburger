package at.htl.projects.rest;

import org.junit.Before;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StudentTests {

    private Client client;
    private WebTarget tut;

    @Before
    public void initClient() {
        this.client = ClientBuilder.newClient();
        this.tut = client.target("http://localhost:8080/Projects/api/students");
    }

    @Test
    public void getAll() {
        Response response = this.tut
                .request(MediaType.APPLICATION_JSON)
                .get();
        assertThat(response.getStatus(), is(200));
    }

    @Test
    public void get() {
        Response response = this.tut
                .path("10")
                .request(MediaType.APPLICATION_JSON)
                .get();
        assertThat(response.getStatus(), is(200));
        JsonObject payload = response.readEntity(JsonObject.class);
        assertThat(payload.getString("matNumber"), is("if5"));
    }

    @Test
    public void post() {
        JsonObject student = Json.createObjectBuilder()
                .add("firstName", "Florian")
                .add("lastName", "Schwarcz")
                .add("matNumber", "if150115")
                .build();
        Response response = this.tut
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(student));
        assertThat(response.getStatus(), is(200));
        JsonObject payload = response.readEntity(JsonObject.class);
        assertThat(payload.getString("matNumber"), is("if150115"));
    }

    @Test
    public void delete() {
        JsonObject student = Json.createObjectBuilder()
                .add("firstName", "Florian")
                .add("lastName", "Schwarcz")
                .add("matNumber", "if150115")
                .build();
        Response response = this.tut
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(student));
        assertThat(response.getStatus(), is(200));
        JsonObject payload = response.readEntity(JsonObject.class);
        response = this.tut
                .path("" + payload.getInt("id"))
                .request(MediaType.APPLICATION_JSON)
                .delete();
        assertThat(response.getStatus(), is(204));
        response = this.tut
                .path("" + payload.getInt("id"))
                .request(MediaType.APPLICATION_JSON)
                .get();
        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void put() {
        JsonObject student = Json.createObjectBuilder()
                .add("firstName", "Florian")
                .add("lastName", "Schwarcz")
                .add("matNumber", "if150115")
                .build();
        Response response = this.tut
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(student));
        assertThat(response.getStatus(), is(200));
        JsonObject payload = response.readEntity(JsonObject.class);
        JsonObject updateStudent = Json.createObjectBuilder()
                .add("id", payload.getInt("id"))
                .add("firstName", payload.getString("firstName"))
                .add("lastName", "Schwarz")
                .add("matNumber", payload.getString("matNumber"))
                .build();
        response = this.tut
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(updateStudent));
        assertThat(response.getStatus(), is(200));
        payload = response.readEntity(JsonObject.class);
        assertThat(payload.getString("lastName"), is("Schwarz"));
    }

}