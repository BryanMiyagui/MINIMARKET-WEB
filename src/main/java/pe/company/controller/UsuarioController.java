
package pe.company.controller;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.company.model.UserVo;

import pe.company.service.RoleService;
import pe.company.service.UserService;

@Controller
public class UsuarioController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("roleServiceImpl")
    private RoleService roleService;    
    
    //lista de usuario
 
    @RequestMapping(value="/usuario",method=RequestMethod.GET)
    public String usuario_lista_GET(Map map) {
        //llamo al listado de roles para realizar el mantenimiento
        //a la pagina
        map.put("Xusuario",userService.findAll());        
        return "usuario";
    }    
    
    @RequestMapping(value="/usuario", method = RequestMethod.POST, params = "btnIndex")
      public String usuario_lista_POST()
      {
        return "redirect:Listar/index";
      }
      
    //registrar de usuario
    @RequestMapping(value="/usuario_nuevo",method=RequestMethod.GET)
    public String usuario_GET(Model model,Map map)
    {
        UserVo userModel=new UserVo();
        
        model.addAttribute("userVo",userModel);
        map.put("bRoles",roleService.findAll());
        
        return "usuario_nuevo";
    }
   
    @RequestMapping(value="/usuario_nuevo",method=RequestMethod.POST)
    public String usuario_POST(Map map, 
                                   @Valid UserVo user, Errors errors)
    {
        //si hay errores de validación
        if(errors.hasErrors())
        {
            map.put("bRoles",roleService.findAll());
            return "usuario_nuevo";
        }
        
        userService.insert(user);
        return "redirect:/usuario";
    }

    // Editar  usuario

    @RequestMapping(value="/usuario_editar/{id_user}",method=RequestMethod.GET)
    public String usuario_editar_GET(Model model, Map map,
                                                    @PathVariable Integer id_user)
    {
            UserVo userModel=userService.findById(id_user);
            model.addAttribute("userVo",userModel);

            map.put("bRoles",roleService.findAll());

            return "usuario_editar";
    }

    @RequestMapping(value="/usuario_editar/{id_user}",method=RequestMethod.POST)
    public String usuario_editar_POST(UserVo userVo )
    {

            userService.update(userVo);
            return "redirect:/usuario";
    }	
	

      
   // Eliminar  usuario   
   @RequestMapping(value = "/usuario_eliminar/{id_user}",method=RequestMethod.GET)
    public String usuario_eliminar_GET(Model model, Map map,
                                                    @PathVariable Integer id_user)
    {
        
        UserVo userModel=userService.findById(id_user);
        model.addAttribute("userVo",userModel);

        map.put("bRoles",roleService.findAll());
        return "usuario_eliminar";
    }
    
    @RequestMapping(value = "/usuario_eliminar/{id_marca}", method = RequestMethod.POST)
    public String usuario_eliminar_Post(UserVo user)
    {
        
        userService.delete(user.getId_user());
        return "redirect:/usuario";
    }    
}
