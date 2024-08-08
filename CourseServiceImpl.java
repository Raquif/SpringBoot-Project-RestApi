package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;
@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course>list;
	
	public CourseServiceImpl()throws Exception {
		list= new ArrayList<>();
		list.add(new Course(12,"Python Courses ","this cousrse contain is Python Basic"));
		list.add(new Course(145, "Java core course", "this cousrse is java Fundamental"));
		list.add(new Course(4353, "React Js ", "this cousrse is for React JS"));
	}

	@Override
	public List<Course> getCourses() {
		
		return list;
	}

	@Override
	public Course getCoursesById(long courseId) {
		Course c= null;
		for(Course course:list)
		{
			if(course.getId()==courseId)	
		{
			c=course;
			break;
		}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {

        list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		list.forEach(e->{
			if(e.getId()==course.getId())
			{
			e.setTitle(course.getTitle());
			e.setDescription(course.getDescription());
		}
		});
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
	}

}
