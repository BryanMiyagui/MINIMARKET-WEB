/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name="roles")
public class RoleVo implements Serializable 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_role;
   //@Column
   // private String descripcion;
    
    @Column
    private String type=RoleType.ADMINISTRADOR.name();
  
    
    //lado:inverse
    @ManyToMany(mappedBy="itemsRole",fetch=FetchType.EAGER)
    private Set<UserVo> itemsUser=new HashSet();
   
    
    //métodos equals and hashCode (evitar duplicidad)
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id_role);
        hash = 31 * hash + Objects.hashCode(this.type);
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
        final RoleVo other = (RoleVo) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.id_role, other.id_role)) {
            return false;
        }
        return true;
    }    

    public RoleVo() {
    }

    public Integer getId_role() {
        return id_role;
    }

    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<UserVo> getItemsUser() {
        return itemsUser;
    }

    public void setItemsUser(Set<UserVo> itemsUser) {
        this.itemsUser = itemsUser;
    }

}
