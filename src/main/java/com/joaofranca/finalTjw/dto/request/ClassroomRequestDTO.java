package com.joaofranca.finalTjw.dto.request;

import com.joaofranca.finalTjw.entity.Student;
import com.joaofranca.finalTjw.entity.Teacher;
import lombok.Getter;

import java.util.List;
@Getter
public class ClassroomRequestDTO {
    private String name;
    private Teacher teacher;
    private List<Student> students;

}
