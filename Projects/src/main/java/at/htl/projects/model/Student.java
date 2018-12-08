package at.htl.projects.model;

import javax.persistence.*;

@Entity(name = "student")
public class Student extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String matNumber;

    //region Constructors
    public Student(){}
    public Student(String firstName, String lastName){
        super(firstName, lastName);
    }
    public Student(String firstName, String lastName, String matNumber){
        super(firstName, lastName);
        this.matNumber = matNumber;
    }
    //endregion
}
