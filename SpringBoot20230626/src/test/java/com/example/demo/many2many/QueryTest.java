package com.example.demo.many2many;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.many2many.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;

@SpringBootTest
public class QueryTest {
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Test
	public void test() {
		// 每個課程有哪些學生
		List<Course> courses = courseRepository.findAll();
		courses.forEach(course -> {
			System.out.printf("%s => %s\n", course.getName(), course.getStudents());
		});
	}
}
