package com.joaofranca.finalTjw.util;

import com.joaofranca.finalTjw.dto.request.ClassroomRequestDTO;
import com.joaofranca.finalTjw.dto.response.ClassroomResponseDTO;
import com.joaofranca.finalTjw.entity.Classroom;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClassroomMapper {
    public Classroom toClassroom(ClassroomRequestDTO classroomDTO){
        return Classroom.builder()
                .name(classroomDTO.getName())
                .teacher(classroomDTO.getTeacher())
                .students(classroomDTO.getStudents())
                .build();
    }

    public ClassroomResponseDTO toClassroomDTO(Classroom person){
        return new ClassroomResponseDTO(person);
    }

    public List<ClassroomResponseDTO> toClassroomsDTO(List<Classroom> ClassroomList){
        return ClassroomList.stream().map(ClassroomResponseDTO::new).collect(Collectors.toList());
    }

    public void updateClassroomData(Classroom student, ClassroomRequestDTO classroomRequestDTO){
        student.setName(classroomRequestDTO.getName());
        student.setTeacher(classroomRequestDTO.getTeacher());
        student.setStudents(classroomRequestDTO.getStudents());

    }
}