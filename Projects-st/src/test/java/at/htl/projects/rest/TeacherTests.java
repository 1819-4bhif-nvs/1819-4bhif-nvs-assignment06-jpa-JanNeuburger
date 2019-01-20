package at.htl.projects.rest;

import org.junit.Before;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TeacherTests {
    private Client client;
    private WebTarget tut;

    @Before
    public void initClient() {
        this.client = ClientBuilder.newClient();
        this.tut = client.target("http://localhost:8080/Projects/api/teachers");
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
                .path("15")
                .request(MediaType.APPLICATION_JSON)
                .get();
        assertThat(response.getStatus(), is(200));
        JsonObject payload = response.readEntity(JsonObject.class);
        assertThat(payload.getString("title"), is("Dr"));
    }

    @Test
    public void post() {
        JsonObject teacher = Json.createObjectBuilder()
                .add("firstName", "Werner")
                .add("lastName", "Pichler")
                .add("title", "Prof")
                .build();
        Response response = this.tut
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(teacher));
        assertThat(response.getStatus(), is(200));
        JsonObject payload = response.readEntity(JsonObject.class);
        assertThat(payload.getString("title"), is("Prof"));
    }

    @Test
    public void delete() {
        JsonObject teacher = Json.createObjectBuilder()
                .add("firstName", "Werner")
                .add("lastName", "Pichler")
                .add("title", "Prof")
                .build();
        Response response = this.tut
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(teacher));
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
        JsonObject teacher = Json.createObjectBuilder()
                .add("firstName", "Werner")
                .add("lastName", "Pichler")
                .add("title", "Prof")
                .build();
        Response response = this.tut
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(teacher));
        assertThat(response.getStatus(), is(200));
        JsonObject payload = response.readEntity(JsonObject.class);
        JsonObject updateTeacher = Json.createObjectBuilder()
                .add("id", payload.getInt("id"))
                .add("firstName", payload.getString("firstName"))
                .add("lastName", "Zaicek")
                .add("title", payload.getString("title"))
                .build();
        response = this.tut
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(updateTeacher));
        assertThat(response.getStatus(), is(200));
        payload = response.readEntity(JsonObject.class);
        assertThat(payload.getString("lastName"), is("Zaicek"));
    }
}
