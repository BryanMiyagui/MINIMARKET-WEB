
package pe.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="compras")
public class Compra implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_compra;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd",iso=DateTimeFormat.ISO.DATE)
    private Date fecha_compra; 
    
    @Column
    private String numDocumento;
    
    
    @Column
    private String descripcion;
    
     @ManyToOne
     @JoinColumn(name="id_proveedor",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(id_proveedor) references proveedores(id_proveedor)"))
     private Proveedor proveedor;
     
     @ManyToOne
     @JoinColumn(name="id_user",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(id_user) references users(id_user)"))
     private UserVo userVo;
     
     //lado: inverse
    @OneToMany(mappedBy="compra", fetch = FetchType.EAGER)
    private Collection<DetalleCompra> itemsdetalleCompras=new ArrayList();
 
 
    public Compra() {
    }

    public Integer getId_compra() {
        return id_compra;
    }

    public void setId_compra(Integer id_compra) {
        this.id_compra = id_compra;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public Collection<DetalleCompra> getItemsdetalleCompras() {
        return itemsdetalleCompras;
    }

    public void setItemsdetalleCompras(Collection<DetalleCompra> itemsdetalleCompras) {
        this.itemsdetalleCompras = itemsdetalleCompras;
    }


}
