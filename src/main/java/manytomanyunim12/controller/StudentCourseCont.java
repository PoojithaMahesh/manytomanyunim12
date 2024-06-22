package manytomanyunim12.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanyunim12.dto.Course;
import manytomanyunim12.dto.Students;

public class StudentCourseCont {
public static void main(String[] args) {
	Course course1=new Course();
	course1.setId(1);
	course1.setName("Java");
	course1.setFees(5000);
	
	Course course2=new Course();
	course2.setId(2);
	course2.setName("SQL");
	course2.setFees(4000);
	
	Course course3=new Course();
	course3.setId(3);
	course3.setName("Advance Java");
	course3.setFees(6000);
	
	List<Course> courses=new ArrayList<Course>();
	courses.add(course1);
	courses.add(course2);
	courses.add(course3);
	
	Students students1=new Students();
	students1.setId(1);
	students1.setName("Fahar");
	students1.setAddress("Bangalore");
	students1.setCourses(courses);
	
	
	Students students2=new Students();
	students2.setId(2);
	students2.setName("Gursimar");
	students2.setAddress("Ap");
	students2.setCourses(courses);
	
	List<Course> courses1=new ArrayList<Course>();
	courses1.add(course1);
	courses1.add(course2);

	
	Students students3=new Students();
	students3.setAddress("Mandya");
	students3.setId(3);
	students3.setName("Anusha");
	students3.setCourses(courses1);
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(course1);
	entityManager.persist(course2);
	entityManager.persist(course3);
	entityManager.persist(students1);
	entityManager.persist(students2);
	entityManager.persist(students3);
	entityTransaction.commit();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
