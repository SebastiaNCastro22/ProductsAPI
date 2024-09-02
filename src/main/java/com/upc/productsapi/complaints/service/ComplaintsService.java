package com.upc.productsapi.complaints.service;

import com.upc.productsapi.complaints.respository.IComplaintsRepository;
import com.upc.productsapi.shared.dto.enums.EStatus;
import com.upc.productsapi.shared.dto.response.ApiResponse;
import com.upc.productsapi.complaints.model.dto.request.ComplaintsRequestDto;
import com.upc.productsapi.complaints.model.dto.response.ComplaintsResponseDto;
import com.upc.productsapi.complaints.model.entity.Complaints;
import com.upc.productsapi.shared.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintsService implements IComplaintsService{


    private final IComplaintsRepository complaintsRepository;
    private final ModelMapper modelMapper;

    public ComplaintsService(IComplaintsRepository complaintsRepository, ModelMapper modelMapper) {
        this.complaintsRepository = complaintsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse<ComplaintsResponseDto> registerComplaints(ComplaintsRequestDto streetData) {
        //dto a entity
        var complaints = modelMapper.map(streetData, Complaints.class);

        //crear el producto
        var complaintsSaved = complaintsRepository.save(complaints);

        //entity a dto
        var complaintsResponse = modelMapper.map(complaintsSaved, ComplaintsResponseDto.class);

        //retornar la respuesta
        return new ApiResponse<>("Calle registrada correctamente", EStatus.SUCCESS, complaintsResponse);
    }

    @Override
    public ApiResponse<Object> deleteComplaintsById(Long complaintsId) {
        //buscar el producto a eliminar
        var street = complaintsRepository.findById(complaintsId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el producto con el id: " + complaintsId));

        //eliminar el producto
        complaintsRepository.delete(street);

        //retornar la respuesta
        return new ApiResponse<>("Producto eliminado correctamente", EStatus.SUCCESS, null);
    }

    @Override
    public ApiResponse<ComplaintsResponseDto> getComplaintsByComplaintsId(long complaintsId) {
        //buscar el producto
        var complaints = complaintsRepository.findByComplaintsId(complaintsId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el producto con el nombre: " + complaintsId));

        //entity a dto
        var complaintsResponse = modelMapper.map(complaints, ComplaintsResponseDto.class);

        //retornar la respuesta
        return new ApiResponse<>("Ok", EStatus.SUCCESS, complaintsResponse);
    }

    @Override
    public ApiResponse<List<ComplaintsResponseDto>> getAllComplaints() {

        var complaintss = complaintsRepository.findAll();

        var complaintsResponse = complaintss.stream()
                .map(complaints -> modelMapper.map(complaints, ComplaintsResponseDto.class))
                .toList();

        return new ApiResponse<>("Ok", EStatus.SUCCESS, complaintsResponse);
    }

}

