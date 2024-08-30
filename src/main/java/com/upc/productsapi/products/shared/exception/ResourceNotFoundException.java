package com.upc.productsapi.products.shared.exception;

/**
 * Clase que representa una excepción de recurso no encontrado (404)
 * @author Jamutaq Ortega
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
