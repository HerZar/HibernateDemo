package com.hibernate.demo.udemy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="youtube_chanel")
	private String youtubeChanel;
	
	@Column(name="hobby")
	private String hobby;
	
	//el instructor es para agregar una relacion bidireccional 
	//esto no cambia la estructura de la base de datos
	// lo que hace es mirar al instructor y ver el joincollum para acomodar el query.
	// nota que no tiene una notattion de column
	// tene en cuenta que el nombre de "mappedBy" es el nombre del atributo,
	// es el nombre de la variable que tiene el join column notattion en instructor.
	@OneToOne(mappedBy = "instructorDetail",  cascade = CascadeType.ALL)
	private Instructor instructor;

	public InstructorDetail() {
	}
	
	public InstructorDetail(String youtubeChanel, String hobby) {
		this.youtubeChanel = youtubeChanel;
		this.hobby = hobby;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getYoutubeChanel() {
		return youtubeChanel;
	}

	public void setYoutubeChanel(String youtubeChanel) {
		this.youtubeChanel = youtubeChanel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChanel=" + youtubeChanel + ", hobby=" + hobby + ", instructor="
				+ instructor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hobby == null) ? 0 : hobby.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((instructor == null) ? 0 : instructor.hashCode());
		result = prime * result + ((youtubeChanel == null) ? 0 : youtubeChanel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstructorDetail other = (InstructorDetail) obj;
		if (hobby == null) {
			if (other.hobby != null)
				return false;
		} else if (!hobby.equals(other.hobby))
			return false;
		if (id != other.id)
			return false;
		if (instructor == null) {
			if (other.instructor != null)
				return false;
		} else if (!instructor.equals(other.instructor))
			return false;
		if (youtubeChanel == null) {
			if (other.youtubeChanel != null)
				return false;
		} else if (!youtubeChanel.equals(other.youtubeChanel))
			return false;
		return true;
	}
	

	
	
	
	
}
