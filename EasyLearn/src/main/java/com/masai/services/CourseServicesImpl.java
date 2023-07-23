package com.masai.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.masai.entity.Assignment;
import com.masai.entity.Course;
import com.masai.entity.Lecture;
import com.masai.entity.Quiz;
import com.masai.entity.Status;
import com.masai.exception.AlreadyUpdatedException;
import com.masai.exception.NoAccountLoggedInException;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.dao.CourseDAO;
import com.masai.dao.CourseDAOImpl;

public class CourseServicesImpl implements CourseServices{

	@Override
	public Set<Course> showCourses()
			throws NoRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		CourseDAO courseDAO = new CourseDAOImpl();

		Set<Course> courses = courseDAO.showCourses();

		return courses;
	}

	@Override
	public List<Assignment> showAssignments()
			throws NoRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		CourseDAO courseDAO = new CourseDAOImpl();
		return courseDAO.showAssignments();
	}

	@Override
	public List<Quiz> showQuizzes()
			throws NoRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		CourseDAO courseDAO = new CourseDAOImpl();
		return courseDAO.showQuizzes();
	}

	@Override
	public List<Lecture> showLectures()
			throws NoRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		CourseDAO courseDAO = new CourseDAOImpl();
		return courseDAO.showLectures();
	}

	@Override
	public Boolean updateAssignmentStatus(int courseID, int assignmentID, int status) throws NoRecordFoundException,
			SomethingWentWrongException, NoAccountLoggedInException, AlreadyUpdatedException {
		CourseDAO courseDAO = new CourseDAOImpl();
		return courseDAO.updateAssignmentStatus(courseID, assignmentID, status);
	}

	@Override
	public Boolean updateQuizStatus(int courseID, int quizID, int status) throws NoRecordFoundException,
			SomethingWentWrongException, NoAccountLoggedInException, AlreadyUpdatedException {
		CourseDAO courseDAO = new CourseDAOImpl();
		return courseDAO.updateQuizStatus(courseID, quizID, status);
	}

	@Override
	public void updateLectureStatus(int courseID, int lectureID) throws NoRecordFoundException,
			SomethingWentWrongException, NoAccountLoggedInException, AlreadyUpdatedException {
		CourseDAO courseDAO = new CourseDAOImpl();
		courseDAO.updateLectureStatus(courseID, lectureID);
	}

	@Override
	public Map<String, Double> showStats()
			throws NoRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		List<Assignment> assignments = showAssignments();
		List<Quiz> quizzes = showQuizzes();
		List<Lecture> lectures = showLectures();
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
