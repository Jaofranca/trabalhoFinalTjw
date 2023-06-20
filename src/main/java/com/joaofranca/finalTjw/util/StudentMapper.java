package com.joaofranca.finalTjw.util;

import com.joaofranca.finalTjw.dto.request.StudentRequestDTO;
import com.joaofranca.finalTjw.dto.response.StudentResponseDTO;
import com.joaofranca.finalTjw.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class StudentMapper {
    public Student toStudent(StudentRequestDTO studentDTO){
        return Student.builder()
                .name(studentDTO.getName())
                .cpf(studentDTO.getCpf())
                .age(studentDTO.getAge())
                .classrooms(studentDTO.getClassrooms())
                .build();
    }

    public StudentResponseDTO toStudentDTO(Student person){
        return new StudentResponseDTO(person);
    }

    public List<StudentResponseDTO> toStudentsDTO(List<Student> studentList){
        return studentList.stream().map(StudentResponseDTO::new).collect(Collectors.toList());
    }

    public void updateStudentData(Student student, StudentRequestDTO studentRequestDTO){
        student.setName(studentRequestDTO.getName());
        student.setCpf(studentRequestDTO.getCpf());
        student.setAge(studentRequestDTO.getAge());

    }
}
