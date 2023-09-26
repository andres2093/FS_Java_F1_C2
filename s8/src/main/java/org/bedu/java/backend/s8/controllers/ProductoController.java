package org.bedu.java.backend.s8.controllers;

import org.bedu.java.backend.s8.models.Productos;
import org.bedu.java.backend.s8.persistence.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @PostMapping
    public ResponseEntity<Void> creaProducto(@RequestBody Productos productos){
        Productos productoDB = productoRepository.save(productos);
        return ResponseEntity.created(URI.create(String.valueOf(productoDB.getId()))).build();
    }

    @GetMapping("/{productoId}")
    public ResponseEntity<Productos> getProducto(@PathVariable Long productoId){
        Optional<Productos> productoDB = productoRepository.findById(productoId);
        if (productoDB.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El producto no existe!");
        }
        return ResponseEntity.ok(productoDB.get());
    }
}
