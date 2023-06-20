package com.joaofranca.finalTjw.dto.request;

import com.joaofranca.finalTjw.entity.Classroom;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.List;
@Getter
public class TeacherRequestDTO {
    private String name;
    private String cpf;
    private Integer age;
    private List<Classroom> classrooms;
}
