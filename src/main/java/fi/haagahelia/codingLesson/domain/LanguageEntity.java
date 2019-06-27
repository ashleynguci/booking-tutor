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
/**
 * 
 * @author TrucAnh
 *
 */
@Table(name = "language", schema = "public", catalog = "postgres")
 
public class LanguageEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    
    @Column(name="name")
    private String name;


    @OneToMany(cascade=CascadeType.ALL,mappedBy = "language")
    private List<LessonEntity> lessons;

    public LanguageEntity(){

    }
    /**
     * This constructs a language entity with a specific name
     * @param name
     */

    public LanguageEntity(String name) {

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
