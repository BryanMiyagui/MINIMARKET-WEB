
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
@Table(name="tipoDocumentos")
public class TipoDocumento implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_TipoDoc;
    @Column
    private String descripcion;
    @Column
    //@Text(value=Text.TextType.LETTERS,message="Ingresar Esatdo")
    private String estado;
    
    @OneToMany(mappedBy="tipoDocumento")
    private Collection<Cliente> itemsCliente=new ArrayList();
    
    public TipoDocumento() {
    }

    public Integer getId_TipoDoc() {
        return id_TipoDoc;
    }

    public void setId_TipoDoc(Integer id_TipoDoc) {
        this.id_TipoDoc = id_TipoDoc;
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
    
    
}
