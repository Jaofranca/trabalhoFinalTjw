package com.joaofranca.finalTjw.dto.response;

import com.joaofranca.finalTjw.entity.Classroom;
import com.joaofranca.finalTjw.entity.Teacher;
import lombok.Getter;

import java.util.List;
@Getter
public class TeacherResponseDTO {
    private Long id;
    private String name;
    private String cpf;
    private Integer age;
    private List<Classroom> classrooms;

    public TeacherResponseDTO(Teacher teacher){
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.cpf = teacher.getCpf();
        this.age = teacher.getAge();
        this.classrooms = teacher.getClassrooms();

    }
}
