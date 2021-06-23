
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
@Table(name="clientes")
public class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_cliente;
    
    //@NotNull(message="Ingrese monbre!")
    //@Size(min=2, max=64)
    //@Text(value=TextType.LETTERS,message="Nombre incorrecto")
    @Column
    private String nombre;
    
   // @NotNull(message="Ingrese apellido!")
  // @Size(min=2, max=64)
    //@Text(value=TextType.LETTERS,message="Apellidos incorrecto")
    @Column
    private String apellido;
    
   // @NotNull(message="Ingrese telefono!")
   // @Size(min=2, max=9)
    @Column
    private String telefono;
    
    //@NotNull(message="Ingrese direccion!")
    //@Size(min=2, max=200)
    @Column
    private String dirreccion;
  
   //@Email(message="email incorrecto!")
    //@NotEmpty(message="Ingrese email!")
    private String email;

    @Column
   // @NotNull(message="Ingrese numero doc!")
    //@Size(min=8, max=12)
    private String nro_Doc;                
    
     @ManyToOne
     @JoinColumn(name="id_TipoDoc",nullable=false,
	            foreignKey=@ForeignKey
                    (foreignKeyDefinition="foreign key(id_TipoDoc) references tipodocumentos(id_TipoDoc)"))
     
     //@NotEmpty(message="Seleccione tipo Doc!")
    private TipoDocumento tipoDocumento;
     
    @OneToMany(mappedBy="cliente")
    private Collection<Venta> itemsVenta=new ArrayList();
 

    
    public Cliente() {
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public Collection<Venta> getItemsVenta() {
        return itemsVenta;
    }

    public void setItemsVenta(Collection<Venta> itemsVenta) {
        this.itemsVenta = itemsVenta;
    }


}
