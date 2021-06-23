
package pe.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="productos")
public class Producto implements Serializable{
    
    	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id_producto;
        
	@Column
        //@Text(value=Text.TextType.LETTERS,message="Nombre incorrecto!")
	private String nombre;
        
        @Column
        //@Text(value=Text.TextType.LETTERS,message="Ingresa Unidad de Medida!")
	private String unidadMedida;
        @Column
       // @NotNull(message="Ingrese precio!")
	private Double precio;
	
        @Temporal(TemporalType.DATE)
        @DateTimeFormat(pattern="yyyy-MM-dd",iso=DateTimeFormat.ISO.DATE)
        //@NotNull(message="Seleccione fecha nacimiento!")
	private Date fecha_vencimiento;
	
        @Column
        //@NotNull(message="Ingrese Stock!")
	private Integer stock;
        
	@ManyToOne
	@JoinColumn(name="id_categoria",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(id_categoria) references categorias(id_categoria)"))
       // @NotEmpty(message="Seleccione categoria!")
        
	private Categoria categoria;
        
        @ManyToOne
	@JoinColumn(name="id_marca",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(id_marca) references marcas(id_marca)"))
        //@NotEmpty(message="Seleccione Marca")
	private Marca marca;

        @OneToMany(mappedBy="producto")
        private Collection<DetalleCompra> itemsDetalleCompra=new ArrayList();    

     
    public Producto() {
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Collection<DetalleCompra> getItemsDetalleCompra() {
        return itemsDetalleCompra;
    }

    public void setItemsDetalleCompra(Collection<DetalleCompra> itemsDetalleCompra) {
        this.itemsDetalleCompra = itemsDetalleCompra;
    }

}
