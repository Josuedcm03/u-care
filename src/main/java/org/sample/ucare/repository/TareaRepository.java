package org.sample.ucare.repository;

import org.sample.ucare.model.EstudianteUAM;
import org.sample.ucare.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByEstudiante(EstudianteUAM estudiante);
}
