package com.upc.productsapi.complaints.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintsRequestDto {


    @NotBlank(message = "La descripcion de la denuncia no puede estar vacía")
    private String description;

    @Min(value = 1, message = "El Tipo de denuncia tiene que tener al menos 1 numero (1:ROBO, 2:INCIDENETE VEHICULAR, 3:ARNA DE FUEGO, 4:EMERGENCIA")
    private Integer type;

}
