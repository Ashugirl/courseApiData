package be.intecbrussel.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId){
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId)
        .forEach(courses::add);
        System.out.println("hey");
        return courses;
    }

    public Course getCourse(String id){
      return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course course){
        courseRepository.save(course);
        System.out.println("I'm here");

    }

    public void updateCourse(Course course) {
        courseRepository.save(course);

    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
