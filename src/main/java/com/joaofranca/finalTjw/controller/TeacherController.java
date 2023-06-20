package com.joaofranca.finalTjw.controller;

import com.joaofranca.finalTjw.dto.request.TeacherRequestDTO;
import com.joaofranca.finalTjw.dto.response.TeacherResponseDTO;
import com.joaofranca.finalTjw.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<TeacherResponseDTO> findById(@PathVariable long id){
        return ResponseEntity.ok().body(teacherService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<TeacherResponseDTO>> findAll(){
        return ResponseEntity.ok().body(teacherService.findAll());
    }

    @PostMapping
    public ResponseEntity<TeacherResponseDTO> register(@RequestBody TeacherRequestDTO studentRequestDTO, UriComponentsBuilder uriBuilder){
        TeacherResponseDTO teacherResponseDTO = teacherService.register(studentRequestDTO);

        URI uri = uriBuilder.path("/teachers/{id}").buildAndExpand(teacherResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(teacherResponseDTO);

    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<TeacherResponseDTO> update (@RequestBody TeacherRequestDTO studentDTO,@PathVariable(name = "id") long id){
        return ResponseEntity.ok().body(teacherService.update(id,studentDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") long id){
        return ResponseEntity.ok().body(teacherService.delete(id));
    }
}
