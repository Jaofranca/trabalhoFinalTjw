package com.joaofranca.finalTjw.dto.response;

import com.joaofranca.finalTjw.entity.Classroom;
import com.joaofranca.finalTjw.entity.Student;
import lombok.Getter;

import java.util.List;

@Getter
public class StudentResponseDTO {
    private Long id;
    private String name;
    private String cpf;
    private Integer age;
    private List<Classroom> classrooms;

    public StudentResponseDTO(Student student){
        this.id = student.getId();
        this.name = student.getName();
        this.cpf = student.getCpf();
        this.age = student.getAge();
        this.classrooms = student.getClassrooms();

    }
}
