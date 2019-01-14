package at.htl.projects.rest;

import at.htl.projects.model.Meeting;

import javax.ejb.Stateless;
import javax.ws.rs.Path;


@Path("meetings")
@Stateless
public class MeetingEndpoint extends AbstractEndpoint<Meeting> {

    public MeetingEndpoint(){
        super(Meeting.class);
    }
}