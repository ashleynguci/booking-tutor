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
@Table(name = "tutor", schema = "public", catalog = "postgres")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 

public class TutorEntity {
	
//	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name="id")
    private Long id;
    
    @Column(name="name")
    private String name;

    @Column(name="background")
    private String background;

    public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "tutor")
    private List<LessonEntity> lessons;

    public TutorEntity(){

    }

    public TutorEntity(String name,String background) {
        this.name = name;
        this.background = background;
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

