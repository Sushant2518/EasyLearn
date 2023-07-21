package com.masai.dao;

import com.masai.entity.Instructor;
import com.masai.entity.Student;
import com.masai.exception.SomethingWentWrongException;
import com.masai.utility.EMUtilis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class RegisterDaoImpl implements RegisterDao{

	@Override
	public String registerInstructor(Instructor instructor) throws SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			// creating entityManager from EmUtils class
			em = EMUtilis.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(instructor);
			et.commit();
			return "Instuctor registered succesfully ..!";
		} catch (PersistenceException p) {
			et.rollback();
			// throwing SomethingWentWrongException to hide any problem from user
			throw new SomethingWentWrongException("unable to register Instuctor please try again later");
		} finally {
			em.close();
		}
	}

	@Override
	public String registerStudent(Student student) throws SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			// creating entityManager from EmUtils class
			em = EMUtilis.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(student);
			et.commit();
			return "Student registered succesfully ..!";
		} catch (PersistenceException p) {
			et.rollback();
			// throwing SomethingWentWrongException to hide any problem from user
			throw new SomethingWentWrongException("unable to register Student please try again later");
		} finally {
			if(em!=null) {
				em.close();
			}
		}
	}

}
