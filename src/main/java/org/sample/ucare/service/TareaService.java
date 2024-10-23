package org.sample.ucare.service;

import org.sample.ucare.dto.TareaDTO;
import org.sample.ucare.exception.ResourceNotFoundException;
import org.sample.ucare.model.EstudianteUAM;
import org.sample.ucare.model.Tarea;
import org.sample.ucare.repository.EstudianteRepository;
import org.sample.ucare.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaService implements ITareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public String crearTarea(Long estudianteId, TareaDTO tareaDTO) {
        EstudianteUAM estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado"));

        Tarea tarea = new Tarea();
        tarea.setDescripcion(tareaDTO.getDescripcion());
        tarea.setFechaVencimiento(tareaDTO.getFechaVencimiento());
        tarea.setEstudiante(estudiante);

        tareaRepository.save(tarea);

        return "Tarea creada exitosamente";
    }

    @Override
    public List<TareaDTO> obtenerTareasPorEstudiante(Long estudianteId) {
        EstudianteUAM estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado"));

        // Obtener la lista de tareas del estudiante
        List<Tarea> tareas = tareaRepository.findByEstudiante(estudiante); // Asegúrate de tener este método en TareaRepository

        return tareas.stream().map(tarea -> {
            TareaDTO tareaDTO = new TareaDTO();
            tareaDTO.setDescripcion(tarea.getDescripcion());
            tareaDTO.setFechaVencimiento(tarea.getFechaVencimiento());
            return tareaDTO;
        }).collect(Collectors.toList());
    }
}
