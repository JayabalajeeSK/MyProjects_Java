package com.jb.spring_data_jpa_ex;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jb.spring_data_jpa_ex.model.Student;
import com.jb.spring_data_jpa_ex.repo.StudentRepo;

@SpringBootApplication
public class SpringDataJpaExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaExApplication.class, args);
		
		StudentRepo repo=context.getBean(StudentRepo.class);

		Student s1=context.getBean(Student.class);
		Student s2=context.getBean(Student.class);
		Student s3=context.getBean(Student.class);
		s1.setRollNo(101);
		s1.setName("Jaya");
		s1.setMarks(75);

		s2.setRollNo(102);
		s2.setName("Bala");
		s2.setMarks(85);

		s3.setRollNo(103);
		s3.setName("JB");
		s3.setMarks(95);
		
		repo.save(s1);
		repo.save(s2);
		repo.save(s3);

		System.out.println(repo.findAll());
		System.out.println(repo.findById(103));

		Optional <Student> s = repo.findById(104);
		System.out.println(s.orElse(new Student()));

		System.out.println(repo.findByName("Jaya"));
		
		System.out.println(repo.findByMarks(85));
	}

}
