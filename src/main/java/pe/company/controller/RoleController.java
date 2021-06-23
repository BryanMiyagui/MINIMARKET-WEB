
package pe.company.controller;

import java.util.Map;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.company.model.RoleVo;
import pe.company.service.RoleService;

@Controller
public class RoleController {
    
    @Autowired
    @Qualifier("roleServiceImpl")
    private RoleService roleService;   
    
    // Mantenimiento de Rol
    @RequestMapping(value="/roles",method=RequestMethod.GET)
    public String roles_GET(Map map) {
        //llamo al listado de roles para realizar el mantenimiento
        //a la pagina
        map.put("Lsroles",roleService.findAll());        
        return "roles";
    }    
    
    @RequestMapping(value="/roles", method = RequestMethod.POST, params = "btnIndex")
      public String roles_POST()
      {
        return "redirect:Listar/index";
      }
    
    // Mantenimiento de marca (Nuevo)    
    // cuando se llama a la ventana nuevo roles   (GET) 
    @RequestMapping(value = "/roles_nuevo" ,method=RequestMethod.GET)
    public String roles_nuevo_GET(Model model){

        //Creamos la variable de registro de Marca en blanco tabla Marca
        RoleVo modelRoleVo= new RoleVo();
        
        
        JOptionPane.showMessageDialog(null, "Informacion"+modelRoleVo.getType());
        
        // Envias por parametro a la pagina WEB, renombrando la variable creada como (Marca)
        model.addAttribute("roles", modelRoleVo);
  
        return "roles_nuevo";
    }
    
    // cuando dar guardar en la ventana registrar role   (POST)
    @RequestMapping(value = "/roles_nuevo", method = RequestMethod.POST)
    //public String roles_nuevo_Post(){
    public String roles_nuevo_Post(RoleVo roleVo){
    
        // recibe la variable (roles) y lo envia al servicio insert
        roleService.insert(roleVo);           

        return "redirect:/roles";

    }
}
