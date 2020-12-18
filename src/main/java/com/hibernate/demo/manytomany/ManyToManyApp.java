package com.hibernate.demo.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hibernate.demo.udemy.entity.Course;
import com.hibernate.demo.udemy.entity.Instructor;
import com.hibernate.demo.udemy.entity.InstructorDetail;
import com.hibernate.demo.udemy.entity.Student;
import com.hibernate.demo.udemy.services.CourseService;
import com.hibernate.demo.udemy.services.InstructorService;
import com.hibernate.demo.udemy.services.StudentService;

@SpringBootApplication
@ComponentScan({
	"com.hibernate.demo.udemy.entity", 
	"com.hibernate.demo.udemy.repository",
	"com.hibernate.demo.udemy.services"})
@EntityScan("com.hibernate.demo.udemy.entity")
@EnableJpaRepositories("com.hibernate.demo.udemy.repository")
public class ManyToManyApp  implements CommandLineRunner {

	
	@Autowired
	InstructorService instructorService;
	
	@Autowired
	CourseService courseService;
	@Autowired
	StudentService studentService;
	
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ManyToManyApp.class, args);
		ctx.close();		
	}



	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("hello");
//		crearInstructor();
//		createCurses();
//		addStudets();
		imprimirCoursoYAlumnos();
	}
	
	public void crearInstructor() {
		System.out.println("creando un instructor");
		Instructor ins = new Instructor("Javier", "Mota", "jm@hz.com");
		InstructorDetail detail = new InstructorDetail("youtube.com", "el futbol");
		ins.setInstructorDetail(detail);
		this.instructorService.save(ins);
	}
	
	public void createCurses() {
		
		System.out.println("creando un curso");
		Instructor ins =  this.instructorService.findById(1l);				
		Course c1 = new Course("Spring");
		Course c2 = new Course("Java");		
		ins.add(c1);
		ins.add(c2);
		this.instructorService.save(ins);					
	}

	public void addStudets() {
		
		System.out.println("agregando students");
		Course course = courseService.findByTitle("Java");
		Student s1= new Student("Hernan", "Zarzycki", "hernanzarzycki@gmail.com");
		Student s2= new Student("Hernan2", "Zarzycki", "hernanzarzycki@gmail.com");
		Student s3= new Student("Hernan3", "Zarzycki", "hernanzarzycki@gmail.com");
		Student s4= new Student("Hernan4", "Zarzycki", "hernanzarzycki@gmail.com");
		Student s5= new Student("Hernan5", "Zarzycki", "hernanzarzycki@gmail.com");
		List<Student> students = new ArrayList();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		
		course.setStudents(students);
		
		courseService.save(course);
		
		
		
	}
	
	public void imprimirCoursoYAlumnos() {
		
		System.out.println("agregando students");
		Course course = courseService.findByTitle("Java");
		course.setStudents(studentService.findByCourseId(course.getId()));
		
		System.out.println("Course title: "+course.getTitle());
		for (Student s : course.getStudents()) {
			System.out.println("alumno: "+ s);
		}
	}
	
	
}
