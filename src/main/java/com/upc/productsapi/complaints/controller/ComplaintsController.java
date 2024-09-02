package com.upc.productsapi.complaints.controller;

import com.upc.productsapi.shared.dto.response.ApiResponse;
import com.upc.productsapi.complaints.model.dto.request.ComplaintsRequestDto;
import com.upc.productsapi.complaints.model.dto.response.ComplaintsResponseDto;
import com.upc.productsapi.complaints.service.IComplaintsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Tag(name = "Complaints")
@RestController
@RequestMapping("/api/v1/complaints")
public class ComplaintsController {


    private final IComplaintsService service;

    public ComplaintsController(IComplaintsService service) {
        this.service = service;
    }

    /**
     * Obtiene todos las denuncias
     * @return Lista de las denuncias
     */
    @Operation(summary = "Obtiene todas las denuncias")
    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<ComplaintsResponseDto>>> listComplaints() {
        var res = service.getAllComplaints();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Operation(summary = "Obtiene una denuncia por su id")
    @GetMapping("/{complaintsId}")
    public ResponseEntity<ApiResponse<ComplaintsResponseDto>> getComplaintsByName(@PathVariable long complaintsId){
        var res = service.getComplaintsByComplaintsId(complaintsId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    /**
     * Registra una nueva denuncia
     * @param street Denuncia a registrar
     * @return Denuncia registrada
     */

    @Operation(summary = "Registra una nueva denuncia")
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ComplaintsResponseDto>> registerComplaints(@RequestBody ComplaintsRequestDto complaints) {
        var res = service.registerComplaints(complaints);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    /**
     * Elimina una denuncia por su ID
     * @param complaintsId ID de la denuncia
     * @return Respuesta
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')") //solo los administradores pueden acceder a este endpoint
    @Operation(summary = "Elimina una denuncias por su ID (ADMIN)")
    @DeleteMapping("/delete/{complaintsId}")
    public ResponseEntity<ApiResponse<Object>> deleteComplaints(@PathVariable("complaintsId") Long complaintsId) {
        var res = service.deleteComplaintsById(complaintsId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
