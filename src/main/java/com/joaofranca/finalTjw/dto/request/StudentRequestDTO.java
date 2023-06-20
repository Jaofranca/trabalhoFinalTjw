package com.joaofranca.finalTjw.dto.request;

import com.joaofranca.finalTjw.entity.Classroom;
import lombok.Getter;

import java.util.List;

@Getter
public class StudentRequestDTO {
    private String name;
    private String cpf;
    private Integer age;
    private List<Classroom> classrooms;
}
