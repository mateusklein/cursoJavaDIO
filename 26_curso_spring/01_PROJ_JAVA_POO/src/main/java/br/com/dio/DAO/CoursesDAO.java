package br.com.dio.DAO;

import br.com.dio.Model.Courses;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CoursesDAO {
    private List<Courses> courses = new ArrayList<>();

    public List<Courses> insertCourse(Courses course) {
        this.courses.add(course);
        return courses;
    }


}
