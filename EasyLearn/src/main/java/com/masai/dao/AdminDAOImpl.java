package com.masai.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.masai.entity.Assignment;
import com.masai.entity.Course;
import com.masai.entity.Instructor;
import com.masai.entity.Lecture;
import com.masai.entity.Quiz;
import com.masai.entity.State;
import com.masai.entity.Status;
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
	
	@Override
	public Student findStudentById(int studentId) throws NoRecordFoundException {
		EntityManager em = EMUtilis.getEntityManager();
		Student student = em.find(Student.class, studentId);
		if (student == null || student.getAccountStatus() == State.DELETED) {
			throw new NoRecordFoundException("can't find any Student with id " + studentId);
		}
		return student;
	}

	
	@Override
	public void assignCoureToStudent(int[] courseIDs, int studentId)
			throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		EntityTransaction et = null;
		Student student = findStudentById(studentId);

		try {
			em = EMUtilis.getEntityManager();
			et = em.getTransaction();
			et.begin();
			student = em.merge(student);
			for (int i = 0; i < courseIDs.length; i++) {
				Course course = findCourseById(courseIDs[i]);
				course = em.merge(course);
				student.getCourses().add(course);
			}
			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			p.printStackTrace();
			throw new SomethingWentWrongException("oops can't assign courses to database please try later ..!");
		} finally {
			em.close();
		}
		
	}

	@Override
	public void deleteStudentById(int studentId) throws SomethingWentWrongException, NoRecordFoundException {
		Student student = findStudentById(studentId);
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtilis.getEntityManager();
			et = em.getTransaction();
			et.begin();
			student = em.merge(student);
			student.setAccountStatus(State.DELETED);
			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oops can't delete student please try later");
		} finally {
			em.close();
		}
	}

	@Override
	public void deleteInstructorById(int instrucorID) throws NoRecordFoundException, SomethingWentWrongException {
		Instructor instructor = findInstructorById(instrucorID);
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtilis.getEntityManager();
			et = em.getTransaction();
			et.begin();
			instructor = em.merge(instructor);
			instructor.setAccountStatus(State.DELETED);
			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oops can't delete student please try later");
		} finally {
			em.close();
		}
		
	}

	@Override
	public Instructor findInstructorById(int instructorId) throws NoRecordFoundException {
		EntityManager em = EMUtilis.getEntityManager();
		Instructor instructor = em.find(Instructor.class, instructorId);
		if (instructor == null || instructor.getAccountStatus() == State.DELETED) {
			throw new NoRecordFoundException("can't find any Instructor with id " + instructor);
		}
		return instructor;
	}

	@Override
	public Map<String, Double> showStats(int courseID) throws NoRecordFoundException, SomethingWentWrongException {
		Course course = findCourseById(courseID);
		Set<Assignment> assignments = course.getAssignments();
		Set<Quiz> quizzes = course.getQuizzes();
		Set<Lecture> lectures = course.getLectures();
		List<Assignment> CompletedAssignments = assignments.stream().filter(a -> a.getIsCompleted() == Status.COMPLETED)
				.collect(Collectors.toList());
		List<Quiz> Completedquizzes = quizzes.stream().filter(a -> a.getIsCompleted() == Status.COMPLETED)
				.collect(Collectors.toList());
		List<Lecture> CompletedLectures = lectures.stream().filter(a -> a.getIsWatched() == Status.COMPLETED)
				.collect(Collectors.toList());

		double assignMentSubmissionRate = Math.round(((CompletedAssignments.size()/assignments.size())*100)*100.00)/100.00;
		double quizzesSubmissionRate = Math.round(((Completedquizzes.size()/quizzes.size())*100)*100.00)/100.00;
		double attendence = Math.round(((CompletedLectures.size()/lectures.size())*100)*100.00)/100.00;
		
		Map<String, Double> stats = new HashMap<>();
		stats.put("assignMentSubmissionRate", assignMentSubmissionRate);
		stats.put("quizzesSubmissionRate", quizzesSubmissionRate);
		stats.put("attendence", attendence);
		return stats;
	
	}

	
}
