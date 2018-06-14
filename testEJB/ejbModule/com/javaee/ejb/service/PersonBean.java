package com.javaee.ejb.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;
import com.javaee.ejb.entity.*;
/**
 * Session Bean implementation class StudentBean
 */
@Stateless
@LocalBean
public class PersonBean {

	@PersistenceContext(unitName = "testEJBPU")
	private EntityManager em;
	 
    /**
     * Default constructor. 
     */
    public PersonBean() {
        // TODO Auto-generated constructor stub
    }
    
   public List<Person> findAllPerson(){
    	TypedQuery<Person> query = em.createNamedQuery("findAllPerson", Person.class);
    	return query.getResultList();
    }
    
    public Person findStudentBySno(int personId) {
    	return em.find(Person.class, personId);
    }
    
    public Person createStudent(Person person) {
    	em.persist(person);
    	return person;
    }
    
    public void deleteStudent(Person person) {
    	em.remove(em.merge(person));
    }
    
    public Person updateStudent(Person person) {
    	return em.merge(person);
    }
}
