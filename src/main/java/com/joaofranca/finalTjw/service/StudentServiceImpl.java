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
    private final StudentRepository personRepository;
    private final StudentMapper personMapper;
    @Override
    public StudentResponseDTO findById(Long id) {
        return personMapper.toStudentDTO(returnStudent(id));
    }
    @Override
    public List<StudentResponseDTO> findAll() {
        return personMapper.toStudentsDTO(personRepository.findAll());
    }
    @Override
    public StudentResponseDTO register(StudentRequestDTO personDTO) {
        Student person = personMapper.toStudent(personDTO);
        return personMapper.toStudentDTO(personRepository.save(person));
    }
    @Override
    public StudentResponseDTO update( long id, StudentRequestDTO personDTO) {
        Student person = returnStudent(id);
        personMapper.updateStudentData(person,personDTO);
        return personMapper.toStudentDTO(personRepository.save(person));
    }
    @Override
    public String delete(long id) {
        personRepository.deleteById(id);
        return "Person id: "+id+" deleted";
    }
    private Student returnStudent(long id){
        return personRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Person wasn't found on database"));
    }
}
