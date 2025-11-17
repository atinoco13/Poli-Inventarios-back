package com.politecnicograncolombiano.inventario.repository;

import com.politecnicograncolombiano.inventario.model.Inventario;
import com.politecnicograncolombiano.inventario.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IInventarioRepository {

    List<Inventario> listarInventario();

    Optional<Inventario> obtenerInventarioPorProducto(Integer idProducto);

    List<Producto> listarProductos();

    Optional<Producto> obtenerProductoPorId(Integer idProducto);
}
