package com.politecnicograncolombiano.inventario.controller;

import com.politecnicograncolombiano.inventario.model.InventarioDTO;
import com.politecnicograncolombiano.inventario.service.IInventarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    private final IInventarioService inventarioService;

    public InventarioController(IInventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping
    public ResponseEntity<List<InventarioDTO>> consultarInventario() {
        return ResponseEntity.ok(inventarioService.consultarInventario());
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<InventarioDTO> consultarInventarioPorProducto(@PathVariable Integer idProducto) {
        return ResponseEntity.ok(inventarioService.consultarInventarioPorProducto(idProducto));
    }
}
