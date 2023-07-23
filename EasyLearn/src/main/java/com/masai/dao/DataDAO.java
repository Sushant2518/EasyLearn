package com.masai.dao;

import java.util.List;
import java.util.Set;

import com.masai.entity.Assignment;
import com.masai.entity.Course;
import com.masai.entity.Lecture;
import com.masai.entity.Quiz;
import com.masai.entity.Student;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface DataDAO {
	List<Student> showStudents() throws SomethingWentWrongException, NoRecordFoundException;
	List<Course> showCourses() throws SomethingWentWrongException, NoRecordFoundException;
	void addAssignment(int courseId, Assignment assignment) throws SomethingWentWrongException, NoRecordFoundException;
	void addQuiz(int courseId, Quiz quiz) throws SomethingWentWrongException, NoRecordFoundException;
	void addLecture(int courseId, Lecture lecture) throws SomethingWentWrongException, NoRecordFoundException;
	Set<Lecture> seeAllLecturesByCourseID(int courseID) throws SomethingWentWrongException, NoRecordFoundException;
	Set<Assignment> seeAllAssignmentsByCourseID(int courseID)throws SomethingWentWrongException, NoRecordFoundException;
	Set<Quiz> seeAllQuizzesByCourseID(int courseID)throws SomethingWentWrongException, NoRecordFoundException;
	void deleteLectureByLectureID(int courseID, int lectureID)throws SomethingWentWrongException, NoRecordFoundException;
	void deleteAssignmentByAssignmentID(int courseID, int assignmentID)throws SomethingWentWrongException, NoRecordFoundException;
	void deleteQuizByQuizID(int courseID, int quizID)throws SomethingWentWrongException, NoRecordFoundException;
}
