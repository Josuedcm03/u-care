package org.sample.ucare.controller;

import org.sample.ucare.dto.LoginDTO;
import org.sample.ucare.dto.RegistroDTO;
import org.sample.ucare.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/registro")
    public ResponseEntity<String> registrar(@RequestBody RegistroDTO registroDTO) {
        String respuesta = authService.registrar(registroDTO);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        String respuesta = authService.login(loginDTO);
        return ResponseEntity.ok(respuesta);
    }

}
