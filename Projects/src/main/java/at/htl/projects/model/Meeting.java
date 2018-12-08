package at.htl.projects.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;
    private String description;

    @JsonbTransient
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL)
    private List<Person> attendants;

    //region Constructors
    public Meeting(){
        attendants = new LinkedList<Person>();
    }
    public Meeting(LocalDate date, String description){
        attendants = new LinkedList<Person>();
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Person> getAttendants() {
        return attendants;
    }

    public void setAttendants(List<Person> attendants) {
        this.attendants = attendants;
    }
    //endregion
}
