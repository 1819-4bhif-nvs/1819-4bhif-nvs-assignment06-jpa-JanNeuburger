package at.htl.projects.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "teacher")
public class Teacher extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    //region Constructors
    public Teacher(){}
    public Teacher(String firstName, String lastName){
        super(firstName, lastName);
    }
    public Teacher(String firstName, String lastName, String title){
        super(firstName, lastName);
        this.title = title;
    }
    //endregion
}
