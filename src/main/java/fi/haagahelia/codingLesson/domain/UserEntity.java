package fi.haagahelia.codingLesson.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tutor", schema = "public", catalog = "postgres")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 

public class UserEntity {
	
//	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name="id")
    private Long id;
    
    @Column(name="name")
    private String name;

    

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<LessonEntity> lessons;

    public UserEntity(){

    }

    public UserEntity(String name) {
        this.name = name;
    }


    

 
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
    public List<LessonEntity> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonEntity> lessons) {
        this.lessons = lessons;
    }

}
