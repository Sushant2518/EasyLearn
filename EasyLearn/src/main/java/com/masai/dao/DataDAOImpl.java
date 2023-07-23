package com.masai.dao;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.masai.entity.Assignment;
import com.masai.entity.Course;
import com.masai.entity.Lecture;
import com.masai.entity.Quiz;
import com.masai.entity.State;
import com.masai.entity.Student;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.utility.EMUtilis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
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


	@Override
	public void addAssignment(int courseId, Assignment assignment)
			throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtilis.getEntityManager();
			et = em.getTransaction();
			Course course = em.find(Course.class, courseId);
			if (course == null) {
				throw new NoRecordFoundException("can't find any course with id " + courseId);
			}
			et.begin();
			em.merge(course);
			course.getAssignments().add(assignment);
			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oop's can't add assignment please try later ");
		} finally {
			em.close();
		}
		
	}


	@Override
	public void addQuiz(int courseId, Quiz quiz) throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtilis.getEntityManager();
			et = em.getTransaction();
			Course course = em.find(Course.class, courseId);
			if (course == null) {
				throw new NoRecordFoundException("can't find any course with id " + courseId);
			}
			et.begin();
			em.merge(course);
			course.getQuizzes().add(quiz);
			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oop's can't add quiz please try later ");
		} finally {
			em.close();
		}
		
	}


	@Override
	public void addLecture(int courseId, Lecture lecture) throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtilis.getEntityManager();
			et = em.getTransaction();
			Course course = em.find(Course.class, courseId);
			if (course == null) {
				throw new NoRecordFoundException("can't find any course with id " + courseId);
			}
			et.begin();
			em.merge(course);
			course.getLectures().add(lecture);
			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oop's can't add lecture please try later ");
		} finally {
			em.close();
		}
		
	}


	@Override
	public Set<Lecture> seeAllLecturesByCourseID(int courseID)
			throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		try {
			em = EMUtilis.getEntityManager();
			Course course = em.find(Course.class, courseID);
			if (course == null) {
				throw new NoRecordFoundException("Can't find any course with id " + courseID);
			}
			Set<Lecture> lectures = course.getLectures().stream().filter(e -> e.getIs_deleted() == State.ACTIVE)
					.collect(Collectors.toSet());
			if (lectures.isEmpty()) {
				throw new NoRecordFoundException("There are no any lectures in this course");
			}
			return lectures;
		} catch (PersistenceException p) {
			throw new SomethingWentWrongException("oop's something went wrong please try later");
		} finally {
			em.close();
		}
	}


	@Override
	public Set<Assignment> seeAllAssignmentsByCourseID(int courseID)
			throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		try {
			em = EMUtilis.getEntityManager();
			Course course = em.find(Course.class, courseID);
			if (course == null) {
				throw new NoRecordFoundException("Can't find any course with id " + courseID);
			}
			Set<Assignment> assignments = course.getAssignments().stream()
					.filter(e -> e.getIs_deleted() == State.ACTIVE).collect(Collectors.toSet());
			if (assignments.isEmpty()) {
				throw new NoRecordFoundException("There are no any assignments in this course");
			}
			return assignments;
		} catch (PersistenceException p) {
			throw new SomethingWentWrongException("oop's something went wrong please try later");
		} finally {
			em.close();
		}
	}


	@Override
	public Set<Quiz> seeAllQuizzesByCourseID(int courseID) throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		try {
			em = EMUtilis.getEntityManager();
			Course course = em.find(Course.class, courseID);
			if (course == null) {
				throw new NoRecordFoundException("Can't find any course with id " + courseID);
			}
			Set<Quiz> quizzes = course.getQuizzes().stream().filter(e -> e.getIs_deleted() == State.ACTIVE)
					.collect(Collectors.toSet());
			if (quizzes.isEmpty()) {
				throw new NoRecordFoundException("There are no any quizzes in this course ");
			}
			return quizzes;
		} catch (PersistenceException p) {
			throw new SomethingWentWrongException("oop's something went wrong please try later");
		} finally {
			em.close();
		}
	}


	@Override
	public void deleteLectureByLectureID(int courseID, int lectureID)
			throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		EntityTransaction et = null;
		List<Course> courses = showCourses();
		Course course = courses.stream().filter(c -> c.getCourseId() == courseID).findAny().orElse(null);
		if (course == null) {
			throw new NoRecordFoundException("can't find any course with course ID " + courseID);
		}

		try {
			em = EMUtilis.getEntityManager();
			et = em.getTransaction();
			et.begin();
			course = em.merge(course);
			Set<Lecture> lectures = course.getLectures();

			// code for deletion validation

			Lecture lecture = lectures.stream().filter(a -> a.getLectureId() == lectureID).findAny().orElse(null);

			// code to check if no assignment is there with this id

			if (lecture == null || lecture.getIs_deleted() == State.DELETED) {
				throw new NoRecordFoundException("can't find any lecture with id " + lectureID);
			}

			lectures.stream().filter(a -> a.getLectureId() == lectureID).findFirst().ifPresent(a -> {
				if (a.getIs_deleted() != State.DELETED) {
					a.setIs_deleted(State.DELETED);
				}
			});
			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oop's a problem occured , please try again later");
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}


	@Override
	public void deleteAssignmentByAssignmentID(int courseID, int assignmentID)
			throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		EntityTransaction et = null;
		List<Course> courses = showCourses();
		Course course = courses.stream().filter(c -> c.getCourseId() == courseID).findAny().orElse(null);
		if (course == null) {
			throw new NoRecordFoundException("can't find any course with course ID " + courseID);
		}
		
		// -=-=-=- code to get course by id ends here -=-=-=-=-=-=-=-=-=-
		
		try {
			em = EMUtilis.getEntityManager();
			et = em.getTransaction();
			et.begin();
			course = em.merge(course);
			Set<Assignment> assignments = course.getAssignments();

	
			Assignment assignment = assignments.stream().filter(a -> a.getAssignmentID() == assignmentID).findAny().orElse(null);

			
			if (assignment == null || assignment.getIs_deleted() == State.DELETED) {
				throw new NoRecordFoundException("can't find any assignment with id " + assignmentID);
			}

			assignments.stream().filter(a -> a.getAssignmentID() == assignmentID).findFirst().ifPresent(a -> {
				if (a.getIs_deleted() != State.DELETED) {
					a.setIs_deleted(State.DELETED);
				}
			});
			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oop's a problem occured , please try again later");
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}


	@Override
	public void deleteQuizByQuizID(int courseID, int quizID)
			throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		EntityTransaction et = null;
		List<Course> courses = showCourses();
		Course course = courses.stream().filter(c -> c.getCourseId() == courseID).findAny().orElse(null);
		if (course == null) {
			throw new NoRecordFoundException("can't find any course with course ID " + courseID);
		}
		
		// -=-=-=- code to get course by id ends here -=-=-=-=-=-=-=-=-=-
		
		try {
			em = EMUtilis.getEntityManager();
			et = em.getTransaction();
			et.begin();
			course = em.merge(course);
			Set<Quiz> quizzes = course.getQuizzes();


			Quiz quiz = quizzes.stream().filter(a -> a.getQuizId() == quizID).findAny().orElse(null);


			if (quiz == null || quiz.getIs_deleted() == State.DELETED) {
				throw new NoRecordFoundException("can't find any quiz associated with id " + quizID);
			}

			quizzes.stream().filter(a -> a.getQuizId() == quizID).findFirst().ifPresent(a -> {
				if (a.getIs_deleted() != State.DELETED) {
					a.setIs_deleted(State.DELETED);
				}
			});
			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oop's a problem occured , please try again later");
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}

}
