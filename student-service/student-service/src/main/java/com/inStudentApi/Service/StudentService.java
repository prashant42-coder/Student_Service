package com.inStudentApi.Service;

import org.springframework.stereotype.Service;

import com.inStudentApi.model.Course;
import com.inStudentApi.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class StudentService {

    private static List<Student> students = new ArrayList<>();

    static {
        Course course1 = new Course("Course1", "Spring", "10 Steps", 
            Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));
        Course course2 = new Course("Course2", "Java", "15 Steps", 
            Arrays.asList("Learn Basics", "OOP Concepts", "Data Structures"));
            Course course3 = new Course("Course3", "Spring", "10 Steps", 
            Arrays.asList("Learn Docker", "Import Project", "First Example", "Second Example"));
        Course course4 = new Course("Course4", "Java in advance", "15 Steps", 
            Arrays.asList("Learn java Advance", "OOP Concepts", "DataBase Connection"));


        students.add(new Student("Student1", "John Doe", Arrays.asList(course1, course2,course3,course4)));
    }

    public List<Student> retrieveAllStudents() {
        return students;
    }

    public Student retrieveStudent(String studentId) {
        return students.stream()
                .filter(student -> student.getId().equalsIgnoreCase(studentId))
                .findFirst()
                .orElse(null);
    }

    public List<Course> retrieveCourses(String studentId) {
        Student student = retrieveStudent(studentId);
        return student != null ? student.getCourses() : null;
    }

    public Course retrieveCourse(String studentId, String courseId) {
        List<Course> courses = retrieveCourses(studentId);
        if (courses == null) return null;
        return courses.stream()
                .filter(course -> course.getId().equalsIgnoreCase(courseId))
                .findFirst()
                .orElse(null);
    }

    public Course addCourse(String studentId, Course course) {
        Student student = retrieveStudent(studentId);
        if (student == null) return null;
        student.getCourses().add(course);
        return course;
    }
}