
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="proveedores")
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_proveedor;
    @Column
    private String nombre_Empreso;
    @Column
    private String contacto;
    @Column
    private String telefono;
    @Column
    private String dirreccion;
    
   @Column
    private String ruc;
   
    @Column
    private String email;

    @Column
    private String nro_Doc;

    
    @ManyToOne
     @JoinColumn(name="id_TipoDoc",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(id_TipoDoc) references tipodocumentos(id_TipoDoc)"))
     private TipoDocumento tipoDocumento;
    
    @OneToMany(mappedBy="proveedor")
    private Collection<Compra> itemsCompra=new ArrayList();
    
    public Proveedor() {
    }

    public Integer getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_Empreso() {
        return nombre_Empreso;
    }

    public void setNombre_Empreso(String nombre_Empreso) {
        this.nombre_Empreso = nombre_Empreso;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDirreccion() {
        return dirreccion;
    }

    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNro_Doc() {
        return nro_Doc;
    }

    public void setNro_Doc(String nro_Doc) {
        this.nro_Doc = nro_Doc;
    }


    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Collection<Compra> getItemsCompra() {
        return itemsCompra;
    }

    public void setItemsCompra(Collection<Compra> itemsCompra) {
        this.itemsCompra = itemsCompra;
    }


}
