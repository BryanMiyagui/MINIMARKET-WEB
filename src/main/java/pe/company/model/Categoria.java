
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
import pe.company.validator.Text;

@Entity
@Table(name="categorias")
public class Categoria implements Serializable {
  
            
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_categoria;
    @Column
    private String descripcion;
    @Column
    private String estado;
    
    @OneToMany(mappedBy="categoria")
    private Collection<Producto> itemsProducto=new ArrayList();
 


    public Categoria() {
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
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
