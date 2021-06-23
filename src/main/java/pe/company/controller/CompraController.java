
package pe.company.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.company.model.Compra;
import pe.company.model.DetalleCompra;
import pe.company.model.DetalleCompra2;
import pe.company.model.Producto;
import pe.company.model.Proveedor;
import pe.company.model.UserVo;
import pe.company.service.CompraService;
import pe.company.service.DetalleCompraService;
import pe.company.service.ProductoService;
import pe.company.service.ProveedorService;
import pe.company.service.UserService;

@Controller
public class CompraController {
    
    @Autowired
    @Qualifier("productoServiceImpl")
    private ProductoService productoService;
    
    @Autowired
    @Qualifier("proveedorServiceImpl")
    private ProveedorService proveedorService;
    
    @Autowired
    @Qualifier("compraServiceImpl")
    private CompraService compraService;
    
    @Autowired
    @Qualifier("detalleCompraServiceImpl")
    private DetalleCompraService detalleCompraService;
    
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    
    
    //Detalle de compra
    
    private static Collection<Item> carrito=new ArrayList();    

    private static Proveedor gProveedor=new Proveedor(); 
    
    private static String gNroDocumento=""; 
    private static String gDescripcion=""; 
    //mantenimiento compra 
    @RequestMapping(value={"/compra"},method=RequestMethod.GET)
    public String compra_GET(Map map) { 
  
        map.put("lCompra", compraService.findAll());   
        return "compra";
    }
    
    
    @RequestMapping(value="/compra", method = RequestMethod.POST, params = "btnIndex")
      public String compra_POST()
      {
        return "redirect:Listar/index";
      }
      
     //registrar de compra
    @RequestMapping(value="/compra_nuevo",method=RequestMethod.GET)
    public String compra_nuevo_GET(Model model, Map map,
            @RequestParam(value = "id_producto", required = false) String id_producto,
            @RequestParam(value = "cantidad", required = false) Integer cantidad
            )
    {
        //Date fdia = Date();
        Date dt= new Date();
        SimpleDateFormat fecha=new SimpleDateFormat("yyyy-MM-dd");
        String fechacompraFormato = fecha.format(dt); 
 
        //Usuario logeado
        
         Authentication usuarioLogeado=SecurityContextHolder.
                            getContext().getAuthentication();
        
        //si existe el usuario autenticado, cerrar sesión

        //-- Tabla Compra  --/
        // Objeto Compra
        Compra modelCompra=new Compra();
        
        modelCompra.setFecha_compra(dt);
         if(usuarioLogeado!=null)    
        {            
            UserVo usuario = userService.findByUsername(usuarioLogeado.getName());
            modelCompra.setUserVo(usuario);
        }          
        modelCompra.setProveedor(gProveedor);
        modelCompra.setNumDocumento(gNroDocumento);
        modelCompra.setDescripcion(gDescripcion);
        
        model.addAttribute("compra",modelCompra);
        
        // lista de proveedor
        map.put("lsProveedor",proveedorService.findAll());
 
        //-- Tabla Compra_Detalle  --/
        Collection<DetalleCompra> itemsdetalleCompras=new ArrayList();
                
        //Objeto Compra_Detalle
        DetalleCompra modelDetalleCompra= new DetalleCompra();
        
        model.addAttribute("compraDetalle",modelDetalleCompra);

        //lista de producto
        map.put("lsDetalleCompra",itemsdetalleCompras);  
        
        //lista de producto
        map.put("lsProducto",productoService.findAll());  
        
        
        map.put("bCarrito",carrito);
   
    
        return "compra_nuevo";
    }  


    
    @RequestMapping(value="/compra_nuevo",method=RequestMethod.POST,params = "btnAdicionar")
    public String compra_nuevo_POST1(Compra compra, @RequestParam(value = "id_producto", required = false) String id_producto,
            @RequestParam(value = "cantidad", required = false) Integer cantidad
    )
    {
        Producto producto=productoService.findById(id_producto);
        
        Item item=new Item(producto.getId_producto(),producto.getNombre(),producto.getPrecio(),cantidad);
        
        gProveedor = compra.getProveedor();
        gNroDocumento =compra.getNumDocumento();
        gDescripcion = compra.getDescripcion();
        carrito.add(item);
        
        return "redirect:/compra_nuevo";
        

    }

    @RequestMapping(value="/compra_nuevo",method=RequestMethod.POST,params = "btnGuardar")
    public String compra_nuevo_POST2(Compra compra)
    {
        Authentication auth=SecurityContextHolder.
                            getContext().getAuthentication();
        
        //si existe el usuario autenticado, cerrar sesión
        if(auth!=null)    
        {            
            UserVo usuario = userService.findByUsername(auth.getName());
            compra.setUserVo(usuario);
        }
        
        
 
            System.out.println("id_compra: "+compra.getDescripcion());
            System.out.println("id_producto: "+compra.getFecha_compra());
            System.out.println("cantidad: "+compra.getNumDocumento());
            
        
        //Crear Objeto detalle en blanco
        DetalleCompra dt = new DetalleCompra();
        Producto producto = new Producto();
        DetalleCompra2 dcompra=new DetalleCompra2();
        Integer nuevostock = 0;
        
        System.out.println(""+compra.getProveedor().getId_proveedor());
        System.out.println(""+compra.getUserVo().getUsername()); 
        
        compraService.insert(compra);
        
        for(Item item:carrito)
        {
            producto=productoService.findById(item.getId_producto());
            
            nuevostock = producto.getStock() + item.getCantidad();
            producto.setStock(nuevostock);
            productoService.update(producto);

                
            dcompra.setCantidad(item.getCantidad());
            dcompra.setId_compra(compra.getId_compra());
            dcompra.setId_producto(item.getId_producto());
                

            detalleCompraService.insertJDBC(dcompra);  
            

        }
       
        
        carrito.clear();
        
        return "redirect:/compra";
    }
    
}
