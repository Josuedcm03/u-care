package org.sample.ucare.service;


import org.sample.ucare.dto.EstudianteDTO;
import org.sample.ucare.exception.ResourceNotFoundException;
import org.sample.ucare.model.Estudiante;
import org.sample.ucare.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceEstudiante implements IServiceEstudiante {
    @Autowired
    private EstudianteRepository estudianteRepository;


    @Override
    public EstudianteDTO register(EstudianteDTO estudianteDTO) {
        return save(estudianteDTO);
    }

    @Override
    public EstudianteDTO authenticate(String cif, String contrasena) {
        return estudianteRepository.findByCifAndContrasena(cif, contrasena)
                .map(this::convertToDto)
                .orElseThrow();
    }

    private EstudianteDTO convertToDto(Estudiante estudiante) {
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        estudianteDTO.setId(estudiante.getId());
        estudianteDTO.setNombre(estudiante.getNombre());
        estudianteDTO.setCif(estudiante.getCif());
        estudianteDTO.setEmail(estudiante.getEmail());
        estudianteDTO.setPass(estudiante.getPass());
        return estudianteDTO;
    }

    @Override
    public EstudianteDTO save(EstudianteDTO estudianteDTO) {
        if (!estudianteDTO.getPass().equals(estudianteDTO.getConfirmPass())) {
            throw new IllegalArgumentException("Las contraseñas no coinciden");
        }


        Estudiante estudiante = convertToEntity(estudianteDTO);
        Estudiante savedEstudiante = estudianteRepository.save(estudiante);
        return convertToDto(savedEstudiante);
    }
    private Estudiante convertToEntity(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = new Estudiante();
        estudiante.setId(estudianteDTO.getId());
        estudiante.setNombre(estudianteDTO.getNombre());
        estudiante.setCif(estudianteDTO.getCif());
        estudiante.setEmail(estudianteDTO.getEmail());
        estudiante.setPass(estudianteDTO.getPass());
        return estudiante;
    }


}
