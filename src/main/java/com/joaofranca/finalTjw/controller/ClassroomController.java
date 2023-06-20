package com.joaofranca.finalTjw.controller;


import com.joaofranca.finalTjw.dto.request.ClassroomRequestDTO;
import com.joaofranca.finalTjw.dto.response.ClassroomResponseDTO;
import com.joaofranca.finalTjw.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/classrooms")
@RequiredArgsConstructor
public class ClassroomController {
    private final ClassroomService classroomService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClassroomResponseDTO> findById(@PathVariable long id){
        return ResponseEntity.ok().body(classroomService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClassroomResponseDTO>> findAll(){
        return ResponseEntity.ok().body(classroomService.findAll());
    }

    @PostMapping
    public ResponseEntity<ClassroomResponseDTO> register(@RequestBody ClassroomRequestDTO classroomRequestDTO, UriComponentsBuilder uriBuilder){
        ClassroomResponseDTO classroomResponseDTO = classroomService.register(classroomRequestDTO);

        URI uri = uriBuilder.path("/classrooms/{id}").buildAndExpand(classroomResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(classroomResponseDTO);

    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClassroomResponseDTO> update (@RequestBody ClassroomRequestDTO classroomDTO,@PathVariable(name = "id") long id){
        return ResponseEntity.ok().body(classroomService.update(id,classroomDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") long id){
        return ResponseEntity.ok().body(classroomService.delete(id));
    }
}