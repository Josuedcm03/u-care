package org.sample.ucare.repository;

import org.sample.ucare.model.EstudianteUAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteUAM, Long> {
    Optional<EstudianteUAM> findByEmail(String email);
}
