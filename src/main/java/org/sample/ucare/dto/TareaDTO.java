package org.sample.ucare.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class TareaDTO {
    private String descripcion;
    private LocalDateTime fechaVencimiento;
    private Long estudianteId;
}
