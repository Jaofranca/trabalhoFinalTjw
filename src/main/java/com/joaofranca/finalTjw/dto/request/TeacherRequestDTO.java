package com.joaofranca.finalTjw.dto.request;

import com.joaofranca.finalTjw.entity.Classroom;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class TeacherRequestDTO {
    private String name;
    private String cpf;
    private Integer age;
    private List<Classroom> classrooms;
}
