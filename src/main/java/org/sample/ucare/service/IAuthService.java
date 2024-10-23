package org.sample.ucare.service;

import org.sample.ucare.dto.LoginDTO;
import org.sample.ucare.dto.RegistroDTO;

public interface IAuthService {
    String registrar(RegistroDTO registroDTO);
    String login(LoginDTO loginDTO);
}
