package manytomanyunim12.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanyunim12.dto.Students;

public class StudentDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	public void updateStudent(int id,Students students) {
		EntityManager  entityManager=getEntityManager();
		Students dbStudents=entityManager.find(Students.class, id);
		if(dbStudents!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			
			students.setId(id);
			students.setCourses(dbStudents.getCourses());
			
			entityManager.merge(students);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry Id is not present");
		}
	}
	
	public void findStudent(int id) {
		EntityManager  entityManager=getEntityManager();
		Students dbStudents=entityManager.find(Students.class, id);
		if(dbStudents!=null) {
			System.out.println(dbStudents);
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	public void deleteStudent(int id) {
		EntityManager  entityManager=getEntityManager();
		Students dbStudents=entityManager.find(Students.class, id);
		if(dbStudents!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbStudents);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
