package com.upc.productsapi.complaints.model.dto.response;

import com.upc.productsapi.complaints.model.dto.enums.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintsResponseDto {


    private Long complaintsId;
    private String description;
    private Type type;
}
