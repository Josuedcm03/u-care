package org.sample.ucare.service;

import org.sample.ucare.dto.EstudianteDTO;

public interface IServiceEstudiante {
    EstudianteDTO register(EstudianteDTO estudianteDTO);
    EstudianteDTO authenticate(String cif, String pass);
    EstudianteDTO save(EstudianteDTO estudianteDTO);
}
