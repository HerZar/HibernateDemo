package com.hibernate.demo.onetoone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hibernate.demo.udemy.entity.Instructor;
import com.hibernate.demo.udemy.entity.InstructorDetail;
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
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(OneToManyApp.class, args);
		
		ctx.close();
		
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
	
	public void getAllExample() {
		System.out.println("GetAll method");
		List<Instructor> lista = instructorService.findAll();
		for (Instructor item : lista) System.out.println(item);
	}
	
	
	public void saveAnInstructor() {
		System.out.println("Save an instructor");
		
		Instructor instructor = new Instructor("Silvia", "Zarzycki", "silvia@hz.com");
		InstructorDetail detail = new InstructorDetail("silviayoutube", "huerta");
		instructor.setInstructorDetail(detail);
		instructorService.save(instructor);
		
	}
	
	public void deleteAnIstructor(long id) {
		//get the instructor by id
		Instructor ins = instructorService.findById(id);
		//show the instructor
		System.out.println("I'm going to delete instructor: "+ins);
		//delete that instructor
		instructorService.delete(ins);
	}
	
	
	

}
