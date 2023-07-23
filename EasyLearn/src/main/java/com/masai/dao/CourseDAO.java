package com.masai.dao;

import java.util.List;
import java.util.Set;

import com.masai.entity.Assignment;
import com.masai.entity.Course;
import com.masai.entity.Lecture;
import com.masai.entity.Quiz;
import com.masai.exception.AlreadyUpdatedException;
import com.masai.exception.NoAccountLoggedInException;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface CourseDAO {
	Set<Course> showCourses() throws NoRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException;
	List<Assignment> showAssignments() throws NoRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException;
	List<Quiz> showQuizzes() throws NoRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException;
	List<Lecture> showLectures() throws NoRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException;
	Boolean updateAssignmentStatus(int courseID, int assignmentID, int status) throws NoRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException, AlreadyUpdatedException;
	Boolean updateQuizStatus(int courseID, int quizID, int status) throws NoRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException, AlreadyUpdatedException;
	void updateLectureStatus(int courseID, int lectureID)throws NoRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException, AlreadyUpdatedException;
}
