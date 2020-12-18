package com.hibernate.demo.onetomany;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.demo.udemy.entity.Course;
import com.hibernate.demo.udemy.entity.Instructor;
import com.hibernate.demo.udemy.entity.InstructorDetail;
import com.hibernate.demo.udemy.services.CourseService;
import com.hibernate.demo.udemy.services.InstructorService;

@SpringBootApplication
@ComponentScan({
	"com.hibernate.demo.udemy.entity", 
	"com.hibernate.demo.udemy.repository",
	"com.hibernate.demo.udemy.services"})
@EntityScan("com.hibernate.demo.udemy.entity")
@EnableJpaRepositories("com.hibernate.demo.udemy.repository")
public class OneToManyApp  implements CommandLineRunner {

	
	@Autowired
	InstructorService instructorService;
	
	@Autowired
	CourseService courseService;
	
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(OneToManyApp.class, args);
		ctx.close();		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("iniciando proceso");
//		crearInstructor();
//		crearInstructorConCursos();
//		createCurses();
//		
//		actualizandoCursos();
//		
//		agregarMasCursos();
		eliminarCurso();
		
	}
	
	public void crearInstructor() {
		System.out.println("creando un instructor");
		Instructor ins = new Instructor("Javier", "Mota", "jm@hz.com");
		InstructorDetail detail = new InstructorDetail("youtube.com", "el futbol");
		ins.setInstructorDetail(detail);
		this.instructorService.save(ins);
	}
	
	public void crearInstructorConCursos() {
		System.out.println("creando un instructor");
		Instructor ins = new Instructor("Raul", "Pena", "jm@hz.com");
		InstructorDetail detail = new InstructorDetail("youtube.com", "el futbol");
		ins.setInstructorDetail(detail);
		Course c1 = new Course("Java");
		Course c2 = new Course("Hibernate");		
		ins.add(c1);
		ins.add(c2);
		this.instructorService.save(ins);
	}
	
	public void createCurses() {
		
		System.out.println("creando un curso");
		Instructor ins =  this.instructorService.findById(1l);				
		Course c1 = new Course("de carpinteria");
		Course c2 = new Course("de futbol");		
		ins.add(c1);
		ins.add(c2);
		this.instructorService.save(ins);					
	}
	
	public void actualizandoCursos() {
		System.out.println("creando un curso");
		Instructor ins =  this.instructorService.findById(2l);				
		ins.getCourses(courseService).get(0).setTitle("Patrones");
		this.instructorService.save(ins);	
	}
	
	public void agregarMasCursos() {
		System.out.println("creando un curso");
		Instructor ins =  this.instructorService.findById(2l);		
		Course c1 = new Course("Androi");
		Course c2 = new Course("Spring");		
		ins.add(c1);
		ins.add(c2);
		this.instructorService.save(ins);
	}

	public void eliminarCurso() {
		System.out.println("creando un curso");
		Instructor ins =  this.instructorService.findById(2l);		
		courseService.delete(ins.getCourses(courseService).remove(0));
		this.instructorService.save(ins);
	}

	
	
}
