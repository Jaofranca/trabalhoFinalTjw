package com.joaofranca.finalTjw.controller;

import com.joaofranca.finalTjw.dto.request.StudentRequestDTO;
import com.joaofranca.finalTjw.dto.response.StudentResponseDTO;
import com.joaofranca.finalTjw.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentResponseDTO> findById(@PathVariable long id){
        return ResponseEntity.ok().body(studentService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> findAll(){
        return ResponseEntity.ok().body(studentService.findAll());
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> register(@RequestBody StudentRequestDTO studentRequestDTO, UriComponentsBuilder uriBuilder){
        StudentResponseDTO studentResponseDTO = studentService.register(studentRequestDTO);

        URI uri = uriBuilder.path("/students/{id}").buildAndExpand(studentResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(studentResponseDTO);

    }

    @PostMapping()
    @PutMapping(value = "/{id}")
    public ResponseEntity<StudentResponseDTO> update (@RequestBody StudentRequestDTO studentDTO,@PathVariable(name = "id") long id){
        return ResponseEntity.ok().body(studentService.update(id,studentDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") long id){
        return ResponseEntity.ok().body(studentService.delete(id));
    }
}