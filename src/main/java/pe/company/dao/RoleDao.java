/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.dao;

import java.util.Collection;
import pe.company.model.RoleVo;

public interface RoleDao 
{
    public abstract void insert(RoleVo roleVo);
    public abstract void update(RoleVo roleVo);
    public abstract void delete(Integer id_role);
    
    public abstract RoleVo findById(Integer id_role);
    public abstract RoleVo findByType(String type);
    
    public abstract Collection<RoleVo> findAll();
    public abstract boolean isExist(Integer id_role); 
}
