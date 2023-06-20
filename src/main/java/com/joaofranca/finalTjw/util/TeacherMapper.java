package com.joaofranca.finalTjw.util;

import com.joaofranca.finalTjw.dto.request.StudentRequestDTO;
import com.joaofranca.finalTjw.dto.request.TeacherRequestDTO;
import com.joaofranca.finalTjw.dto.response.StudentResponseDTO;
import com.joaofranca.finalTjw.dto.response.TeacherResponseDTO;
import com.joaofranca.finalTjw.entity.Student;
import com.joaofranca.finalTjw.entity.Teacher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class TeacherMapper {
    public Teacher toTeacher(TeacherRequestDTO teacherDTO){
        return Teacher.builder()
                .name(teacherDTO.getName())
                .cpf(teacherDTO.getCpf())
                .age(teacherDTO.getAge())
                .classrooms(teacherDTO.getClassrooms())
                .build();
    }

    public TeacherResponseDTO toTeacherDTO(Teacher teacher){
        return new TeacherResponseDTO(teacher);
    }

    public List<TeacherResponseDTO> toTeachersDTO(List<Teacher> teacherList){
        return teacherList.stream().map(TeacherResponseDTO::new).collect(Collectors.toList());
    }

    public void updateTeacherData(Teacher teacher, TeacherRequestDTO teacherRequestDTO){
        teacher.setName(teacherRequestDTO.getName());
        teacher.setCpf(teacherRequestDTO.getCpf());
        teacher.setAge(teacherRequestDTO.getAge());

    }
}
