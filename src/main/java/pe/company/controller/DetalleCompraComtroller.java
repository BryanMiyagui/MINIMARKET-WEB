
package pe.company.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.company.service.DetalleCompraService;
import pe.company.service.ProductoService;

@Controller
public class DetalleCompraComtroller {
    
    @Autowired
    @Qualifier("productoServiceImpl")
    private ProductoService productoService;
    
    @Autowired
    @Qualifier("detalleCompraServiceImpl")
    private DetalleCompraService detalleCompraService;
    
        //mantenimiento compra 
    @RequestMapping(value={"/detalleCompra"},method=RequestMethod.GET)
    public String detalleCompra_GET(Map map) { 
  
        //map.put("lProducto",productoService.findAll()); 
        map.put("lDetalleCompra",detalleCompraService.findAll());   
        return "detalleCompra";
    }
    @RequestMapping(value="/detalleCompra", method = RequestMethod.POST, params = "btnIndex")
      public String detalleCompra_POST()
      {
        return "redirect:Listar/index";
      }
}
