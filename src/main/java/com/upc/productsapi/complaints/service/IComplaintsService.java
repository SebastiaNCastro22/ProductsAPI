package com.upc.productsapi.complaints.service;

import com.upc.productsapi.shared.dto.response.ApiResponse;
import com.upc.productsapi.complaints.model.dto.request.ComplaintsRequestDto;
import com.upc.productsapi.complaints.model.dto.response.ComplaintsResponseDto;

import java.util.List;

public interface IComplaintsService {

    /**
     * Método que se encarga de registrar una denuncias
     * @param complaintsData datos de lq denuncias a registrar
     * @return ApiResponse con los datos de la denuncia registrada
     */
    ApiResponse<ComplaintsResponseDto> registerComplaints(ComplaintsRequestDto complaintsData);

    /**
     * Método que se encarga de eliminar una denuncias por su id
     */
    ApiResponse<Object> deleteComplaintsById(Long StreetId);

    /**
     * Método que se encarga de obtener una denuncias por su id
     * @return ApiResponse con los datos de la denuncia
     */
    ApiResponse<ComplaintsResponseDto> getComplaintsByComplaintsId(long id);

    /**
     * Método que se encarga de obtener todos las denuncias
     * @return ApiResponse con la lista de denuncias
     */
    ApiResponse<List<ComplaintsResponseDto>> getAllComplaints();

}
