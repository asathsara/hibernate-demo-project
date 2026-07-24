package main;

import java.util.List;

import dao.IStudentDao;
import dao.StudentDao;
import model.Student;

public class App {

	public static void main(String[] args) {

		IStudentDao studentDao = new StudentDao();
		// test saveStudent
		Student student = new Student("Ramesh", "Gupta", "ramesh@gmail.com");
		studentDao.saveStudent(student);

		// test updateStudent
		student.setFirstName("Ram");
		studentDao.updateStudent(student);

		// test getStudentById
		Student student2 = studentDao.getStudentById(student.getId());

		// test getAllStudents
		List<Student> students = studentDao.getAllStudents();
		students.forEach(student1 -> System.out.println(student1.getId()));

		// test deleteStudent
		studentDao.deleteStudent(student.getId());

	}

}
