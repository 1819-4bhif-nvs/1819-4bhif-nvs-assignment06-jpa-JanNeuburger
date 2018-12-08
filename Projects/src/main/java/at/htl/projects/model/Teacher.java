package at.htl.projects.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "teacher")
public class Teacher extends Person{
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

    //region Getter and Setter

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //endregion
}
