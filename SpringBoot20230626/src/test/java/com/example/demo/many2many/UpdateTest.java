package com.example.demo.many2many;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.many2many.Course;
import com.example.demo.entity.many2many.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;

@SpringBootTest
public class UpdateTest {
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Test
	public void test() {
		// "Englidh" 課程多增加 "John"
		Course englishCourse = courseRepository.findById(3L).get();
		Student john = studentRepository.findById(1L).get();
		// 配置關聯
		englishCourse.getStudents().add(john);
		// 儲存課程
		courseRepository.save(englishCourse);
		
		System.out.println("OK");
		
	}
}
