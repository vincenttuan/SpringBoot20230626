package com.example.demo.many2many;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.many2many.Course;
import com.example.demo.entity.many2many.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;

@SpringBootTest
public class CreateTest {
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Test
	public void test() {
		Course javaCourse = new Course("Java");
		Course mathCourse = new Course("Math");
		Course englishCourse = new Course("English");
		Student john = new Student("John");
		Student mary = new Student("Mary");
		Student helen = new Student("Helen");
		
		// 設置關聯關係
		// 由 Course 來維護與 student 的關聯關係
		javaCourse.getStudents().add(john);
		javaCourse.getStudents().add(mary);
		javaCourse.getStudents().add(helen);
		mathCourse.getStudents().add(john);
		mathCourse.getStudents().add(helen);
		englishCourse.getStudents().add(mary);
		
		// 執行保存
		studentRepository.save(john);
		studentRepository.save(mary);
		studentRepository.save(helen);
		courseRepository.save(javaCourse);
		courseRepository.save(mathCourse);
		courseRepository.save(englishCourse);
		
		System.out.println("OK");
	}
}
