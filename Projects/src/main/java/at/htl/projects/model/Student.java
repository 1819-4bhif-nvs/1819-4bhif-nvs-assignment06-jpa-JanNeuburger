package at.htl.projects.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "student")
public class Student extends Person{

    private String matNumber;

    @ManyToMany(mappedBy = "members")
    @JsonbTransient @XmlTransient
    private List<Project> projects;

    //region Constructors
    public Student(){}
    public Student(String firstName, String lastName){
        super(firstName, lastName);
    }
    public Student(String firstName, String lastName, String matNumber){
        super(firstName, lastName);
        this.matNumber = matNumber;
        projects = new LinkedList<>();
    }
    //endregion

    //region Getter and Setter

    public String getMatNumber() {
        return matNumber;
    }

    public void setMatNumber(String matNumber) {
        this.matNumber = matNumber;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    //endregion

    public void addProject(Project project){
        projects.add(project);
        project.getMembers().add(this);
    }
}
