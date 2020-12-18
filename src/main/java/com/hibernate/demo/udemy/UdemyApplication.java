package com.hibernate.demo.udemy;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.List;

import com.hibernate.demo.udemy.entity.Student;
import com.hibernate.demo.udemy.services.StudentService;

@SpringBootApplication
public class UdemyApplication  implements CommandLineRunner {

	
	@Autowired
	StudentService ss;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(UdemyApplication.class, args);
		
		ctx.close();
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		saveExample();
		getAllExample();
		
		
		
	}
	
	public void getAllExample() {
		System.out.println("hola");
		List<Student> lista = ss.findAll();
		for (Student s : lista) System.out.println(s);
	}
	
	public void saveExample() {
		System.out.println("Saving 3 students");
		
		Student st1 = new Student("John", "Doe", "John@hz.com");
		Student st2 = new Student("Bonita", "Doe", "Bonita@hz.com");
		Student st3 = new Student("Lola", "Doe", "Lola@hz.com");
		
		ss.save(st1);ss.save(st2);ss.save(st3);
		
	}
	
	
	

}
