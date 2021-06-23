
package pe.company.controller;

import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.company.model.Producto;
import pe.company.service.CategoriaService;
import pe.company.service.MarcaService;
import pe.company.service.ProductoService;

@Controller
public class ProductoController {
    
    @Autowired
    @Qualifier("productoServiceImpl")
    private ProductoService productoService;

    @Autowired
    @Qualifier("marcaServiceImpl")
    private MarcaService marcaService;  
    
    @Autowired
    @Qualifier("categoriaServiceImpl")
     private CategoriaService categoriaService;	
    
    
   //lista de producto
 
    @RequestMapping(value="/producto",method=RequestMethod.GET)
    public String producto_lista_GET(Map map) {
        //llamo al listado de producto para realizar el mantenimiento
        //a la pagina
        map.put("lProducto",productoService.findAll());        
        return "producto";
    }   
     @RequestMapping(value="/producto", method = RequestMethod.POST, params = "btnIndex")
      public String producto_lista_POST()
      {
        return "redirect:Listar/index";
      }
      
     @RequestMapping(value="/producto", method = RequestMethod.POST, params = "btnbuscar")
      public String producto_lista_POST2(Map map, @RequestParam(value = "nombreBuscar", required = false) String nombreBuscar)
      {
      
          JOptionPane.showMessageDialog(null, "cacccc");
        
        map.put("lProducto",productoService.findNombre(nombreBuscar));   
        return "producto";
      }
            
     //registrar de producto
    @RequestMapping(value="/producto_nuevo",method=RequestMethod.GET)
    public String producto_GET(Model model, Map map)
    {
        Producto productoModel=new Producto();

        // lista de marca
        map.put("lstmarca",marcaService.findAll());
        // lista de categoria
        map.put("lstcategoria",categoriaService.findAll());
        // objecto producto
        model.addAttribute("producto",productoModel);
    
        return "producto_nuevo";
    }
  

    @RequestMapping(value="/producto_nuevo",method=RequestMethod.POST)
    public String producto_POST(Producto producto)
    {
        // para lo producto nuevo el stock inicial es igual a cero
        producto.setStock(0);
       
        productoService.insert(producto);
        return "redirect:/producto";
    }
        // Editar  producto

    @RequestMapping(value="/producto_editar/{id_producto}",method=RequestMethod.GET)
    public String producto_editar_GET(Model model, Map map,
                                                    @PathVariable String id_producto)
    {
        Producto productoModel=productoService.findById(id_producto);
        model.addAttribute("producto",productoModel);

         // lista de marca
        map.put("lstmarca",marcaService.findAll());
        // lista de categoria
        map.put("lstcategoria",categoriaService.findAll());
        // oblecto producto

            return "producto_editar";
    }

    @RequestMapping(value="/producto_editar/{id_producto}",method=RequestMethod.POST)
    public String producto_editar_POST(Producto producto )
    {

            productoService.update(producto);
            return "redirect:/producto";
    }	
     // eliminar  producto

    @RequestMapping(value="/producto_eliminar/{id_producto}",method=RequestMethod.GET)
    public String producto_eliminar_GET(Model model, Map map,
                                                    @PathVariable String id_producto)
    {
        Producto productoModel=productoService.findById(id_producto);
        model.addAttribute("producto",productoModel);

         // lista de marca
        map.put("lstmarca",marcaService.findAll());
        // lista de categoria
        map.put("lstcategoria",categoriaService.findAll());
        // oblecto producto

            return "producto_eliminar";
    }

    @RequestMapping(value="/producto_eliminar/{id_producto}",method=RequestMethod.POST)
    public String producto_eliminar_POST(Producto producto )
    {

            productoService.delete(producto.getId_producto());
            return "redirect:/producto";
    }	

  
}
