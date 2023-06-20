package com.joaofranca.finalTjw.service;

import com.joaofranca.finalTjw.dto.request.ClassroomRequestDTO;
import com.joaofranca.finalTjw.dto.response.ClassroomResponseDTO;
import com.joaofranca.finalTjw.entity.Classroom;
import com.joaofranca.finalTjw.repository.ClassroomRepository;
import com.joaofranca.finalTjw.util.ClassroomMapper;
import com.joaofranca.finalTjw.util.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class ClassroomServiceImpl implements ClassroomService{
    private final ClassroomRepository classroomRepository;
    private final ClassroomMapper classroomMapper;
    @Override
    public ClassroomResponseDTO findById(Long id) {
        return classroomMapper.toClassroomDTO(returnClassroom(id));
    }

    @Override
    public List<ClassroomResponseDTO> findAll() {
        return classroomMapper.toClassroomsDTO(classroomRepository.findAll());
    }
    @Override
    public ClassroomResponseDTO register(ClassroomRequestDTO classroomDTO) {
        Classroom classroom = classroomMapper.toClassroom(classroomDTO);
        return classroomMapper.toClassroomDTO(classroomRepository.save(classroom));
    }

    @Override
    public ClassroomResponseDTO update( long id, ClassroomRequestDTO classroomDTO) {
        Classroom classroom = returnClassroom(id);
        classroomMapper.updateClassroomData(classroom,classroomDTO);
        return classroomMapper.toClassroomDTO(classroomRepository.save(classroom));
    }

    @Override
    public String delete(long id) {
        classroomRepository.deleteById(id);
        return "Person id: "+id+" deleted";
    }

    private Classroom returnClassroom(long id){
        return classroomRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Person wasn't found on database"));
    }
}