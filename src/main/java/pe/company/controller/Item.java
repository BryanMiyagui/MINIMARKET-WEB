/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.controller;

public class Item 
{
    private String id_producto;
    private String producto;
    private Double precio;
    private Integer cantidad;    

    public Item() {
    }

    public Item(String id_producto, String producto, Double precio, Integer cantidad) {
        this.id_producto = id_producto;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;        
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getImporte() {
        return precio*cantidad;
    }

}
