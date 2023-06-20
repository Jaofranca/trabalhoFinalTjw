package com.joaofranca.finalTjw.service;

import com.joaofranca.finalTjw.dto.request.StudentRequestDTO;
import com.joaofranca.finalTjw.dto.request.TeacherRequestDTO;
import com.joaofranca.finalTjw.dto.response.StudentResponseDTO;
import com.joaofranca.finalTjw.dto.response.TeacherResponseDTO;

import java.util.List;

public interface TeacherService {
    TeacherResponseDTO findById(Long id);
    List<TeacherResponseDTO> findAll();
    TeacherResponseDTO register(TeacherRequestDTO teacherDTO);
    TeacherResponseDTO update(long id, TeacherRequestDTO teacherDTO);
    String delete(long id);
}
