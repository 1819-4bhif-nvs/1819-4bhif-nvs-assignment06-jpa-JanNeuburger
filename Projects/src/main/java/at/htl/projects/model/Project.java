package at.htl.projects.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @JsonbTransient
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL)
    private List<Student> members;

    @JsonbTransient
    @XmlTransient
    @OneToOne(cascade = CascadeType.ALL)
    private Teacher supervisor;

    @JsonbTransient
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL)
    private List<Meeting> meetings;

    //region Constructors
    public Project(){
        members = new LinkedList<Student>();
        meetings = new LinkedList<Meeting>();
    }
    public Project(String name, String description){
        members = new LinkedList<Student>();
        meetings = new LinkedList<Meeting>();
        this.name = name;
        this.description = description;
    }
    //endregion

    //region Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getMembers() {
        return members;
    }

    public void setMembers(List<Student> members) {
        this.members = members;
    }

    public Teacher getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Teacher supervisor) {
        this.supervisor = supervisor;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }


    //endregion
}
