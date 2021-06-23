
package pe.company.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.company.model.Proveedor;
import pe.company.service.ProveedorService;
import pe.company.service.TipoDocumentoService;

/**
 *
 * @author jbustillos
 */
@Controller
public class ProveedorController {
    @Autowired
    @Qualifier("proveedorServiceImpl")
    private ProveedorService proveedorService;

    @Autowired
    @Qualifier("tipoDocumentoServiceImpl")
    private TipoDocumentoService tipoDocumentoService; 
    
    @RequestMapping(value="/proveedor",method=RequestMethod.GET)
    public String proveedor_lista_GET(Map map) {
        map.put("lProveedor", proveedorService.findAll());
        return "proveedor";
    }
    @RequestMapping(value="/proveedor", method = RequestMethod.POST, params = "btnIndex")
      public String proveedor_lista_POST()
      {
        return "redirect:Listar/index";
 
      }  
    //registrar de proveedor
    @RequestMapping(value="/proveedor_nuevo",method=RequestMethod.GET)
    public String proveedor_nuevo_GET(Model model, Map map)
    {
        Proveedor proveedorModel=new Proveedor();
        //llamo al listado de TipoDocumento para realizar el mantenimiento
        //a la pagina
        map.put("LsTipoDoc",tipoDocumentoService.findAll());        
        
        // objecto proveedor
        model.addAttribute("proveedor",proveedorModel);
    
        return "proveedor_nuevo";
    }
  

    @RequestMapping(value="/proveedor_nuevo",method=RequestMethod.POST)
    public String proveedor_nuevo_POST(Proveedor proveedor)
    {
       
        proveedorService.insert(proveedor);
        return "redirect:/proveedor";
    }

  
    //editar proveedor
    @RequestMapping(value="/proveedor_editar/{id_proveedor}",method=RequestMethod.GET)
    public String proveedor_editar_GET(Model model, Map map,@PathVariable Integer id_proveedor)
    {
        // PathVariable == cuando se va leer el dato enviado como variable
        // RequestParam == cuando se va leer un dato de la pantalla
        
        Proveedor proveedorModel=proveedorService.findById(id_proveedor);
      
        //llamo al listado de TipoDocumento 
        //a la pagina
        map.put("LsTipoDoc",tipoDocumentoService.findAll());        
        
        // objecto proveedor
         model.addAttribute("proveedor",proveedorModel);
    
        return "proveedor_editar";
    }

    @RequestMapping(value="/proveedor_editar/{id_proveedor}",method=RequestMethod.POST)
    public String proveedor_editar_POST(Proveedor proveedor)
    {
       
        proveedorService.update(proveedor);
        return "redirect:/proveedor";
    }    
    //eliminar proveedor
    @RequestMapping(value = "/proveedor_eliminar/{id_proveedor}",method=RequestMethod.GET)
    public String proveedor_eliminar_GET(Model model,Map map,@PathVariable("id_proveedor") Integer id_proveedor)
    {
        Proveedor modelProveedor =proveedorService.findById(id_proveedor);
        //para mostrar la lista
        map.put("LsTipoDoc",tipoDocumentoService.findAll());
        //es para pasar un objeto a la lista
        model.addAttribute("proveedor",modelProveedor);
        return "proveedor_eliminar";
    }
    
    @RequestMapping(value = "/proveedor_eliminar/{id_proveedor}",method = RequestMethod.POST)
    public String proveedor_eliminar_POST(Proveedor proveedor)
    {
        
        
        proveedorService.delete(proveedor.getId_proveedor());
        return "redirect:/proveedor";
    }
      
}
