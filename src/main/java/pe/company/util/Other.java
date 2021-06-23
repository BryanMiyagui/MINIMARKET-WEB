/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author jbustillos
 */
public class Other {
    public static String CurrentUsername()
    {
        String username;
        
        Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if(principal instanceof UserDetails)
            username=((UserDetails)principal).getUsername();
        else
            username=principal.toString();
        
        return username;
    }    
}
