
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
@Table(name = "ventas")
public class Venta implements  Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_venta;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd",iso=DateTimeFormat.ISO.DATE)
    private Date fecha_venta; 
    
    @Column
    private Double valor_neto;
    
    @Column
    private Double impuesto;
    
    @Column
    private Double valor_total;

    @ManyToOne
    @JoinColumn(name="id_cliente",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(id_cliente) references clientes(id_cliente)"))
    private Cliente cliente;


    @ManyToOne
    @JoinColumn(name="id_user",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(id_user) references users(id_user)"))
     private UserVo userVo;
 
     @ManyToOne
     @JoinColumn(name="id_tipoPago",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(id_tipoPago) references tipopagos(id_tipoPago)"))
     private TipoPago tipoPago;
     
     
    //lado: inverse
    @OneToMany(mappedBy="venta", fetch = FetchType.EAGER)
    private Collection<DetalleVenta> itemsDetalleVentas=new ArrayList();
   
 
    

    public Venta() {
    }

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Double getValor_neto() {
        return valor_neto;
    }

    public void setValor_neto(Double valor_neto) {
        this.valor_neto = valor_neto;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }
    
    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Collection<DetalleVenta> getItemsDetalleVentas() {
        return itemsDetalleVentas;
    }

    public void setItemsDetalleVentas(Collection<DetalleVenta> itemsDetalleVentas) {
        this.itemsDetalleVentas = itemsDetalleVentas;
    }


}
