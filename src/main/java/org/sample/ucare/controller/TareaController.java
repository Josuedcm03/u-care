package org.sample.ucare.controller;

import org.sample.ucare.dto.TareaDTO;
import org.sample.ucare.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    @GetMapping("/estudiante/{estudianteId}")
    public ResponseEntity<List<TareaDTO>> obtenerTareasPorEstudiante(@PathVariable Long estudianteId) {
        List<TareaDTO> tareas = tareaService.obtenerTareasPorEstudiante(estudianteId);
        return ResponseEntity.ok(tareas);
    }

    @PostMapping("/crear/{estudianteId}")  //
    public ResponseEntity<String> crearTarea(@PathVariable Long estudianteId, @RequestBody TareaDTO tareaDTO) {
        String response = tareaService.crearTarea(estudianteId, tareaDTO); // Pasa el estudianteId al servicio
        return ResponseEntity.ok(response);
    }


}
