/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.model;

/**
 *
 * @author jbustillos
 */
public class DetalleVenta2 {
    private Integer id_detalle_venta;
    private Integer id_venta;
    private String id_producto;
    private Integer cantidad; 
    private Double precio;  
    private Double valorneto;  
    private Double igv;  
    private Double total;  

    public DetalleVenta2() {
    }

    public DetalleVenta2(Integer id_detalle_venta, Integer id_venta, String id_producto, Integer cantidad, Double precio, Double valorneto, Double igv, Double total) {
        this.id_detalle_venta = id_detalle_venta;
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.valorneto = valorneto;
        this.igv = igv;
        this.total = total;
    }

    public Integer getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(Integer id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getValorneto() {
        return valorneto;
    }

    public void setValorneto(Double valorneto) {
        this.valorneto = valorneto;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }


    
}
