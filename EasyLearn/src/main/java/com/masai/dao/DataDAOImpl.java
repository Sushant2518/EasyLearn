package com.masai.dao;

import java.util.List;

import com.masai.entity.Course;
import com.masai.entity.State;
import com.masai.entity.Student;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.utility.EMUtilis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class DataDAOImpl implements DataDAO{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> showStudents() throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		try {
			em = EMUtilis.getEntityManager();
			String query = "SELECT s FROM Student s where s.accountStatus = :accStatus";
			Query qu = em.createQuery(query);
			qu.setParameter("accStatus", State.ACTIVE);
			List<Student> resultList = (List<Student>) qu.getResultList();
			if (resultList.isEmpty()) {
				throw new NoRecordFoundException("No active student found in DataBase");
			}
			return resultList;
		} catch (PersistenceException p) {
			throw new SomethingWentWrongException("oop's something went wrong please try later");
		} finally {
			em.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> showCourses() throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		try {
			em = EMUtilis.getEntityManager();
			String query = "SELECT c FROM Course c where c.courseStatus = :accStatus";
			Query qu = em.createQuery(query);
			qu.setParameter("accStatus", State.ACTIVE);
			List<Course> resultList = (List<Course>) qu.getResultList();
			if (resultList.isEmpty()) {
				throw new NoRecordFoundException("No Course found in DataBase");
			}
			return resultList;
		} catch (PersistenceException p) {
			throw new SomethingWentWrongException("oop's something went wrong please try later");
		} finally {
			em.close();
		}
		
	}

}
