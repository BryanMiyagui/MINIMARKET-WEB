/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
import pe.company.model.Cliente;
import pe.company.model.DetalleVenta;
import pe.company.model.DetalleVenta2;
import pe.company.model.Producto;
import pe.company.model.TipoPago;
import pe.company.model.UserVo;
import pe.company.model.Venta;
import pe.company.service.ClienteService;
import pe.company.service.DetalleVentaService;
import pe.company.service.ProductoService;
import pe.company.service.TipoPagoService;
import pe.company.service.UserService;
import pe.company.service.VentaService;

@Controller
public class VentaController {
    
    @Autowired
    @Qualifier("ventaServiceImpl")
    private VentaService ventaService;
    
    @Autowired
    @Qualifier("productoServiceImpl")
    private ProductoService productoService;
    
    @Autowired
    @Qualifier("clienteServiceImpl")
    private ClienteService clienteService;
    
    @Autowired
    @Qualifier("tipoPagoServiceImpl")
    private TipoPagoService tipoPagoService;
    
    @Autowired
    @Qualifier("detalleVentaServiceImpl")
    private DetalleVentaService detalleVentaService;
    
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
     //Detalle de venta
   // private static final List<DetalleCompra> listaDeCompra=new ArrayList();
    private static Collection<Item> carritoVenta=new ArrayList();        
    
    private static Double gSubtotal = 0.0;
    private static Double gIvgtotal = 0.0;
    private static Double gtotal = 0.0;
    
    private static Cliente gCliente = new Cliente();
    private static TipoPago gTipoPago = new TipoPago();
    
    
    //mantenimiento compra 
    @RequestMapping(value={"/venta"},method=RequestMethod.GET)
    public String venta_GET(Map map) { 
  
        map.put("lVenta", ventaService.findAll()); 
        
        return "venta";
    }
    
    @RequestMapping(value="/venta", method = RequestMethod.POST, params = "btnIndex")
    public String compra_POST()
    {
        return "redirect:Listar/index";
    }
    
    // Regsitro de compra

    @RequestMapping(value="/venta_nuevo",method=RequestMethod.GET)
    public String venta_nuevo_GET(Model model, Map map,
            @RequestParam(value = "id_producto", required = false) String id_producto,
            @RequestParam(value = "cantidad", required = false) Integer cantidad
            )
    {
            //Date fdia = Date();
            Date dt= new Date();
            SimpleDateFormat fecha=new SimpleDateFormat("yyyy-MM-dd");
            String fechaventaFormato = fecha.format(dt); 

            //Usuario logeado

            Authentication usuarioLogeado=SecurityContextHolder.
                                getContext().getAuthentication();

            //-- Tabla Compra  --/
            // Objeto Compra
            Venta modelVenta=new Venta();

            modelVenta.setFecha_venta(dt);
            
             if(usuarioLogeado!=null)    
            {            
                UserVo usuario = userService.findByUsername(usuarioLogeado.getName());
                modelVenta.setUserVo(usuario);
            }          

            modelVenta.setCliente(gCliente);
            modelVenta.setTipoPago(gTipoPago);
        
            model.addAttribute("venta",modelVenta);

            // lista de proveedor
            map.put("lsCliente",clienteService.findAll());
            //lista de Tipo Pago
            map.put("lsTipoPago",tipoPagoService.findAll());

            //lista de producto
            map.put("lsProducto",productoService.findAll());  
            
            map.put("bCarritoVenta",carritoVenta);
            
      
            map.put("bSubTotal",gSubtotal);
            map.put("bIgv",gIvgtotal);
            map.put("bTotal",gtotal);
                    
            
            //-- Tabla Venta_Detalle  --/
            Collection<DetalleVenta> itemsdetalleVenta=new ArrayList();

            //Objeto Venta_Detalle
            DetalleVenta modelDetalleCompra= new  DetalleVenta();

            model.addAttribute("compraDetalle",modelDetalleCompra);

            //lista de producto
            map.put("lsDetalleCompra",itemsdetalleVenta);  



          //  map.put("bCarrito",carrito);


            return "venta_nuevo";
        }  
    
     
    @RequestMapping(value="/venta_nuevo",method=RequestMethod.POST,params = "btnAdicionar")
    public String venta_nuevo_POST1(Venta venta, Map map, @RequestParam(value = "id_producto", required = false) String id_producto,
            @RequestParam(value = "cantidad", required = false) Integer cantidad
    )
    {
        gCliente = venta.getCliente();
        gTipoPago = venta.getTipoPago();
        
        
        Producto producto=productoService.findById(id_producto);
        
        // Verificar el Stock
        if(producto.getStock() >= cantidad)
        {
            Item item=new Item(producto.getId_producto(),producto.getNombre(),producto.getPrecio(),cantidad);
            Double importe = 0.0;
            carritoVenta.add(item);

            gSubtotal = gSubtotal + ((producto.getPrecio() * cantidad) - ((producto.getPrecio() * cantidad) * 0.18));
            gIvgtotal = gIvgtotal + ((producto.getPrecio() * cantidad) * 0.18);
            importe = (producto.getPrecio() * cantidad);
            gtotal = gtotal + importe;
        }
        else
        {
            // Mostrar mensaje de falta de Stock.
            
            JOptionPane.showMessageDialog(null, "La cantidad de venta supera al Stock");
            
        }
        return "redirect:/venta_nuevo";

    }   

   
    
    @RequestMapping(value="/venta_nuevo",method=RequestMethod.POST,params = "btnGuardar")
    public String venta_nuevo_POST2(Venta venta)
    {
        Authentication auth=SecurityContextHolder.
                            getContext().getAuthentication();
        
        //si existe el usuario autenticado, cerrar sesión
        if(auth!=null)    
        {            
            UserVo usuario = userService.findByUsername(auth.getName());
            venta.setUserVo(usuario);
        }
        
        venta.setValor_neto(gSubtotal);
        venta.setImpuesto(gIvgtotal);
        venta.setValor_total(gtotal);


        
        ventaService.insert(venta);
        
 
        
        //Crear Objeto detalle en blanco
       // DetalleVenta dt = new DetalleVenta();
        Producto producto = new Producto();
        
        
        DetalleVenta2 dventa=new DetalleVenta2();
        Integer nuevostock = 0;
        
        for(Item item:carritoVenta)
        {
      
            
            producto=productoService.findById(item.getId_producto());
            
            nuevostock = producto.getStock() - item.getCantidad();
            producto.setStock(nuevostock);
            
           
            
            productoService.update(producto);
            
            System.out.println("cambio stock");
            
            dventa.setId_venta(venta.getId_venta());
            dventa.setId_producto(item.getId_producto());
            dventa.setPrecio(item.getPrecio());
            dventa.setCantidad(item.getCantidad());
            dventa.setValorneto(item.getPrecio() * item.getCantidad());
            dventa.setIgv(((item.getPrecio() * item.getCantidad())* 0.18));
            dventa.setTotal(item.getPrecio() * item.getCantidad());
               
        
            detalleVentaService.insertJDBC(dventa);  
            

        }
        
        
        carritoVenta.clear();
        
        return "redirect:/venta";
    }    
 
    
    @RequestMapping(value="/venta_nuevo",method=RequestMethod.POST,params = "btnCancelar")
    public String venta_nuevo_POST3(Venta venta)
    {

        carritoVenta.clear();
        gSubtotal = 0.0;
        gIvgtotal = 0.0;
        gtotal = 0.0;
        gCliente = null;
        gTipoPago = null;
        
        
        return "redirect:/venta";
    }     
    
}
