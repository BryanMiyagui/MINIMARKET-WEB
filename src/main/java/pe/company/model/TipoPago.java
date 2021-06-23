
package pe.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipoPagos")
public class TipoPago  implements Serializable{
    
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Integer id_tipoPago;
     @Column
     private String descripcion;
     
    @OneToMany(mappedBy="tipoPago")
    private Collection<Venta> itemsVenta=new ArrayList();
    
    public TipoPago() {
    }

    public Integer getId_tipoPago() {
        return id_tipoPago;
    }

    public void setId_tipoPago(Integer id_tipoPago) {
        this.id_tipoPago = id_tipoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Venta> getItemsVenta() {
        return itemsVenta;
    }

    public void setItemsVenta(Collection<Venta> itemsVenta) {
        this.itemsVenta = itemsVenta;
    }
     
    
    
}
