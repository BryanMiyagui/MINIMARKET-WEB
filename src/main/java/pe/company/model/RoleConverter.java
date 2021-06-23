/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import pe.company.service.RoleService;

//Clase convertidor, recibe id_objeto y retorna el Objeto RoleVo
public class RoleConverter implements Converter<Object,RoleVo>
{
    @Autowired
    @Qualifier("roleServiceImpl")
    private RoleService roleService;

    @Override
    public RoleVo convert(Object id_object) 
    {
        Integer id_role=Integer.parseInt(id_object.toString());
        RoleVo role=roleService.findById(id_role);
        
        return role;
    }            
}
