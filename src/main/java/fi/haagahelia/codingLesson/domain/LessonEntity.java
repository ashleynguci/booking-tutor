package fi.haagahelia.codingLesson.domain;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "lesson", schema = "public", catalog = "postgres")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class LessonEntity implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="start_time")
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm", shape=Shape.STRING)
    private String startTime;
    
    @Column(name="end_time")
    private String endTime;
    
    @Column(name="location")
    private String location;
    
    @Column(name="satisfaction_level")
    private Integer satisfactionLevel;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="language_id")
    private LanguageEntity language;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="tutor_id")
    private UserEntity user;


    public LessonEntity() {
    }

    public LessonEntity(String startTime, String endTime, String location, Integer satisfactionLevel, LanguageEntity language, UserEntity user) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.satisfactionLevel = satisfactionLevel;
        this.language = language;
        this.user = user;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    

    
    public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    
    public Integer getSatisfactionLevel() {
        return satisfactionLevel;
    }

    public void setSatisfactionLevel(Integer satisfactionLevel) {
        this.satisfactionLevel = satisfactionLevel;
    }



    
    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
