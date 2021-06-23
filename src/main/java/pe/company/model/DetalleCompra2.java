
package pe.company.model;

public class DetalleCompra2 
{
    private Integer id_detalle_compra;
    private Integer id_compra;
    private String id_producto;
    private Integer cantidad;

    public DetalleCompra2() {
    }

    public DetalleCompra2(Integer id_detalle_compra, Integer id_compra, String id_producto, Integer cantidad) {
        this.id_detalle_compra = id_detalle_compra;
        this.id_compra = id_compra;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }
    
    public DetalleCompra2(Integer id_compra, String id_producto, Integer cantidad) {
        this.id_compra = id_compra;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }

    public Integer getId_detalle_compra() {
        return id_detalle_compra;
    }

    public void setId_detalle_compra(Integer id_detalle_compra) {
        this.id_detalle_compra = id_detalle_compra;
    }

    public Integer getId_compra() {
        return id_compra;
    }

    public void setId_compra(Integer id_compra) {
        this.id_compra = id_compra;
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
}
