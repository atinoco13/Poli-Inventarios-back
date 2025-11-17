package com.politecnicograncolombiano.inventario.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InventarioDTO {

    private Integer idProducto;
    private String nombreProducto;
    private String descripcion;
    private BigDecimal precio;
    private String unidadMedida;
    private Integer stockDisponible;
    private Boolean estadoProducto;

    // Nuevos campos:
    private Integer stockActual;
    private Integer stockReservado;
    private Integer stockMinimo;
    private LocalDateTime fechaActualizacion;

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }

    public Integer getStockDisponible() { return stockDisponible; }
    public void setStockDisponible(Integer stockDisponible) { this.stockDisponible = stockDisponible; }

    public Boolean getEstadoProducto() { return estadoProducto; }
    public void setEstadoProducto(Boolean estadoProducto) { this.estadoProducto = estadoProducto; }

    public Integer getStockActual() { return stockActual; }
    public void setStockActual(Integer stockActual) { this.stockActual = stockActual; }

    public Integer getStockReservado() { return stockReservado; }
    public void setStockReservado(Integer stockReservado) { this.stockReservado = stockReservado; }

    public Integer getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(Integer stockMinimo) { this.stockMinimo = stockMinimo; }

    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }
}
