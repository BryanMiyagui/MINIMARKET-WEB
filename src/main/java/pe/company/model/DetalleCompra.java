
package pe.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "detalleCompras")
public class DetalleCompra implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_detalleCompra;
    
    @Column
    private Integer cantidad;
    
    @ManyToOne
    @JoinColumn(name="id_producto",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(id_producto) references productos(id_producto)"))
    private Producto producto;
   
    
    @ManyToOne
    //@ManyToMany
     @JoinColumn(name="id_compra",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(id_compra) references compras(id_compra)"))
    private Compra compra;


    public DetalleCompra() {
    }

    public Integer getId_detalleCompra() {
        return id_detalleCompra;
    }

    public void setId_detalleCompra(Integer id_detalleCompra) {
        this.id_detalleCompra = id_detalleCompra;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }


    
}
