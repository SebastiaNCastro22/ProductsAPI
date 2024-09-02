package com.upc.productsapi.street.controller;

import com.upc.productsapi.street.model.dto.request.StreetRequestDto;
import com.upc.productsapi.street.model.dto.response.StreetResponseDto;
import com.upc.productsapi.street.service.IStreetService;
import com.upc.productsapi.shared.dto.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Street")
@RestController
@RequestMapping("/api/v1/street")
public class StreetController {

    private final IStreetService service;

    public StreetController(IStreetService service) {
        this.service = service;
    }

    /**
     * Obtiene todos los productos
     * @return Lista de productos
     */
    @Operation(summary = "Obtiene todas las calles")
    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<StreetResponseDto>>> listStreets() {
        var res = service.getAllStreets();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Operation(summary = "Obtiene una calle por su id")
    @GetMapping("/{streetId}")
    public ResponseEntity<ApiResponse<StreetResponseDto>> getStreetByName(@PathVariable long streetId){
        var res = service.getStreetByStreetId(streetId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    /**
     * Registra un nuevo producto
     * @param street producto a registrar
     * @return Producto registrado
     */

    @Operation(summary = "Registra un nuevo producto (ADMIN)")
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<StreetResponseDto>> registerProduct(@RequestBody StreetRequestDto street) {
            var res = service.registerStreet(street);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    /**
     * Elimina un producto por su ID
     * @param streetId ID del producto
     * @return Respuesta
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')") //solo los administradores pueden acceder a este endpoint
    @Operation(summary = "Elimina un producto por su ID (ADMIN)")
    @DeleteMapping("/delete/{streetId}")
    public ResponseEntity<ApiResponse<Object>> deleteStreet(@PathVariable("streetId") Long streetId) {
        var res = service.deleteStreetById(streetId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }




}
