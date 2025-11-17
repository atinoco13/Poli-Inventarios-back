package com.politecnicograncolombiano.inventario.service;

import com.politecnicograncolombiano.inventario.model.Inventario;
import com.politecnicograncolombiano.inventario.model.InventarioDTO;
import com.politecnicograncolombiano.inventario.model.Producto;
import com.politecnicograncolombiano.inventario.repository.IInventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class InventarioServiceImpl implements IInventarioService {

    private final IInventarioRepository inventarioRepo;

    public InventarioServiceImpl(IInventarioRepository inventarioRepo) {
        this.inventarioRepo = inventarioRepo;
    }

    @Override
    public List<InventarioDTO> consultarInventario() {
        return inventarioRepo.listarInventario()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public InventarioDTO consultarInventarioPorProducto(Integer idProducto) {
        Inventario inv = inventarioRepo.obtenerInventarioPorProducto(idProducto)
                .orElseThrow(() -> new NoSuchElementException("Inventario no encontrado: " + idProducto));

        return mapToDto(inv);
    }

    private InventarioDTO mapToDto(Inventario inventario) {
        Producto producto = inventarioRepo.obtenerProductoPorId(inventario.getIdProducto())
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado: " + inventario.getIdProducto()));

        InventarioDTO dto = new InventarioDTO();
        dto.setIdProducto(producto.getIdProducto());
        dto.setNombreProducto(producto.getNombreProducto());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        dto.setUnidadMedida(producto.getUnidadMedida());
        dto.setStockDisponible(inventario.getStockDisponible());
        dto.setEstadoProducto(producto.getEstado());
        
        dto.setStockDisponible(inventario.getStockDisponible());
        dto.setStockActual(inventario.getStockActual());
        dto.setStockReservado(inventario.getStockReservado());
        dto.setStockMinimo(inventario.getStockMinimo());
        dto.setFechaActualizacion(inventario.getFechaActualizacion());

        return dto;
    }

}
