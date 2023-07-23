package com.masai.dao;

import com.masai.entity.CurrentLoggedInID;
import com.masai.entity.Instructor;
import com.masai.entity.State;
import com.masai.entity.Student;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.utility.EMUtilis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class LoginDAOImpl implements LoginDAO{

	@Override
	public Boolean LoginInstructor(String username, String password)
			throws NoRecordFoundException, SomethingWentWrongException {
		EntityManager em = null;
		try {
			em = EMUtilis.getEntityManager();
			String loginQuery = "SELECT ins FROM Instructor ins WHERE ins.username = :username and ins.password = :password and ins.accountStatus = :status";
			Query qu = em.createQuery(loginQuery);
			qu.setParameter("username", username);
			qu.setParameter("password", password);
			qu.setParameter("status", State.ACTIVE);
			Instructor instructor = (Instructor) qu.getSingleResult();

			if (instructor != null) {
				CurrentLoggedInID.CurrentLoggedInInstructorsID = instructor.getId();
				return true;
			}
		} catch (NoResultException e) {
			throw new NoRecordFoundException("wrong username or passowrd");
		} catch (PersistenceException p) {
			p.printStackTrace();
			throw new SomethingWentWrongException("unable to login please try later");
		} finally {
			em.close();
		}
		return false;
	}

	@Override
	public Boolean LoginStudent(String username, String password)
			throws NoRecordFoundException, SomethingWentWrongException {
		EntityManager em = null;
		try {
			em = EMUtilis.getEntityManager();
			String loginQuery = "SELECT stu FROM Student stu WHERE stu.username = :username and stu.password = :password and stu.accountStatus = :status";
			Query qu = em.createQuery(loginQuery);
			qu.setParameter("username", username);
			qu.setParameter("password", password);
			qu.setParameter("status", State.ACTIVE);
			Student student = (Student) qu.getSingleResult();

			if (student != null) {
				CurrentLoggedInID.CurrentLoggedInStudentID = student.getId();
				return true;
			}
		} catch (NoResultException e) {
			throw new NoRecordFoundException("wrong username or passowrd");
		} catch (PersistenceException p) {
			p.printStackTrace();
			throw new SomethingWentWrongException("unable to login please try later");
		} finally {
			em.close();
		}
		return false;
	}

}
