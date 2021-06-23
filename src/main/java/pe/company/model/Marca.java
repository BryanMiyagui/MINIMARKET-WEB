
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
@Table(name="marcas")
public class Marca implements Serializable {
               
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_marca;
    @Column
    private String descripcion;
    @Column
    private String estado;
    
    @OneToMany(mappedBy="marca")
    private Collection<Producto> itemsProducto=new ArrayList();
    
    public Marca() {
    }

    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<Producto> getItemsProducto() {
        return itemsProducto;
    }

    public void setItemsProducto(Collection<Producto> itemsProducto) {
        this.itemsProducto = itemsProducto;
    }


}
