package com.politecnicograncolombiano.inventario.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.politecnicograncolombiano.inventario.model.Inventario;
import com.politecnicograncolombiano.inventario.model.Producto;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Repository
public class JsonInventarioRepository implements IInventarioRepository {

    private final List<Inventario> inventarios;
    private final List<Producto> productos;

    public JsonInventarioRepository() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try (
                InputStream invStream = getClass().getResourceAsStream("/data/inventario.json");
                InputStream prodStream = getClass().getResourceAsStream("/data/productos.json")
        ) {
        	inventarios = mapper.readValue(invStream, new TypeReference<List<Inventario>>() {});
        	productos   = mapper.readValue(prodStream, new TypeReference<List<Producto>>() {});
        }
        catch (Exception e) {
            throw new RuntimeException("Error cargando archivos JSON", e);
        }
    }

    @Override
    public List<Inventario> listarInventario() {
        return inventarios;
    }

    @Override
    public Optional<Inventario> obtenerInventarioPorProducto(Integer idProducto) {
        return inventarios.stream()
                .filter(i -> i.getIdProducto().equals(idProducto))
                .findFirst();
    }

    @Override
    public List<Producto> listarProductos() {
        return productos;
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(Integer idProducto) {
        return productos.stream()
                .filter(p -> p.getIdProducto().equals(idProducto))
                .findFirst();
    }
}
