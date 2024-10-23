package org.sample.ucare.service;

import org.sample.ucare.dto.LoginDTO;
import org.sample.ucare.dto.RegistroDTO;
import org.sample.ucare.exception.ResourceNotFoundException;
import org.sample.ucare.model.EstudianteUAM;
import org.sample.ucare.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public String registrar(RegistroDTO registroDTO) {
        if (estudianteRepository.findByEmail(registroDTO.getEmail()).isPresent()) {
            throw new ResourceNotFoundException("El email ya está registrado");
        }

        // Crea un nuevo estudiante con los datos recibidos
        EstudianteUAM estudiante = new EstudianteUAM();
        estudiante.setEmail(registroDTO.getEmail());
        estudiante.setPassword(registroDTO.getPassword()); // se almacena la contraseña sin encriptar (aniadir encriptado)
        estudiante.setNombre(registroDTO.getNombre());

        // se guarda el estudiante en la bd
        estudianteRepository.save(estudiante);

        return "Registro exitoso";
    }

    @Override
    public String login(LoginDTO loginDTO) {
        // Busca el estudiante por email
        EstudianteUAM estudiante = estudianteRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("El usuario no existe"));

        // Compara la contraseña (cambiar cuando se aniada la encriptación)
        if (!loginDTO.getPassword().equals(estudiante.getPassword())) {
            throw new ResourceNotFoundException("Contraseña incorrecta");
        }

        return "Login exitoso";
    }
}
