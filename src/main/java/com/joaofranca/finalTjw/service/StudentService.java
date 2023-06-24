package com.joaofranca.finalTjw.service;

import com.joaofranca.finalTjw.dto.request.StudentRequestDTO;
import com.joaofranca.finalTjw.dto.response.StudentResponseDTO;

import java.util.List;

public interface StudentService {

    StudentResponseDTO findById(Long id);
    List<StudentResponseDTO> findAll();
    StudentResponseDTO register(StudentRequestDTO studentDTO);
    StudentResponseDTO update(long id,StudentRequestDTO personDTO);
    String delete(long id);
}
