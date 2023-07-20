package com.masai.dao;

import com.masai.entity.Course;
import com.masai.entity.State;
import com.masai.entity.Student;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.utility.EMUtilis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class AdminDAOImpl implements AdminDAO{

	@Override
	public void addCourses(Course course) throws SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtilis.getEntityManager();
			et = em.getTransaction();

			et.begin();
			em.persist(course);

			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("Oops Something Went Wrong Please Try Later ..!");
		} finally {
			if (em != null)
				em.close();
		}
		
	}

	@Override
	public void deleteCourseById(int courseID) throws SomethingWentWrongException, NoRecordFoundException {
		Course course = findCourseById(courseID);
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtilis.getEntityManager();
			et = em.getTransaction();
			et.begin();
			course = em.merge(course);
			course.setCourseStatus(State.DELETED);
			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oops can't delete student please try later");
		} finally {
			em.close();
		}
		
	}

	@Override
	public Course findCourseById(int courseID) throws NoRecordFoundException {
		EntityManager em = EMUtilis.getEntityManager();
		Course course = em.find(Course.class, courseID);
		if (course == null || course.getCourseStatus() == State.DELETED) {
			throw new NoRecordFoundException("can't find any course with id " + courseID);
		}
		return course;
	}

}
