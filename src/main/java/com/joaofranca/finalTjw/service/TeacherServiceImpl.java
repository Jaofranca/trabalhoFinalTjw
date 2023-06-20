package com.joaofranca.finalTjw.service;

import com.joaofranca.finalTjw.dto.request.TeacherRequestDTO;
import com.joaofranca.finalTjw.dto.response.StudentResponseDTO;
import com.joaofranca.finalTjw.dto.response.TeacherResponseDTO;
import com.joaofranca.finalTjw.entity.Teacher;
import com.joaofranca.finalTjw.repository.TeacherRepository;
import com.joaofranca.finalTjw.util.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    @Override
    public TeacherResponseDTO findById(Long id) {
        return teacherMapper.toTeacherDTO(returnTeacher(id));
    }

    @Override
    public List<TeacherResponseDTO> findAll() {
        return teacherMapper.toTeachersDTO(teacherRepository.findAll());
    }

    @Override
    public TeacherResponseDTO register(TeacherRequestDTO teacherDTO) {
        Teacher teacher = teacherMapper.toTeacher(teacherDTO);
        return teacherMapper.toTeacherDTO(teacherRepository.save(teacher));
    }

    @Override
    public TeacherResponseDTO update( long id, TeacherRequestDTO teacherDTO) {
        Teacher teacher = returnTeacher(id);
        teacherMapper.updateTeacherData(teacher,teacherDTO);
        return teacherMapper.toTeacherDTO(teacherRepository.save(teacher));
    }

    @Override
    public String delete(long id) {
        teacherRepository.deleteById(id);
        return "Person id: "+id+" deleted";
    }

    private Teacher returnTeacher(long id){
        return teacherRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Person wasn't found on database"));

    }
}
