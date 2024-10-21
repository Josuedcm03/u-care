package org.sample.ucare.controller;

import org.sample.ucare.dto.EstudianteDTO;
import org.sample.ucare.service.IServiceEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private IServiceEstudiante serviceEstudiante;

    @PostMapping("/register")
    public ResponseEntity<EstudianteDTO> registerEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        EstudianteDTO registrado = serviceEstudiante.register(estudianteDTO);
        return new ResponseEntity<>(registrado, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<EstudianteDTO> authenticateEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        EstudianteDTO authenticated = serviceEstudiante.authenticate(estudianteDTO.getCif(), estudianteDTO.getPass());
        return new ResponseEntity<>(authenticated, HttpStatus.OK);
    }

}
