package com.upc.productsapi.snapshots.service;


import com.upc.productsapi.products.shared.dto.response.ApiResponse;
import com.upc.productsapi.snapshots.model.dto.request.SnapShotsRequestDto;
import com.upc.productsapi.snapshots.model.dto.response.SnapShotsResponseDto;

public interface ISnapShotsService {

    ApiResponse<SnapShotsResponseDto> registerSnapshot(Long productId, SnapShotsRequestDto snapshotsData);

    /**
     * Método que se encarga de eliminar un producto por su id
     */
    ApiResponse<Object> deleteSnapShotsById(Long id);

    /**
     * Método que se encarga de obtener un producto por su nombre
     * @return ApiResponse con los datos del producto
     */
    ApiResponse<SnapShotsResponseDto> getSnapshotsByProductSerialNumber(String productSerialNumber);



}
