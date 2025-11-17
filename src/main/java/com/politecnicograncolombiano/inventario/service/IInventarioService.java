package com.politecnicograncolombiano.inventario.service;

import com.politecnicograncolombiano.inventario.model.InventarioDTO;

import java.util.List;

public interface IInventarioService {

    List<InventarioDTO> consultarInventario();

    InventarioDTO consultarInventarioPorProducto(Integer idProducto);
}
