/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import pe.company.validator.Text;

@Entity
@Table(name="users")
public class UserVo implements Serializable 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_user;    
 
    @Column(unique=true,nullable=false)
    @Text(value=Text.TextType.USERNAME,message="Username incorrecto!")
    private String username;
    
    @Column(nullable=false)
    @Text(value=Text.TextType.PASSWORD,message="Password incorrecto!")
    private String password;    
    
    @Column
    @Text(value=Text.TextType.LETTERS,message="Nombre incorrecto")
    private String nombre;
    
    @Column
    @Text(value=Text.TextType.LETTERS,message="Apellidos incorrecto")
    private String apellidos;
    
    @Column(unique=true,nullable=false)
    @Email(message="correo incorrecto!")
    @NotEmpty(message="Ingrese correo!")
    private String correo;
    
    @Column
    @NotNull(message="Ingrese telefono!")
    private Long telefono;    
    
    @Column
    private String state=StateType.ACTIVE.name();
    
    //lado:owner
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="users_roles",
               joinColumns=@JoinColumn(name="id_user",foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(id_user) references users(id_user)")),
               inverseJoinColumns=@JoinColumn(name="id_role",foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(id_role) references roles(id_role)")))
    @NotEmpty(message="Seleccione rol(es)!")
    
    private Set<RoleVo> itemsRole=new HashSet();
   
    @OneToMany(mappedBy="userVo")
    private Collection<Compra> itemsCompra=new ArrayList();
    
    @OneToMany(mappedBy="userVo")
    private Collection<Venta> itemsVenta=new ArrayList();
    
    //métodos equals and hashCode (evitar duplicidad)
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserVo other = (UserVo) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    public UserVo() {
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<RoleVo> getItemsRole() {
        return itemsRole;
    }

    public void setItemsRole(Set<RoleVo> itemsRole) {
        this.itemsRole = itemsRole;
    }

    public Collection<Compra> getItemsCompra() {
        return itemsCompra;
    }

    public void setItemsCompra(Collection<Compra> itemsCompra) {
        this.itemsCompra = itemsCompra;
    }

    public Collection<Venta> getItemsVenta() {
        return itemsVenta;
    }

    public void setItemsVenta(Collection<Venta> itemsVenta) {
        this.itemsVenta = itemsVenta;
    }

}
