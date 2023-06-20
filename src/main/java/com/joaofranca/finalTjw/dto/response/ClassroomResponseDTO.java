package com.joaofranca.finalTjw.dto.response;

import com.joaofranca.finalTjw.entity.Classroom;
import com.joaofranca.finalTjw.entity.Student;
import com.joaofranca.finalTjw.entity.Teacher;
import lombok.Getter;

import java.util.List;
@Getter
public class ClassroomResponseDTO {
    private long id;
    private String name;
    private Teacher teacher;
    private List<Student> students;

    public ClassroomResponseDTO(Classroom classroom){
        this.id = classroom.getId();
        this.name = classroom.getName();
        this.teacher = classroom.getTeacher();
        this.students = classroom.getStudents();

    }
}
