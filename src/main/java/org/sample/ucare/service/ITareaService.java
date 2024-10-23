package org.sample.ucare.service;

import org.sample.ucare.dto.TareaDTO;

import java.util.List;

public interface ITareaService {
    String crearTarea(Long estudianteId, TareaDTO tareaDTO);
    List<TareaDTO> obtenerTareasPorEstudiante(Long estudianteId);
}
