/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.*;

import org.springframework.web.bind.annotation.*;



@Controller
public class HomeController 
{
    
    @RequestMapping(value={"/","/index"},method=RequestMethod.GET)
    public String index_GET() {
        return "index";
    }
    @RequestMapping(value={"/","/index"}, method = RequestMethod.POST, params = "btnIndex")
      public String index_POST()
      {
        return "redirect:Listar/login";
      }
    @RequestMapping(value="/vendedor",method=RequestMethod.GET)
    public String vendedor_GET() {
        return "vendedor";
    }
    
    @RequestMapping(value="/administrador",method=RequestMethod.GET)
    public String administradorGET() {
        return "administrador";
    }
    
    @RequestMapping(value="/almacenero",method=RequestMethod.GET)
    public String almacenero_GET() {
        return "almacenero";
    }
   /* 
    @RequestMapping(value="/clientes",method=RequestMethod.GET)
    public String clientes_GET() {
        return "clientes";
    }
    */
    
    @RequestMapping(value="/access_denied",method=RequestMethod.GET)
    public String access_denied_GET() {
        return "access_denied";
    }
    
    //cerrar sesión por spring security
    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) 
    {
        
        
        //se obtiene el usuario autenticado
        Authentication auth=SecurityContextHolder.
                            getContext().getAuthentication();
        
        //si existe el usuario autenticado, cerrar sesión
        if(auth!=null)    
        {
            //cerrar sesión
            new SecurityContextLogoutHandler().
                    logout(request,response,auth);
        }

        //si no existe el usuario autenticadi, redireccionar a login
        return "redirect:login?logout";
    }
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login() {
        return "login";
    }
    
    
    
    

}
