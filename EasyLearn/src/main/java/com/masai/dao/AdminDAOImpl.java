package com.masai.dao;

import com.masai.entity.Course;
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

}
