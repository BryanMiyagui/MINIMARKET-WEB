/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.service;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.company.model.RoleVo;
import pe.company.model.UserVo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    //se inyecta la dependencia al bean "userServiceImpl"

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
        
       
        //usuario buscado por username
        UserVo userVo=userService.findByUsername(username);
        
        //si existe el usuario en la BD
        if(userVo!=null)
        {
            //coleccion roles (vacío)
            Collection<GrantedAuthority> roles=new ArrayList();
            
            //coleccion de roles (cargado)
            for(RoleVo role:userVo.getItemsRole()) {
                roles.add(new SimpleGrantedAuthority("ROLE_"+role.getType()));
            }
            
            return new User(
                    userVo.getUsername(),
                    userVo.getPassword(),
                    userVo.getState().equals("ACTIVE"),
                    true,true,true,
                    roles);
        }
        
        throw new UsernameNotFoundException("Error, "+username+" no existe en el sistema!");
    }        
}
