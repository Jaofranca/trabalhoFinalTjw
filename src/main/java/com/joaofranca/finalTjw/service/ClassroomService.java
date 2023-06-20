package com.joaofranca.finalTjw.service;

import com.joaofranca.finalTjw.dto.request.ClassroomRequestDTO;
import com.joaofranca.finalTjw.dto.response.ClassroomResponseDTO;

import java.util.List;

public interface ClassroomService {
    ClassroomResponseDTO findById(Long id);
    List<ClassroomResponseDTO> findAll();
    ClassroomResponseDTO register(ClassroomRequestDTO personDTO);
    ClassroomResponseDTO update(long id,ClassroomRequestDTO personDTO);
    String delete(long id);
}
