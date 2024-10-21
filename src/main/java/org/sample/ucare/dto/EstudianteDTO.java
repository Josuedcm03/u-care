package org.sample.ucare.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstudianteDTO {
    private int id;
    private String nombre;
    private String cif;
    private String email;
    private String pass;
    private String confirmPass;
}
