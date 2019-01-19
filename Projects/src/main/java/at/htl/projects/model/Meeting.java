package at.htl.projects.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime date;
    private String description;

    @ManyToOne
    private Project project;

    //region Constructors
    public Meeting(){
    }
    public Meeting(LocalDateTime date, String description){
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //endregion
}
