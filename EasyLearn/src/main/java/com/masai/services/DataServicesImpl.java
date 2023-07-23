package com.masai.services;

import java.util.List;
import java.util.Set;

import com.masai.entity.Assignment;
import com.masai.entity.Course;
import com.masai.entity.Lecture;
import com.masai.entity.Quiz;
import com.masai.entity.Student;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.dao.DataDAO;
import com.masai.dao.DataDAOImpl;

public class DataServicesImpl implements DataServices{

	@Override
	public List<Student> showStudents() throws SomethingWentWrongException, NoRecordFoundException {
		DataDAO dataDAO = new DataDAOImpl();
		return dataDAO.showStudents();
	}

	@Override
	public List<Course> showCourses() throws SomethingWentWrongException, NoRecordFoundException {
		DataDAO dataDAO = new DataDAOImpl();
		return dataDAO.showCourses();
	}

	@Override
	public void addAssignment(int courseId, Assignment assignment)
			throws SomethingWentWrongException, NoRecordFoundException {
		DataDAO dataDAO = new DataDAOImpl();
		dataDAO.addAssignment(courseId, assignment);
	}

	@Override
	public void addQuiz(int courseId, Quiz quiz) throws SomethingWentWrongException, NoRecordFoundException {
		DataDAO dataDAO = new DataDAOImpl();
		dataDAO.addQuiz(courseId, quiz);
	}

	@Override
	public void addLecture(int courseId, Lecture lecture) throws SomethingWentWrongException, NoRecordFoundException {
		DataDAO dataDAO = new DataDAOImpl();
		dataDAO.addLecture(courseId, lecture);
	}

	@Override
	public Set<Lecture> seeAllLecturesByCourseID(int courseID)
			throws SomethingWentWrongException, NoRecordFoundException {
		DataDAO dataDAO = new DataDAOImpl();
		return dataDAO.seeAllLecturesByCourseID(courseID);
	}

	@Override
	public Set<Assignment> seeAllAssignmentsByCourseID(int courseID)
			throws SomethingWentWrongException, NoRecordFoundException {
		DataDAO dataDAO = new DataDAOImpl();
		return dataDAO.seeAllAssignmentsByCourseID(courseID);
	}

	@Override
	public Set<Quiz> seeAllQuizzesByCourseID(int courseID) throws SomethingWentWrongException, NoRecordFoundException {
		DataDAO dataDAO = new DataDAOImpl();
		return dataDAO.seeAllQuizzesByCourseID(courseID);
	}

	@Override
	public void deleteLectureByLectureID(int courseID, int lectureID)
			throws SomethingWentWrongException, NoRecordFoundException {
		DataDAO dataDAO = new DataDAOImpl();
		dataDAO.deleteLectureByLectureID(courseID, lectureID);
	}

	@Override
	public void deleteAssignmentByAssignmentID(int courseID, int assignmentID)
			throws SomethingWentWrongException, NoRecordFoundException {
		DataDAO dataDAO = new DataDAOImpl();
		dataDAO.deleteAssignmentByAssignmentID(courseID, assignmentID);
	}

	@Override
	public void deleteQuizByQuizID(int courseID, int quizID)
			throws SomethingWentWrongException, NoRecordFoundException {
		DataDAO dataDAO = new DataDAOImpl();
		dataDAO.deleteQuizByQuizID(courseID, quizID);
	}
	
}
