package com.joaofranca.finalTjw.service;

import com.joaofranca.finalTjw.dto.request.StudentRequestDTO;
import com.joaofranca.finalTjw.dto.response.StudentResponseDTO;
import com.joaofranca.finalTjw.entity.Student;
import com.joaofranca.finalTjw.repository.StudentRepository;
import com.joaofranca.finalTjw.util.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    @Override
    public StudentResponseDTO findById(Long id) {
        return studentMapper.toStudentDTO(returnStudent(id));
    }
    @Override
    public List<StudentResponseDTO> findAll() {
        return studentMapper.toStudentsDTO(studentRepository.findAll());
    }
    @Override
    public StudentResponseDTO register(StudentRequestDTO studentDTO) {
        Student person = studentMapper.toStudent(studentDTO);
        return studentMapper.toStudentDTO(studentRepository.save(person));
    }
    @Override
    public StudentResponseDTO update( long id, StudentRequestDTO studentDTO) {
        Student person = returnStudent(id);
        studentMapper.updateStudentData(person,studentDTO);
        return studentMapper.toStudentDTO(studentRepository.save(person));
    }
    @Override
    public String delete(long id) {
        studentRepository.deleteById(id);
        return "Person id: "+id+" deleted";
    }
    private Student returnStudent(long id){
        return studentRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Person wasn't found on database"));
    }
}
