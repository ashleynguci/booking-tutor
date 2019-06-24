package fi.haagahelia.codingLesson.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "user_entity", schema = "public", catalog = "postgres")

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name="id")
    private int id;
    
    @Column(name="name")
    private String name;

    

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<LessonEntity> lessons;

    public UserEntity(){

    }

    public UserEntity(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<LessonEntity> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonEntity> lessons) {
        this.lessons = lessons;
    }

}
