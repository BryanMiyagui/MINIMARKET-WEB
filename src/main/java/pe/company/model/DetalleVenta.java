/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "detalleVentas")
public class DetalleVenta implements  Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_detalleVenta;
    
    @Column
    private Long cantidad;
    @Column
    private Double precio;

    private Double valor_neto;
    @Column
    private Double IGV;
    @Column
    private Double Total;

    
    @ManyToOne
    @JoinColumn(name="id_producto",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(id_producto) references productos(id_producto)"))
    private Producto producto;
   
   
     @ManyToOne
    //@ManyToMany
     @JoinColumn(name="id_venta",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(id_venta) references ventas(id_venta)"))
    private Venta venta;
     
    public DetalleVenta() {
    }

    public Integer getId_detalleVenta() {
        return id_detalleVenta;
    }

    public void setId_detalleVenta(Integer id_detalleVenta) {
        this.id_detalleVenta = id_detalleVenta;
    }


    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getValor_neto() {
        return valor_neto;
    }

    public void setValor_neto(Double valor_neto) {
        this.valor_neto = valor_neto;
    }

    public Double getIGV() {
        return IGV;
    }

    public void setIGV(Double IGV) {
        this.IGV = IGV;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    
    
    
}
