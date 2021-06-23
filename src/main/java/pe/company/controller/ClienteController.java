
package pe.company.controller;

import java.util.Map;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.company.model.Cliente;
import pe.company.service.ClienteService;
import pe.company.service.TipoDocumentoService;

@Controller
public class ClienteController {
    
    @Autowired
    @Qualifier("clienteServiceImpl")
    private ClienteService clienteService;

    @Autowired
    @Qualifier("tipoDocumentoServiceImpl")
    private TipoDocumentoService tipoDocumentoService;  
    
   //lista de Clientes
 
    @RequestMapping(value="/cliente",method=RequestMethod.GET)
    public String cliente_lista_GET(Map map) {
        //llamo al listado de clientes para realizar el mantenimiento
        //a la pagina
        map.put("lCliente",clienteService.findAll());        
        return "cliente";
    }   
     @RequestMapping(value="/cliente", method = RequestMethod.POST, params = "btnIndex")
      public String cliente_lista_POST()
      {
        return "redirect:Listar/index";
      }    
 //registrar de cliente_nuevo
    @RequestMapping(value="/cliente_nuevo",method=RequestMethod.GET)
    public String cliente_nuevo_GET(Model model, Map map)
    {
        Cliente clienteModel=new Cliente();
        

        //llamo al listado de TipoDocumento para realizar el mantenimiento
        //a la pagina
        map.put("LsTipoDoc",tipoDocumentoService.findAll());        
        
        // objecto cliente
        model.addAttribute("cliente",clienteModel);
    
        return "cliente_nuevo";
    }
  

    @RequestMapping(value="/cliente_nuevo",method=RequestMethod.POST)
    public String cliente_nuevo_POST(Cliente cliente)
    {
        clienteService.insert(cliente);
        return "redirect:/cliente";
    }    
    
    //editar cliente
    @RequestMapping(value="/cliente_editar/{id_cliente}",method=RequestMethod.GET)
    public String cliente_editar_GET(Model model, Map map,@PathVariable Integer id_cliente)
    {
        Cliente clienteModel=clienteService.findById(id_cliente);
        //llamo al listado de TipoDocumento 
        //a la pagina
        map.put("LsTipoDoc",tipoDocumentoService.findAll());        
        
        // objecto cliente
        model.addAttribute("cliente",clienteModel);
    
        return "cliente_editar";
    }
  

    @RequestMapping(value="/cliente_editar/{id_cliente}",method=RequestMethod.POST)
    public String cliente_editar_POST(Cliente cliente)
    {
       
        clienteService.update(cliente);
        return "redirect:/cliente";
    }    
    
    //eliminar cliente
    @RequestMapping(value = "/cliente_eliminar/{id_cliente}",method=RequestMethod.GET)
    public String cliente_eliminar_GET(Model model,Map map,@PathVariable("id_cliente") Integer id_cliente)
    {
        Cliente modelCliente =clienteService.findById(id_cliente);
        
        map.put("LsTipoDoc",tipoDocumentoService.findAll());
        
        model.addAttribute("cliente",modelCliente);
        return "cliente_eliminar";
    }
    
    @RequestMapping(value = "/cliente_eliminar/{id_cliente}",method = RequestMethod.POST)
    public String cliente_eliminar_POST(Cliente cliente)
    {
        clienteService.delete(cliente.getId_cliente());
        return "redirect:/cliente";
    }
}
